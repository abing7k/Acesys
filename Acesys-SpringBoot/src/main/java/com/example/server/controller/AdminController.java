package com.example.server.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.server.mapper.CanRegisteredMapper;
import com.example.server.mapper.ProductMapper;
import com.example.server.mapper.UsrMapper;
import com.example.server.pojo.Product;
import com.example.server.pojo.RespBean;
import com.example.server.pojo.Usr;
import com.example.server.service.IProductService;
import com.example.server.service.IUsrService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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

    @ApiOperation(value = "添加产品")
    @PostMapping(value = "/addProduct")
    public RespBean addProduct(@RequestParam MultipartFile file, Product product) {
        return productService.addProduct(file, product);
    }

    @ApiOperation(value = "更新产品")
    @PostMapping(value = "/updateProduct")
    public RespBean updateProduct(@RequestParam MultipartFile file, Product product) {
        return productService.updateProduct(file, product);
    }

    @ApiOperation(value = "删除产品")
    @PostMapping(value = "/deleteProduct")
    public RespBean deleteProduct(@RequestBody Integer id) {
        return productService.updatePdelete(id);
    }

    @Transactional
    @ApiOperation(value = "添加用户")
    @PostMapping(value = "/addUsr")
    public RespBean addUsr(@RequestBody Usr usr) {
        return usrService.addUsr(usr);
    }

}
