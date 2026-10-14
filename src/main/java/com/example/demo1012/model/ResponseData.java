package com.example.demo1012.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author xujiajun
 * @since 2026/10/12
 */
@Setter
@Getter
public class ResponseData {

    private Integer code;

    private String message;

    private Object data;

    public ResponseData() {
        this.code = 1;
        this.message = "ok";
    }

    public ResponseData(Object o) {
        this();
        this.data = o;
    }
}
