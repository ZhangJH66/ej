package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.OrderLine;
import com.briup.apps.ej.bean.OrderLineExample;
import com.briup.apps.ej.dao.OrderLineMapper;
import com.briup.apps.ej.service.IOrderLineService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class OrderLineServiceImpl implements IOrderLineService {

    @Resource
    private OrderLineMapper orderLineMapper;

    @Override
    public List<OrderLine> findAll() {
        OrderLineExample example=new OrderLineExample();
        return orderLineMapper.selectByExample(example);
    }

    @Override
    public OrderLine findById(long id) {
        return orderLineMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(OrderLine orderLine) throws Exception {
        if (orderLine.getId() == null) {
            // 初始化属性
            orderLineMapper.insert(orderLine);
        } else {
            orderLineMapper.updateByPrimaryKey(orderLine);
        }
    }

    @Override
    public void deleteById(long id) throws Exception {
        OrderLine orderLine = orderLineMapper.selectByPrimaryKey(id);
        if (orderLine == null) {
            throw new Exception("要删除的订单不存在");
        } else {
            orderLineMapper.deleteByPrimaryKey(id);
        }
    }
    @Override
    public void batchDelete(long[] ids) throws Exception {
        for(long id :ids){
            orderLineMapper.deleteByPrimaryKey(id);
        }
    }
}
