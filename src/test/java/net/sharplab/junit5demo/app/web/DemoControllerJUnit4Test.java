package net.sharplab.junit5demo.app.web;

import net.sharplab.junit5demo.domain.service.GreetingService;
import net.sharplab.junit5demo.domain.service.Message;
import net.sharplab.junit5demo.test.junit4.IntegrationTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@Category(IntegrationTest.class)
@RunWith(SpringRunner.class)
@WebMvcTest
public class DemoControllerJUnit4Test {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private GreetingService greetingService;

    @Test
    public void greeting_test() throws Exception {
        Message message = mock(Message.class);
        when(message.getValue()).thenReturn("Hello world");
        when(greetingService.sayHello()).thenReturn(message);
        mockMvc.perform(get("/")).andExpect(model().attribute("message", hasProperty("value", is("Hello world"))));
    }
}
