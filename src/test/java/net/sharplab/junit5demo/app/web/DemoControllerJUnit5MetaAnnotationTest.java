package net.sharplab.junit5demo.app.web;

import net.sharplab.junit5demo.domain.service.GreetingService;
import net.sharplab.junit5demo.domain.service.Message;
import net.sharplab.junit5demo.test.junit5.IntegrationTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@IntegrationTest //自作合成アノテーション
class DemoControllerJUnit5MetaAnnotationTest {

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
