package com.example.task04;

import java.util.ArrayDeque;
import java.util.Objects;

public class MemoryHandler implements MessageHandler{
    private final ArrayDeque<String> messages;
    private final MessageHandler handler;
    private final int limit;

    public MemoryHandler(MessageHandler handler, int limit){
        if(limit <= 0){
            throw new IllegalArgumentException("limit не может быть меньше 0");
        }
        this.limit = limit;
        this.messages = new ArrayDeque<String>(this.limit);
        this.handler = Objects.requireNonNull(handler);
    }

    @Override
    public void handle(String msg){
        messages.add(msg);
        if (messages.size() >= limit){
            flush();
        }
    }

    public void flush(){
        while (messages.size() != 0){
            handler.handle(messages.poll());
        }
    }
}
