package com.briup.apps.ej.service;


import com.briup.apps.ej.bean.Product;
import com.briup.apps.ej.bean.VM.ProductVM;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    List<ProductVM> queryBasic(Long categoryId);

    List<Product> query(Product product);

    Product findById(long id);

    void saveOrUpdate(Product product)throws Exception;

    void deleteById(long id)throws Exception    ;
    void batchDelete(long[] ids) throws Exception;


}
