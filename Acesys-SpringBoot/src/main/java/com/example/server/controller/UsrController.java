package com.example.server.controller;


import com.example.server.pojo.Usr;
import com.example.server.service.IUsrService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hanbing
 * @since 2022-11-02
 */
@RestController
@RequestMapping("/usr")
public class UsrController {
    @Autowired
    IUsrService usrService;
    @ApiOperation(value = "获取当前用户信息")
    @GetMapping("/getInfo")
    public Usr getAdminInfo(Principal principal) {
        if (principal == null) {
            return null;
        }
        String username = principal.getName();
        Usr admin = usrService.getUsrByUserName(username);
        admin.setPassword(null);
        return admin;
    }
}
