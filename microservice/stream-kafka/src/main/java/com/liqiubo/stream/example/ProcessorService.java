package com.liqiubo.stream.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class ProcessorService {
//    @Autowired
//    private Processor processor;
//
//    public boolean write(String content) {
//        return processor.output().send(MessageBuilder.withPayload(content).build());
//    }
//
//    public boolean subscribe(MessageHandler handler) {
//        return processor.input().subscribe(handler);
//    }
}
