package com.neo.fastdfsdemo.fastdfs;

import lombok.Data;

/**
 * @ClassName FastDFSFile
 * @Descripition TODO
 * @Auther huangX
 * @Date 2019/10/29 21:17
 * @Version 1.0
 **/
@Data
public class FastDFSFile {

    private String name;

    private byte[] content;

    private String ext;

    private String md5;

    private String author;

    public FastDFSFile(String name, byte[] content, String ext, String height,
                       String width, String author) {
        super();
        this.name = name;
        this.content = content;
        this.ext = ext;
        this.author = author;
    }

    public FastDFSFile(String name, byte[] content, String ext) {
        super();
        this.name = name;
        this.content = content;
        this.ext = ext;

    }


}
