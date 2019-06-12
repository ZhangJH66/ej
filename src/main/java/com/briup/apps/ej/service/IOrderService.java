package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Order;

import java.util.List;

public interface IOrderService {


    List<Order> findAll();

    Order findById(long id);

    void saveOrUpdate(Order order) throws Exception ;

    void deleteById(long id) throws Exception ;
    void batchDelete(long[] ids) throws Exception;
}
