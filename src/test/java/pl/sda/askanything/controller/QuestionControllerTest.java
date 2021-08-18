package pl.sda.askanything.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.gson.Gson;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import pl.sda.askanything.entity.Question;
import pl.sda.askanything.entity.User;
import pl.sda.askanything.service.MyUserDetailsService;
import pl.sda.askanything.service.QuestionService;

import java.io.IOException;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(QuestionController.class)
class QuestionControllerTest {

    private MockMvc mvc;

    @Mock
    private WebApplicationContext webApplicationContext;


    Question question = new Question(
            1L,
            new User(1L,"Karol","Karolskyy","superSecretPassword",null),
            null,
            "super text");

    @MockBean
    private QuestionService questionService;

    @MockBean
    private MyUserDetailsService myUserDetailsService;

    @InjectMocks
    private QuestionController questionController;


    @Before("shouldCreateQuestion")
    public void before() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    @BeforeEach
    void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(questionController)
                .build();
        Mockito.when(questionService.save(Mockito.any())).thenReturn(question);
    }

    @Test
    public void shouldCreateQuestion() throws Exception {
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post("/questions")
                .content(new Gson().toJson(question))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andReturn();

        Question question = parseResponse(mvcResult, Question.class);
        Assertions.assertEquals("Some random message", question.getText());

    }

    private static final ObjectMapper MAPPER = new ObjectMapper()
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .registerModule(new JavaTimeModule());


    public static <T> T parseResponse(MvcResult result, Class<T> responseClass) {
        try {
            String contentAsString = result.getResponse().getContentAsString();
            return MAPPER.readValue(contentAsString, responseClass);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
