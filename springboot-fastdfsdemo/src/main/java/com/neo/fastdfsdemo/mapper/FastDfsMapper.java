package com.neo.fastdfsdemo.mapper;

import com.neo.fastdfsdemo.model.ImgEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName FastDfsMapper
 * @Descripition TODO
 * @Auther huangX
 * @Date 2019/11/6 0:18
 * @Version 1.0
 **/

@Mapper
@Repository
public interface FastDfsMapper {

    List<ImgEntity> getImgList();
}
