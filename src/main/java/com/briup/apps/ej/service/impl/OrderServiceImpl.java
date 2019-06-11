package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.Order;
import com.briup.apps.ej.bean.OrderExample;
import com.briup.apps.ej.dao.OrderMapper;
import com.briup.apps.ej.service.IOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {
    @Resource
    private OrderMapper ordermapper;


    @Override
    public List<Order> findAll() {
        OrderExample example = new OrderExample();
        return ordermapper.selectByExample(example);
    }


    @Override
    public Order findById(long id) {
        return ordermapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(Order order) throws Exception {
        if (order.getId() == null) {
            // 初始化属性
            ordermapper.insert(order);
        } else {
            ordermapper.updateByPrimaryKey(order);
        }
    }

    @Override
    public void deleteById(long id) throws Exception {
        Order order = ordermapper.selectByPrimaryKey(id);
        if (order == null) {
            throw new Exception("要删除的订单不存在");
        } else {
            ordermapper.deleteByPrimaryKey(id);
        }
    }

}
