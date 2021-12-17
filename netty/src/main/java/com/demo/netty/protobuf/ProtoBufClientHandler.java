package com.demo.netty.protobuf;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ProtoBufClientHandler extends ChannelInboundHandlerAdapter {

	@Override
	//�����������ָ��
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		UserProto.UserProtocol user = UserProto.UserProtocol.newBuilder()
				.setId("1")
				.setName("Five")
				.build();
		ctx.writeAndFlush(user);
	}

	@Override
	//���շ���������Ӧ
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		System.out.println("�ͻ��˽��յ�msgpack��Ϣ��"+msg);
		UserProto.UserProtocol buf = (UserProto.UserProtocol) msg;
		System.out.println(buf);
	}

	@Override
	//�쳣����
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		//�ͷ���Դ
		ctx.close();
	}
	
}
