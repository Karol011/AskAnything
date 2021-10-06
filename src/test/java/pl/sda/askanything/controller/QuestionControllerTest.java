package pl.sda.askanything.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;
import pl.sda.askanything.dto.QuestionDto;
import pl.sda.askanything.entity.User;
import pl.sda.askanything.service.MyUserDetailsService;
import pl.sda.askanything.service.QuestionService;
import pl.sda.askanything.utility.QuestionMapper;

@WebMvcTest(QuestionController.class)
class QuestionControllerTest {

    @Autowired
    private MockMvc mvc;

    @Mock
    private WebApplicationContext webApplicationContext;

    @MockBean
    private QuestionService questionService;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    QuestionMapper questionMapper;

    @MockBean
    private MyUserDetailsService myUserDetailsService;

    @InjectMocks
    private QuestionController questionController;

    @Test
    public void shouldCreateQuestion() throws Exception {
        String url = "/questions";
        QuestionDto questionDto = new QuestionDto(
                1L,
                new User( "Karol", "Karolskyy", "superSecretPassword", null),
                "some random question");
        mvc.perform(MockMvcRequestBuilders.post(url)
                .content(objectMapper.writeValueAsString(questionDto))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andReturn();
    }
}
