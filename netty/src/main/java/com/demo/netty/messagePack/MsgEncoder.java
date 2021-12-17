package com.demo.netty.messagePack;

import org.msgpack.MessagePack;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * MessagePack 编码器
 */
public class MsgEncoder extends MessageToByteEncoder<UserVO > {

	@Override
	protected void encode(ChannelHandlerContext ctx, UserVO msg, ByteBuf out) throws Exception {
		out.writeBytes(new MessagePack().write(msg));
	}

}
