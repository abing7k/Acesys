package com.example.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.server.mapper.OrderitemMapper;
import com.example.server.mapper.OrdersMapper;
import com.example.server.mapper.ProductMapper;
import com.example.server.mapper.ShopCartMapper;
import com.example.server.pojo.*;
import com.example.server.service.IOrdersService;
import com.example.server.service.IShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author hanbing
 * @since 2022-11-05
 */
@Service
public class ShopCartServiceImpl extends ServiceImpl<ShopCartMapper, ShopCart> implements IShopCartService {

    @Autowired
    ShopCartMapper shopCartMapperl;
    @Autowired
    IOrdersService ordersService;
    @Autowired
    ProductMapper productMapper;
    @Autowired
    OrdersMapper ordersMapper;
    @Autowired
    OrderitemMapper orderitemMapper;

    @Override
    public RespBean updateShopCartNumber(Float number, Integer id) {
        if (shopCartMapperl.updateNumberById(number, id)>0) {
            return RespBean.success("修改成功");
        }else {
            return RespBean.error("修改失败");
        }
    }

    @Override
    @Transactional
    public RespBean buyCarts(Integer uid, Integer[] cids) {
        if (uid == null || cids.length==0){
            return RespBean.success("购买失败");
        }
        for (Integer cid : cids) {
            ShopCart shopCart = shopCartMapperl.getAllById(cid);
            System.err.println(shopCart);
            Buy buy = new Buy();
            buy.setUid(uid);
            buy.setPid(shopCart.getPid());
            buy.setNumber(shopCart.getNumber());
            String s = buyProduct(buy,shopCart.getId());
            if (!"购买成功".equals(s)) {
                return RespBean.error(s);
            }
        }
        return RespBean.success("购买成功");
    }

    @Transactional
    public String buyProduct(Buy buy,int cid) {
        Product product = productMapper.getAllById(buy.getPid());
        if (buy.getNumber() > product.getRealstock()) {
            return product.getProductname() + "产品数量不足";
        }
        if (productMapper.updateWeightById(product.getRealstock() - buy.getNumber(), buy.getPid()) > 0) {
            Orders orders = new Orders();
            orders.setUid(buy.getUid());
            orders.setDatetime(LocalDate.now());
            if (ordersMapper.insert(orders) > 0 && shopCartMapperl.deleteById(cid)>0) {
                Orderitem orderitem = new Orderitem();
                orderitem.setOid(orders.getId());
                orderitem.setPid(buy.getPid());
                orderitem.setNumber(buy.getNumber());
                if (orderitemMapper.insert(orderitem) > 0) {
                    return "购买成功";
                }
                return "购买失败";
            } else {
                return "购买失败";
            }
        } else {
            return "购买失败";
        }
    }
}
