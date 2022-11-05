package com.example.server.mapper;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.server.pojo.ShopCart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hanbing
 * @since 2022-11-05
 */
@Mapper
public interface ShopCartMapper extends BaseMapper<ShopCart> {

    Integer updateNumberById(@Param("number") Float number, @Param("id") Integer id);

    @MapKey("id")
    List<Map<String,String>> showAllByUid(Integer uid);
}
