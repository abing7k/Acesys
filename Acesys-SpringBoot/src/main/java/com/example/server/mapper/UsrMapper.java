package com.example.server.mapper;
import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.server.pojo.Usr;
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
public interface UsrMapper extends BaseMapper<Usr> {

    Usr getAdminByUserName(String username);

    Integer getIdByUserName(String username);

}
