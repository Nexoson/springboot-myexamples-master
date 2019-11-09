package com.neo.fastdfsdemo.service;

import com.neo.fastdfsdemo.mapper.FastDfsMapper;
import com.neo.fastdfsdemo.model.ImgEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName FastDfsServiceImpl
 * @Descripition TODO
 * @Auther huangX
 * @Date 2019/11/6 0:37
 * @Version 1.0
 **/
@Service("FastDfsService")
public class FastDfsServiceImpl implements FastDfsService{

    @Autowired
    FastDfsMapper fastDfsMapper;

    @Override
    public List<ImgEntity> getImgList() {
        return fastDfsMapper.getImgList();
    }
}
