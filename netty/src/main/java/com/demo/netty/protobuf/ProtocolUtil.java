/*
 * <P> Copyright (c) 2021. LiQiubo.  版权所有 李秋波 </p>.
 *
 */

package com.demo.netty.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

public class ProtocolUtil {

    public static void main(String[] args) throws InvalidProtocolBufferException {
        UserProto.UserProtocol protocol = UserProto.UserProtocol.newBuilder()
                .setId("1")
                .setName("编解码")
                .build();

        byte[] encode = encode(protocol);
        UserProto.UserProtocol parseFrom = decode(encode);
        System.out.println(protocol.toString());
        System.out.println(protocol.toString().equals(parseFrom.toString()));
    }

    /**
     * 编码
     * @param protocol
     * @return
     */
    public static byte[] encode(UserProto.UserProtocol protocol){
        return protocol.toByteArray() ;
    }

    /**
     * 解码
     * @param bytes
     * @return
     * @throws InvalidProtocolBufferException
     */
    public static UserProto.UserProtocol decode(byte[] bytes) throws InvalidProtocolBufferException {
        return UserProto.UserProtocol.parseFrom(bytes);
    }
}
