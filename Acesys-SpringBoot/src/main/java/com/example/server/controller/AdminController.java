package com.example.server.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.server.mapper.*;
import com.example.server.pojo.Mailtb;
import com.example.server.pojo.Product;
import com.example.server.pojo.RespBean;
import com.example.server.pojo.Usr;
import com.example.server.service.IOrdersService;
import com.example.server.service.IProductService;
import com.example.server.service.IUsrService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @PROJECT_NAME: Acesys
 * @DESCRIPTION:
 * @USER: 韩冰
 * @DATE: 2022/11/3 0003 10:14
 */
@Api(tags = "AdminController")
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    CanRegisteredMapper canRegisteredMapper;
    @Autowired
    IProductService productService;
    @Autowired
    ProductMapper productMapper;
    @Autowired
    UsrMapper usrMapper;
    @Autowired
    IUsrService usrService;
    @Autowired
    MailtbMapper mailtbMapper;
    @Autowired
    IOrdersService ordersService;
    @Autowired
    OrdersMapper ordersMapper;

    @ApiOperation(value = "控制是否开启注册功能")
    @PostMapping("canRegistered")
    public RespBean CanRegistered(@RequestBody Integer canOrNot) {
        Integer integer = canRegisteredMapper.CanRegistered(canOrNot);
        if (integer == 1) {
            return RespBean.success("修改成功");
        } else {
            return RespBean.error("修改失败");
        }
    }

    @ApiOperation(value = "查看全部产品")
    @GetMapping(value = "/showProduct")
    public RespBean showProduct() {
        return RespBean.success("查询成功",productMapper.selectList(
                new QueryWrapper<>()
        ));
    }

    @ApiOperation(value = "根据id查看产品")
    @PostMapping(value = "/showProductById")
    public RespBean showProductById(@RequestBody Integer id) {
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        return RespBean.success("查询成功",productMapper.selectList(queryWrapper));
    }

    @ApiOperation(value = "添加产品")
    @PostMapping(value = "/addProduct")
    public RespBean addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @ApiOperation(value = "添加产品图片")
    @PostMapping(value = "/addProductImg")
    public RespBean addProduct(@RequestParam MultipartFile file) {
        return productService.addProductImg(file);
    }

    @ApiOperation(value = "更新产品")
    @PostMapping(value = "/updateProduct")
    public RespBean updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @ApiOperation(value = "删除产品")
    @DeleteMapping(value = "/deleteProduct")
    public RespBean deleteProduct(@RequestBody Integer id) {
        return productService.deleteProduct(id);
    }

    @ApiOperation(value = "添加用户")
    @PostMapping(value = "/addUsr")
    public RespBean addUsr(@RequestBody Usr usr) {
        return usrService.addUsr(usr);
    }


    @ApiOperation(value = "修改用户")
    @PostMapping(value = "/updateUsr")
    public RespBean updateUsr(@RequestBody Usr usr) {
        return usrService.updateUsr(usr);
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping(value = "/deleteUsr")
    public RespBean deleteUsr(@RequestBody Integer id) {
        return usrService.deleteUsr(id);
    }

    @ApiOperation(value = "查询用户")
    @GetMapping(value = "/showUsrs")
    public RespBean showUsrs() {
        return usrService.showUsrs();
    }

    @ApiOperation(value = "查看邮箱")
    @GetMapping(value = "/showEmail")
    public RespBean showEmail() {
        return RespBean.success("查询成功",mailtbMapper.selectList(new QueryWrapper<>()));
    }

    @ApiOperation(value = "修改邮箱")
    @PostMapping(value = "/updateEmail")
    public RespBean updateEmail(@RequestBody Mailtb mailtb) {
        if (mailtbMapper.updateById(mailtb)>0){
            return RespBean.success("修改成功");
        }else {
            return RespBean.error("修改失败");
        }
    }


    @ApiOperation(value = "查看订单")
    @GetMapping(value = "/showOrders")
    public RespBean showOrders() {
        return ordersService.showOrders();
    }

    @ApiOperation(value = "删除订单")
    @DeleteMapping(value = "/deleteOrders")
    public RespBean deleteOrders(@RequestBody Integer id) {
        if (ordersMapper.deleteById(id)>0) {
            return RespBean.success("删除成功");
        }else {
            return RespBean.error("删除失败");
        }
    }


}
