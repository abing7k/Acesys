package com.example.server.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.example.server.mapper.CanRegisteredMapper;
import com.example.server.pojo.RespBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PROJECT_NAME: Acesys
 * @DESCRIPTION:
 * @USER: 韩冰
 * @DATE: 2022/11/3 0003 10:14
 */
@Api(tags = "AdminController")
@RestController("/admin")
public class AdminController {
    @Autowired
    CanRegisteredMapper canRegisteredMapper;

    @ApiOperation(value = "控制是否开启注册功能")
    @PostMapping
    public RespBean CanRegistered(@RequestBody Integer canOrNot){
        Integer integer = canRegisteredMapper.CanRegistered(canOrNot);
        if (integer == 1){
            return RespBean.success("修改成功");
        }else {
            return RespBean.error("修改失败");
        }
    }
}
