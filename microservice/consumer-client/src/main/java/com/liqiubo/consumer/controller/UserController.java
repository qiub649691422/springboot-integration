package com.liqiubo.consumer.controller;

import com.liqiubo.consumer.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RefreshScope
@RequestMapping("/consumer")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping(value = "/{id}")
    public User getUserInfo(@PathVariable Long id) {
        // return restTemplate.getForObject("http://localhost:8080/provider"+id, User.class);
        return restTemplate.getForObject("http://spring-cloud-provider/provider/" + id, User.class);
    }

//    @Value("${name}")
    String name = "world";

    @RequestMapping("/helo")
    public String helo() {
        System.out.println("hello " + name);
        return name;
    }

}
