package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.Order;
import com.briup.apps.ej.bean.OrderExample;
import com.briup.apps.ej.bean.extend.OrderExtend;
import com.briup.apps.ej.dao.OrderMapper;
import com.briup.apps.ej.dao.extend.OrderExtendMapper;
import com.briup.apps.ej.service.IOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {
    @Resource
    private OrderMapper ordermapper;
    @Resource
    private OrderExtendMapper orderExtendMapper;


    @Override
    public List<OrderExtend> query(Long customerId, Long waiterId) {
        return orderExtendMapper.query(customerId,waiterId);
    }

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
    @Override
    public void batchDelete(long[] ids) throws Exception {
        for(long id :ids){
            ordermapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public OrderExtend findByIdExtend(long id) {
        return null;
    }
}
