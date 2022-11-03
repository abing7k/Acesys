package com.example.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.server.pojo.CanRegistered;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hanbing
 * @since 2022-11-03
 */
@Mapper
public interface CanRegisteredMapper extends BaseMapper<CanRegistered> {

    Integer CanRegistered(Integer canOrNot);
}
