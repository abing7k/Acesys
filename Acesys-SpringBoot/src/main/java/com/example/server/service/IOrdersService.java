package com.example.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.server.pojo.Buy;
import com.example.server.pojo.Orders;
import com.example.server.pojo.RespBean;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hanbing
 * @since 2022-11-02
 */
public interface IOrdersService extends IService<Orders> {

    RespBean showOrders();

    RespBean buyProduct(Buy buy);
}
