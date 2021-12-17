package com.liqiubo.stream.controller;

import com.liqiubo.stream.channel.OrderChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    @Qualifier(OrderChannel.ORDER_OUTPUT)
    private MessageChannel sendMessageChannel;

//    @GetMapping("/sendMessage")
//    public String sendShopMessage(String content) {
//        boolean success = sendMessageChannel.
//                send(MessageBuilder.withPayload(content).build());
//        return success ? "success" : "failed";
//    }

    @GetMapping("/sendMessage")
    public String sendShopMessage(String content) {
        String header = "";
        if (content.equals("bar"))
            header = "Bar";

        if (content.equals("foo"))
            header = "Foo";

        boolean success = sendMessageChannel.send(MessageBuilder.withPayload(content)
                .setHeader("contentType", header).build());
        return success ? "success" : "failed";
    }

    @StreamListener(OrderChannel.ORDER_INPUT)
    public void receive(Message<String> message) {
        System.out.println("======>" + message.getPayload());
    }

    @StreamListener(target = OrderChannel.ORDER_INPUT, condition = "headers['contentType']=='Bar'")
    public void receiveBar(@Payload Message<String> message) {
        System.out.println("bar ===> " + message.getPayload());
    }

    @StreamListener(target = OrderChannel.ORDER_INPUT, condition = "headers['contentType']=='Foo'")
    public void receiveFoo(@Payload Message<String> message) {
        System.out.println("foo ===> " + message.getPayload());
    }
}
