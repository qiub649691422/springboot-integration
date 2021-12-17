/*
 * <P> Copyright (c) 2021. LiQiubo.  版权所有 李秋波 </p>.
 *
 */

package com.demo.netty.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class TimeClientHandler extends ChannelInboundHandlerAdapter {

	@Override
	//向服务器发送指令
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		byte[] req = "QUERY TIME ORDER".getBytes();
		ByteBuf firstMessage = Unpooled.buffer(req.length);
		firstMessage.writeBytes(req);
		ctx.writeAndFlush(firstMessage);
	}

	@Override
	//接收服务器的响应
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ByteBuf buf = (ByteBuf) msg;
		//buf.readableBytes():获取缓冲区中可读的字节数；
		//根据可读字节数创建数组
		byte[] req = new byte[buf.readableBytes()];
		buf.readBytes(req);
		String body = new String(req, "UTF-8");
		System.out.println("Now is : "+body);
	}
}
