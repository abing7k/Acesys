package com.example.server.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.example.server.mapper.ShopCartMapper;
import com.example.server.pojo.RespBean;
import com.example.server.pojo.ShopCart;
import com.example.server.pojo.Usr;
import com.example.server.service.IShopCartService;
import com.example.server.service.IUsrService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @PROJECT_NAME: Acesys
 * @DESCRIPTION:
 * @USER: 韩冰
 * @DATE: 2022/11/4 0004 13:14
 */
@Api(tags = "VipController")
@RestController
@RequestMapping("/vip")
public class VipController {

    @Autowired
    ShopCartMapper shopCartMapper;
    @Autowired
    IShopCartService shopCartService;

    @ApiOperation(value = "查询购物车")
    @PostMapping("showShopCart")
    public RespBean showShopCart(@RequestBody Integer uid){
        return RespBean.success("查询成功",shopCartMapper.showAllByUid(uid));
    }

    @ApiOperation(value = "添加购物车")
    @PostMapping("addShopCart")
    public RespBean addShopCart(@RequestBody ShopCart shopCart){
        if (shopCartMapper.insert(shopCart)>0) {
            return RespBean.success("添加购物车成功");
        }else {
            return RespBean.error("添加购物车失败");
        }
    }



    @ApiOperation(value = "修改购物车产品数量")
    @PostMapping("updateShopCartNumber")
    public RespBean updateShopCartNumber(@Param("id") Integer id, @Param("number")Float number){
        return shopCartService.updateShopCartNumber(number,id);
    }

//    @ApiOperation(value = "购物车结算量")
//    @PostMapping("buyCart")






}
