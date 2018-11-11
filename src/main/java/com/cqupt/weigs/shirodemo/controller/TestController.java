package com.cqupt.weigs.shirodemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author weigs
 * @date 2018/11/11 0011
 */
@RestController
@RequestMapping("/weigs/test")
public class TestController {

    @RequestMapping
    public String test() {
        return "test";
    }
}
