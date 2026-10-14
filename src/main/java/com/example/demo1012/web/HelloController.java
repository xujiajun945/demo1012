package com.example.demo1012.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xujiajun
 * @since 2026/10/12
 */
@Controller
@RequestMapping(value = "/web")
public class HelloController {

    @GetMapping(value = "/hello")
    public String hello() {
        return "hello.html";
    }
}
