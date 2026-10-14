package com.example.demo1012.web;

import com.example.demo1012.model.Demo01;
import com.example.demo1012.model.ResponseData;
import com.example.demo1012.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author xujiajun
 * @since 2026/10/12
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/demo01/{id}")
    public ResponseData demo01(@PathVariable("id") Integer id) {
        Demo01 demo01 = demoService.getById(id);
        return new ResponseData(demo01);
    }

    @GetMapping(value = "/demo01")
    public ResponseData demo01GetByName(@RequestParam("name") String name) {
        return new ResponseData();
    }
}
