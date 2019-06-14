package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Order;
import com.briup.apps.ej.bean.VM.OrderAndOrderLineVM;
import com.briup.apps.ej.bean.VM.OrderVM;
import com.briup.apps.ej.bean.extend.OrderExtend;

import java.util.List;

public interface IOrderService {


    List<OrderVM> queryBasic(Long customerId, Long waiterId);

    List<OrderExtend> query(Long customerId, Long waiterId);


    List<Order> findAll();

    Order findById(long id);

    void save(OrderAndOrderLineVM order) throws Exception;

    void deleteById(long id) throws Exception ;
    void batchDelete(long[] ids) throws Exception;


}
