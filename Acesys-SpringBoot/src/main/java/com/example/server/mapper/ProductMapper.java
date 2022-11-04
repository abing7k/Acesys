package com.example.server.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.server.pojo.Product;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hanbing
 * @since 2022-11-02
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {


    Product getAllById(@Param("id") Integer id);

    int updateWeightById(@Param("weight") Float weight, @Param("id") Integer id);

    String getImageById(@Param("id") Integer id);
}
