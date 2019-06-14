package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.Order;
import com.briup.apps.ej.bean.OrderExample;
import com.briup.apps.ej.bean.OrderLine;
import com.briup.apps.ej.bean.VM.OrderAndOrderLineVM;
import com.briup.apps.ej.bean.VM.OrderVM;
import com.briup.apps.ej.bean.extend.OrderExtend;
import com.briup.apps.ej.dao.OrderLineMapper;
import com.briup.apps.ej.dao.OrderMapper;
import com.briup.apps.ej.dao.extend.OrderExtendMapper;
import com.briup.apps.ej.service.IOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {
    @Resource
    private OrderMapper ordermapper;
    @Resource
    private OrderExtendMapper orderExtendMapper;
    @Resource
    private OrderLineMapper orderLineMapper;



    @Override
    public List<OrderExtend> query(Long customerId, Long waiterId) {
        return orderExtendMapper.query(customerId,waiterId);
    }

    @Override
    public List<OrderVM> queryBasic(Long customerId, Long waiterId) {
        return orderExtendMapper.queryBasic(customerId,waiterId);
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
    public void save(OrderAndOrderLineVM order) throws Exception {
        // 先保存订单
        Order o = new Order();
        o.setOrderTime(new Date().getTime());
        o.setTotal(100.0);
        o.setCustomerId(order.getCustomerId());
        o.setAddressId(order.getAddressId());
        ordermapper.insert(o);
        // 再保存订单项
        List<OrderLine> list = order.getOrderLines();
        for(OrderLine ol : list){
            // 维护订单项与订单之间的关系
            ol.setOrderId(o.getId());
            orderLineMapper.insert(ol);
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

}
