package com.example.task04;

public class ConsoleHandler implements MessageHandler {

    @Override
    public void handle(String msg){
        System.out.println(msg);
    }
}
