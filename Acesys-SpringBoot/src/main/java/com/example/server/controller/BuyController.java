package com.example.server.controller;

import com.example.server.pojo.Buy;
import com.example.server.pojo.RespBean;
import com.example.server.service.IOrdersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PROJECT_NAME: Acesys
 * @DESCRIPTION:
 * @USER: 韩冰
 * @DATE: 2022/11/4 0004 16:36
 */
@Api(tags = "BuyController")
@RestController
public class BuyController {
    @Autowired
    IOrdersService ordersService;

    @ApiOperation(value = "购买")
    @PostMapping("buyProduct")
    public RespBean buyProduct(@RequestBody Buy buy){
        return ordersService.buyProduct(buy);
    }
}
