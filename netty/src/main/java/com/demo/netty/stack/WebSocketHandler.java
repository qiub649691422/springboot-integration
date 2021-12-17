/*
 * <P> Copyright (c) 2021. LiQiubo.  版权所有 李秋波 </p>.
 *
 */

package com.demo.netty.stack;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

public class WebSocketHandler extends ChannelInboundHandlerAdapter {
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		TextWebSocketFrame message = (TextWebSocketFrame) msg;
		System.out.println("WebSocket 请求，  msg:"+message.text());
		
		TextWebSocketFrame fram = new TextWebSocketFrame("是谁？");
		ctx.writeAndFlush(fram);
	}
}
