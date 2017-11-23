package net.sharplab.junit5demo.app.web;

import com.example.mockito.MockitoExtension;
import net.sharplab.junit5demo.domain.service.GreetingService;
import net.sharplab.junit5demo.domain.service.Message;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@ExtendWith(SpringExtension.class) //  Spring Extensionを使用するためのJUnit5のアノテーション
@ExtendWith(MockitoExtension.class)// Mockito Extensionを使用するためのJUnit5のアノテーション
@WebMvcTest                        //テストを実行するためのSpringのアノテーション
@Tag("IntegrationTest")            //テストに付加情報を与えるためのJUnit5のアノテーション
                                   //JUnit4の@Categoryアノテーション相当
class DemoControllerJUnit5Test {

    @MockBean
    GreetingService greetingService;

    @Test
    void greeting_test(@Autowired MockMvc mockMvc, @Mock Message message) throws Exception{
        when(message.getValue()).thenReturn("Hello world");
        when(greetingService.sayHello()).thenReturn(message);
        mockMvc.perform(get("/"))
                .andExpect(model().attribute("message", hasProperty("value", is("Hello world"))));
    }
}
