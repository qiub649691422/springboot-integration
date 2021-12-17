package com.liqiubo.zipkin.agent;

import java.lang.instrument.Instrumentation;

public class AgentExample {

    // 在main方法之前运行，与main方法运行在同一个JVM中并被同一个ClassLoader装载
    // 被统一的安全策略(security policy)和上下文(context)管理
    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("====> premain(String agentArgs, Instrumentation inst) 执行");
        System.out.println(agentArgs);
    }

    // 如果不存在 premain(String agent, Instrumentation inst) 则执行 premain(String agentOps)
    public static void premain(String agentArgs) {
        System.out.println("====> premain(String agentArgs) 执行");
        System.out.println(agentArgs);
    }

    public static void main(String[] args) {
    }
}
