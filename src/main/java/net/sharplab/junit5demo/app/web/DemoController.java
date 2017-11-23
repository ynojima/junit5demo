package net.sharplab.junit5demo.app.web;

import net.sharplab.junit5demo.domain.service.GreetingService;
import net.sharplab.junit5demo.domain.service.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ynojima on 2017/11/23.
 */
@Controller
public class DemoController {

    @Autowired
    GreetingService greetingService;

    @RequestMapping("/")
    public String greeting(Model model){
        Message message = greetingService.sayHello();
        model.addAttribute("message", message);
        return "index";
    }
}
