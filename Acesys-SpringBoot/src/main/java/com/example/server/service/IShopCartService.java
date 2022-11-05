package com.example.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.server.pojo.RespBean;
import com.example.server.pojo.ShopCart;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hanbing
 * @since 2022-11-05
 */
public interface IShopCartService extends IService<ShopCart> {

    RespBean updateShopCartNumber(Float number,Integer id);
}
