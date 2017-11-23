package net.sharplab.junit5demo.domain.service;

public class MessageImpl implements Message {

    private String value;

    public MessageImpl(String value){
        this.value = value;
    }

    @Override
    public String getValue(){
        return value;
    }
}
