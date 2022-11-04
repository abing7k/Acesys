package com.example.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.server.pojo.RespBean;
import com.example.server.pojo.Role;
import com.example.server.pojo.UserRole;
import com.example.server.pojo.Usr;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    String getRolesById(Integer id);

    RespBean addUsr(Usr usr);

    RespBean updateUsr(Usr usr);

    RespBean deleteUsr(Integer id);

    RespBean showUsrs();
}
