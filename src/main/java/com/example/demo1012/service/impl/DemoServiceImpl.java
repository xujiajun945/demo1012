package com.example.demo1012.service.impl;

import com.example.demo1012.dal.dao.DemoMapper;
import com.example.demo1012.model.Demo01;
import com.example.demo1012.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xujiajun
 * @since 2026/10/12
 */
@Slf4j
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoMapper demoMapper;
    @Override
    public Demo01 getById(Integer id) {
        Demo01 demo01 = demoMapper.getById(id);
        log.warn(demo01.getName());
        return demo01;
    }

    public Demo01 getByName(String name) {
        Demo01 demo01 = demoMapper.getByName(name);
        log.warn(demo01.getName());
        return demo01;
    }
}
