package com.neo.testweb.utils.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @ClassName FormDataResult
 * @Descripition 返回结果信息
 * @Auther huangX
 * @Date 2020/4/1 10:27
 * @Version 1.0
 **/
public class FormDataResult <T>{

    /**
     * 错误枚举类
     */
    private EnumFormResultMsg sasisResultMsg;

    /**
     * 数据
     */
    private T data;

    private PageInfo pageInfo;

    public FormDataResult() {
        this.sasisResultMsg = null;
    }

    public EnumFormResultMsg getSasisResultMsg() {
        return sasisResultMsg;
    }

    public void setSasisError(EnumFormResultMsg sasisResultMsg) {
        this.sasisResultMsg = sasisResultMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public FormDataResult(EnumFormResultMsg sasisResultMsg, T data) {
        this.sasisResultMsg = sasisResultMsg;
        this.data = data;
    }

    public FormDataResult(EnumFormResultMsg sasisResultMsg, PageInfo pageInfo) {
        this.sasisResultMsg = sasisResultMsg;
        this.pageInfo = pageInfo;
    }

    public FormDataResult(EnumFormResultMsg sasisResultMsg) {
        this.sasisResultMsg = sasisResultMsg;
    }

    public static<T>  FormDataResult<T> build(EnumFormResultMsg sasisResultMsg, T data){
        return new FormDataResult<T>(sasisResultMsg,data);
    }

    public static<T>  FormDataResult<T> build(EnumFormResultMsg sasisResultMsg){
        return new FormDataResult<T>(sasisResultMsg);
    }

    public static <T> FormDataResult<T> build(EnumFormResultMsg sasisResultMsg, PageInfo pageInfo) {
        return new FormDataResult<T>(sasisResultMsg, pageInfo);
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    @Override
    public String toString() {
        JSONObject object = new JSONObject();
        object.put("code", sasisResultMsg.getCode());
        object.put("message", sasisResultMsg.getMessage());

        object.put("data", data);

        if (null != pageInfo) {
            object.put("pageInfo", pageInfo);
        }
        return JSON.toJSONString(object,
                //    输出key是包含双引号
                SerializerFeature.QuoteFieldNames,
                //    是否输出为null的字段,若为null 则显示该字段
                SerializerFeature.WriteMapNullValue,
                // 数值字段如果为null，则输出为0
                SerializerFeature.WriteNullNumberAsZero,
                //     List字段如果为null,输出为[],而非null
                SerializerFeature.WriteNullListAsEmpty,
                //    字符类型字段如果为null,输出为"",而非null
                SerializerFeature.WriteNullStringAsEmpty,
                //    Boolean字段如果为null,输出为false,而非null
                SerializerFeature.WriteNullBooleanAsFalse,
                //    Date的日期转换器
                SerializerFeature.WriteDateUseDateFormat,
                //    循环引用
                SerializerFeature.DisableCircularReferenceDetect);
    }

    public String toString2() {
        JSONObject object = new JSONObject();
        object.put("code", sasisResultMsg.getCode());
        object.put("message", sasisResultMsg.getMessage());

        object.put("data", data);

        if (null != pageInfo) {
            object.put("pageInfo", pageInfo);
        }
        return JSON.toJSONString(object,
                //    输出key是包含双引号
                SerializerFeature.QuoteFieldNames,
                //    是否输出为null的字段,若为null 则显示该字段
                SerializerFeature.WriteMapNullValue,
//                // 数值字段如果为null，则输出为0
//                SerializerFeature.WriteNullNumberAsZero,
                //     List字段如果为null,输出为[],而非null
                SerializerFeature.WriteNullListAsEmpty,
                //    字符类型字段如果为null,输出为"",而非null
                SerializerFeature.WriteNullStringAsEmpty,
                //    Boolean字段如果为null,输出为false,而非null
                SerializerFeature.WriteNullBooleanAsFalse,
                //    Date的日期转换器
                SerializerFeature.WriteDateUseDateFormat,
                //    循环引用
                SerializerFeature.DisableCircularReferenceDetect);
    }

}
