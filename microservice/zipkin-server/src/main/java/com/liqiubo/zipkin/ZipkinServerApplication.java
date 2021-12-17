package com.liqiubo.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;
//import zipkin.server.internal.EnableZipkinServer;
//import zipkin2.server.internal.EnableZipkinServer;

@SpringBootApplication
//@EnableZipkinServer
//@EnableZipkinStreamServer
public class ZipkinServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinServerApplication.class, args);
    }

}
