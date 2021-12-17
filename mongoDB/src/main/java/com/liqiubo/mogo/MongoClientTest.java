/*
 * <P> Copyright (c) 2021. LiQiubo.  版权所有 李秋波 </p>.
 *
 */

package com.liqiubo.mogo;

import com.mongodb.*;

/**
 * @author ：liqiubo
 * @description：
 * @date ：2021/7/13 12:45
 */
public class MongoClientTest {

    public static void main(String[] args) {
        // 验证连接
        String user = "assad";                   //用户名
        String database = "testdb";              //数据库
        char[] password = "123".toCharArray();   //密码

        MongoCredential credential = MongoCredential.createCredential(user, database, password);   //验证对象
        MongoClientOptions options = MongoClientOptions.builder().sslEnabled(false).build();     //连接操作对象
        MongoClient mongoClient = new MongoClient(new ServerAddress("127.0.0.1",27017), credential, options);   //连接对象

        //或者使用 mongo uri
        mongoClient = new MongoClient(new MongoClientURI("mongodb://assad:123@127.0.0.1:27017/?authSource=testdb&ssl=false"));
//        其中 mongo uri 的验证连接格式如下：
//        mongodb://userName:password@host/?authSource=databaseName&ssh=true;
    }

}
