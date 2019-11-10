package com.neo.restfuldemo.model;

import lombok.Data;

/**
 * @ClassName Message
 * @Descripition TODO
 * @Auther huangX
 * @Date 2019/11/9 17:38
 * @Version 1.0
 **/
@Data
public class Message {

    private Long id;
    private String text;
    private String summary;
}
