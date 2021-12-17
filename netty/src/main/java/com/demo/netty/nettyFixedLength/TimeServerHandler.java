package com.demo.netty.nettyFixedLength;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @readme ���ڶ�����ʱ����ж�д������ͨ������ֻ��Ҫ��עchannelRead��exceptionCaught������
 */
public class TimeServerHandler extends ChannelInboundHandlerAdapter {

	private int counter;
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		String body = (String) msg;
		System.out.println("The time server(Thread:"+Thread.currentThread()+") receive order : "+body+". the counter is : "+ ++counter);
		String currentTime = body;
		
		ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
		
		//�������͵���Ϣ�ŵ����ͻ���������
		ctx.writeAndFlush(resp);
	}
}
