package com.demo.netty.nettyLine;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

public class TimeClient {
	public static void main(String[] args) throws Exception {
		int port=8080; //�����Ĭ�϶˿�
		new TimeClient().connect(port, "127.0.0.1");
	}
	public void connect(int port, String host) throws Exception{
		//���ÿͻ���NIO�߳���
		EventLoopGroup group = new NioEventLoopGroup();
		try {
			Bootstrap bs = new Bootstrap();
			bs.group(group)
				.channel(NioSocketChannel.class)
				.option(ChannelOption.TCP_NODELAY, true)
				.handler(new ChannelInitializer<SocketChannel>() {
					@Override
					//����NIOSocketChannel�ɹ����ڽ��г�ʼ��ʱ��������ChannelHandler���õ�ChannelPipeline�У����ڴ�������IO�¼�
					protected void initChannel(SocketChannel arg0) throws Exception {
						//����ճ��/�������
						arg0.pipeline().addLast(new LineBasedFrameDecoder(1024));
						arg0.pipeline().addLast(new StringDecoder());
						
						arg0.pipeline().addLast(new TimeClientHandler());
					}
				});
			//�����첽���Ӳ���
			ChannelFuture cf = bs.connect(host, port).sync();
			//�ȴ��ͻ�����·�ر�
			cf.channel().closeFuture().sync();
		} finally {
			//�����˳����ͷ�NIO�߳���
			group.shutdownGracefully();
		}
	}
}