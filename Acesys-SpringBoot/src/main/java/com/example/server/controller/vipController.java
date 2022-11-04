package com.example.server.controller;

import com.example.server.pojo.RespBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @PROJECT_NAME: Acesys
 * @DESCRIPTION:
 * @USER: 韩冰
 * @DATE: 2022/11/4 0004 13:14
 */
@Api(tags = "vipController")
@RestController
@RequestMapping("/vip")
public class vipController {

    @ApiOperation(value = "hello")
    @GetMapping("hello")
    public String CanRegistered() {
        return "hello666";
    }
}
