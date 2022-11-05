package com.example.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.server.mapper.OrderitemMapper;
import com.example.server.mapper.OrdersMapper;
import com.example.server.mapper.ProductMapper;
import com.example.server.pojo.*;
import com.example.server.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
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
    private OrdersMapper ordersMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private OrderitemMapper orderitemMapper;

    @Override
    public RespBean showOrders() {
        List<Map<String, Object>> orders = ordersMapper.showOrders();
        return RespBean.success("查询成功", orders);
    }

    @Override
    public RespBean showOrdersByOid(Integer oid) {
        return RespBean.success("查询成功", ordersMapper.showOrdersByOid(oid));
    }

    @Override
    public RespBean showOrdersByUid(Integer uid) {
        return RespBean.success("查询成功", ordersMapper.showOrdersByUid(uid));
    }

    @Override
    @Transactional
    public RespBean buyProduct(Buy buy) {
        Product product = productMapper.getAllById(buy.getPid());
        if (buy.getNumber() > product.getRealstock()) {
            return RespBean.error("产品数量不足");
        }
        if (productMapper.updateWeightById(product.getRealstock() - buy.getNumber(), buy.getPid()) > 0) {
            Orders orders = new Orders();
            orders.setUid(buy.getUid());
            orders.setDatetime(LocalDate.now());
            if (ordersMapper.insert(orders) > 0) {
                Orderitem orderitem = new Orderitem();
                orderitem.setOid(orders.getId());
                orderitem.setPid(buy.getPid());
                orderitem.setNumber(buy.getNumber());
                if (orderitemMapper.insert(orderitem) > 0) {
                    return RespBean.success("购买成功");
                }
                return RespBean.error("购买失败");
            } else {
                return RespBean.error("购买失败");
            }
        } else {
            return RespBean.error("购买失败");
        }
    }


}
