/*
 * <P> Copyright (c) 2021. LiQiubo.  ��Ȩ���� ���ﲨ </p>.
 *
 */

package com.demo.netty.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class TimeClientHandler extends ChannelInboundHandlerAdapter {

	@Override
	//�����������ָ��
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		byte[] req = "QUERY TIME ORDER".getBytes();
		ByteBuf firstMessage = Unpooled.buffer(req.length);
		firstMessage.writeBytes(req);
		ctx.writeAndFlush(firstMessage);
	}

	@Override
	//���շ���������Ӧ
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ByteBuf buf = (ByteBuf) msg;
		//buf.readableBytes():��ȡ�������пɶ����ֽ�����
		//���ݿɶ��ֽ�����������
		byte[] req = new byte[buf.readableBytes()];
		buf.readBytes(req);
		String body = new String(req, "UTF-8");
		System.out.println("Now is : "+body);
	}
}
