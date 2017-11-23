package net.sharplab.junit5demo.domain.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {
    @Override
    public Message sayHello() {
        return new MessageImpl("Hello world");
    }
}
