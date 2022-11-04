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
    @Transactional
    public RespBean buyProduct(Buy buy) {
        Product product = productMapper.getAllById(buy.getPid());
        if (buy.getWeight() > product.getWeight()) {
            return RespBean.error("产品数量不足");
        }
        if (productMapper.updateWeightById(product.getWeight() - buy.getWeight(), buy.getPid()) > 0) {
            Orders orders = new Orders();
            orders.setUid(buy.getUid());
            orders.setDatetime(LocalDate.now());
            if (ordersMapper.insert(orders) > 0) {
                Orderitem orderitem = new Orderitem();
                orderitem.setOid(orders.getId());
                orderitem.setPid(buy.getPid());
                orderitem.setQuantity(buy.getWeight());
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
