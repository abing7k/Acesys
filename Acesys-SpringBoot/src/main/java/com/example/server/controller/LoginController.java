package com.example.server.controller;

import com.example.server.pojo.AdminLoginParam;
import com.example.server.pojo.RespBean;
import com.example.server.pojo.Usr;
import com.example.server.service.IUsrService;
import com.example.server.service.impl.UsrServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @PROJECT_NAME: Acesys
 * @DESCRIPTION:
 * @USER: 韩冰
 * @DATE: 2022/11/2 0002 23:09
 */
@Api(tags = "LoginController")
@RestController
public class LoginController {
    @Autowired
    UsrServiceImpl usradminService;
    @Autowired
    IUsrService usrService;
    @ApiOperation(value = "登录之后返回token")
    @PostMapping("/login")
    public RespBean login(@RequestBody AdminLoginParam adminLoginParam, HttpServletRequest request){
        return usradminService.login(adminLoginParam.getUsername(),adminLoginParam.getPassword(),adminLoginParam.getCode(),request);
    }

    @ApiOperation(value = "注册账号")
    @PostMapping("registered")
    public RespBean registered(@RequestBody Usr usr) {
        return usrService.registered(usr);
    }

    @ApiOperation(value = "注销账号")
    @PostMapping("logout")
    public RespBean logout() {
        return RespBean.success("注销成功");
    }



}
