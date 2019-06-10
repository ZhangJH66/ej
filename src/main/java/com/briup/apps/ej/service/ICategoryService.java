package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Category;


import java.util.List;

public interface ICategoryService {
    List<Category> query(Category category);
    List<Category> findAll();
    Category findById(long id);
    void saveOrUpdate(Category category) throws Exception ;
    void deleteById(long id) throws Exception ;


}
