package com.example.demo1012.service;

import com.example.demo1012.model.Demo01;

/**
 * @author xujiajun
 * @since 2026/10/12
 */
public interface DemoService {
    Demo01 getById(Integer id);

    Demo01 getByName(String name);
}
