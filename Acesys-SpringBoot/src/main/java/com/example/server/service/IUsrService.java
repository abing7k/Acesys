package com.example.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.server.pojo.RespBean;
import com.example.server.pojo.Usr;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hanbing
 * @since 2022-11-02
 */
public interface IUsrService extends IService<Usr> {

    RespBean login(String username, String password, String code, HttpServletRequest request);

    Usr getUsrByUserName(String username);
}
