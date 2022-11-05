package com.example.server.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.server.mapper.ProductMapper;
import com.example.server.pojo.Plike;
import com.example.server.pojo.Product;
import com.example.server.pojo.RespBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author hanbing
 * @since 2022-11-02
 */
@Api(tags = "ProductController")
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductMapper productMapper;

    @ApiOperation(value = "产品搜索")
    @PostMapping("likeProduct")
    public RespBean likeProduct(@RequestBody Plike plike) {
//        if (like == null||like.equals("")||like.equals("null")){
//            return RespBean.success("查询成功",productMapper.selectList(new QueryWrapper<>()));
//        }
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("productname",plike.getLike());
        queryWrapper.like("category",plike.getType());
        return RespBean.success("查询成功",productMapper.selectList(queryWrapper));
    }
}
