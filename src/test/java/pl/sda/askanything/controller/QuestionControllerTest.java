/*
package pl.sda.askanything.controller;

import com.google.gson.Gson;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import pl.sda.askanything.entity.Question;
import pl.sda.askanything.entity.User;
import pl.sda.askanything.service.MyUserDetailsService;
import pl.sda.askanything.service.QuestionService;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(QuestionController.class)
class QuestionControllerTest {

    private MockMvc mvc;

    //nie mam pojecia co to jest i po co to ale tak bylo na stackOverflow
*/
/*    @Mock
    private WebApplicationContext webApplicationContext;*//*



    Question question = Question.builder()
            .id(1L)
            .asker(new User(1L, "Karol", "Karolsky", "superSercretPassword", null))
            .text("Some random message")
            .build();

    @Mock
    private QuestionService questionService;

    @Mock
    private MyUserDetailsService myUserDetailsService;

    @InjectMocks
    private QuestionController questionController;


 */
/*   @Before("shouldCreateQuestion")
    public void before() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }*//*


    @BeforeEach
    void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(questionController)
                .build();
    }

    */
/*@Test
    public void shouldCreateQuestion() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/questions")
                .content(new Gson().toJson(question))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated());

    }*//*


    @Test
    public void shouldCreateQuestion2() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.post("/questions"))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().json(new Gson().toJson(question)));

    }


}*/
