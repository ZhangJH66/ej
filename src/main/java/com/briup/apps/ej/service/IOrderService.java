package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Order;
import com.briup.apps.ej.bean.extend.OrderExtend;

import java.util.List;

public interface IOrderService {


    List<Order> findAll();

    Order findById(long id);

    void saveOrUpdate(Order order) throws Exception ;

    void deleteById(long id) throws Exception ;
    void batchDelete(long[] ids) throws Exception;

    List<OrderExtend> query(Long customerId,Long waiterId);

    OrderExtend findByIdExtend(long id);
}
