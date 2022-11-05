package com.example.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.server.mapper.ShopCartMapper;
import com.example.server.pojo.RespBean;
import com.example.server.pojo.ShopCart;
import com.example.server.service.IShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hanbing
 * @since 2022-11-05
 */
@Service
public class ShopCartServiceImpl extends ServiceImpl<ShopCartMapper, ShopCart> implements IShopCartService {

    @Autowired
    ShopCartMapper shopCartMapperl;
    @Override
    public RespBean updateShopCartNumber(Float number,Integer id) {
        shopCartMapperl.updateNumberById(number,id);
        return null;
    }
}
