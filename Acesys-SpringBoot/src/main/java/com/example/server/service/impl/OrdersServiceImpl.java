package com.example.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.server.mapper.OrdersMapper;
import com.example.server.pojo.Orders;
import com.example.server.pojo.RespBean;
import com.example.server.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author hanbing
 * @since 2022-11-02
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements IOrdersService {

    @Autowired
    OrdersMapper ordersMapper;

    @Override
    public RespBean showOrders() {
        List<Map<String,Object>> orders = ordersMapper.showOrders();
        return RespBean.success("",orders);
    }
}
