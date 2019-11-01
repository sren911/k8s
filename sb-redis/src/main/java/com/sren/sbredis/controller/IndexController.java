package com.sren.sbredis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: renshuai
 * @date: 2019/10/25 下午5:53
 * @Description:
 */
@RestController
public class IndexController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/index")
    public String index() {
        stringRedisTemplate.opsForValue().set("hello", "redis");
        String result = stringRedisTemplate.opsForValue().get("hello");
        return result;
    }
}
