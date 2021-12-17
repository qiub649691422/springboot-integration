package com.liqiubo.stream.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface OrderChannel {

    String ORDER_INPUT = "order_input";

    String ORDER_OUTPUT = "order_output";

    @Input(ORDER_INPUT)
    SubscribableChannel receiveMessage();

    @Output(ORDER_OUTPUT)
    MessageChannel sendMessage();
}
