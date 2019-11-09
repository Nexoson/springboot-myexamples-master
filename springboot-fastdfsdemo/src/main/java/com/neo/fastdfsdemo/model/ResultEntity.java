package com.neo.fastdfsdemo.model;

import lombok.Data;

import java.util.List;

/**
 * @ClassName ResultEntity
 * @Descripition TODO
 * @Auther huangX
 * @Date 2019/11/6 23:28
 * @Version 1.0
 **/
@Data
public class ResultEntity<E> {

    // 实体数据
    public List<E> data;

    // 响应信息
    public String msg;

}
