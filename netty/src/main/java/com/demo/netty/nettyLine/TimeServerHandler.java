package com.demo.netty.nettyLine;

import java.util.Date;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @readme ���ڶ�����ʱ����ж�д������ͨ������ֻ��Ҫ��עchannelRead��exceptionCaught������
 * 
 */
public class TimeServerHandler extends ChannelInboundHandlerAdapter {

	private int counter;
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//		ByteBuf buf = (ByteBuf) msg;
//		//buf.readableBytes():��ȡ�������пɶ����ֽ�����
//		//���ݿɶ��ֽ�����������
//		byte[] req = new byte[buf.readableBytes()];
//		buf.readBytes(req);
//		String body = new String(req, "UTF-8");
		String body = (String) msg;
		System.out.println("The time server(Thread:"+Thread.currentThread()+") receive order : "+body+". the counter is : "+ ++counter);
		String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString() : "BAD ORDER";
		currentTime = currentTime + System.getProperty("line.separator");
		
		ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
		//�������͵���Ϣ�ŵ����ͻ���������
		ctx.writeAndFlush(resp);
	}

}