package com.neo.fastdfsdemo.model;

import lombok.Data;

/**
 * @ClassName ImgEntity
 * @Descripition 图片实体
 * @Auther huangX
 * @Date 2019/11/6 0:19
 * @Version 1.0
 **/
@Data
public class ImgEntity {

    /**
     * 图片ID
     */
    public String  fileId;
    /**
     * 图片名称
     */
    public String  fileName;
    /**
     * 图片全路径
     */
    public String  filePath;
    /**
     * 图片大小
     */
    public String  fileSize;
    /**
     * 图片类别(扩展字段)
     */
    public String  fileType;
    /**
     * 上传时间
     */
    public String  uploadTime;
    /**
     * 备注信息
     */
    public String  remark;
    /**
     * 外键ID(扩展字段)
     */
    public String  extId;
}
