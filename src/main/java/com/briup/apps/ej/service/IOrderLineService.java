package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.OrderLine;

import java.util.List;

public interface IOrderLineService {
    List<OrderLine> findAll();

    OrderLine findById(long id);

    void saveOrUpdate(OrderLine orderLine) throws Exception ;

    void deleteById(long id) throws Exception ;
}
