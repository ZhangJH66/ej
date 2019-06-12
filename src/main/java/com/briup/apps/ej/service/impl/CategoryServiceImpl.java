package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.Category;
import com.briup.apps.ej.bean.CategoryExample;
import com.briup.apps.ej.dao.CategoryMapper;
import com.briup.apps.ej.service.ICategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    // 自动注入mapper实例
    @Resource
    private CategoryMapper categoryMapper;



    @Override
    public List<Category> query(Category category) {
        // 创建空模板
        CategoryExample example = new CategoryExample();
        // 在模板中添加条件
        if(category.getName()!=null){
            example
                    .createCriteria()
                    .andNameLike("%"+category.getName()+"%");
        }
        if(category.getNum()!=null){
            example
                    .createCriteria()
                   .andNumEqualTo(category.getNum());
        }
        if(category.getParentId()!=null){
            example.createCriteria().andParentIdEqualTo(category.getParentId());
        }

        return categoryMapper.selectByExample(example);
    }

    @Override
    public List<Category> findAll() {
        CategoryExample example = new CategoryExample();
        return categoryMapper.selectByExample(example);
    }

    @Override
    public Category findById(long id) {
        return categoryMapper.selectByPrimaryKey(id);

    }

    @Override
    public void saveOrUpdate(Category category) throws Exception {
        if(category.getId() == null){
            // 初始化属性
            categoryMapper.insert(category);
        } else {
            categoryMapper.updateByPrimaryKey(category);
        }
    }


    @Override
    public void batchDelete(long[] ids) throws Exception {
        for (long id : ids) {
            categoryMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public void deleteById(long id) throws Exception {
        Category category = categoryMapper.selectByPrimaryKey(id);
        if (category == null) {
            throw new Exception("要删除的用户不存在");
        } else {
            categoryMapper.deleteByPrimaryKey(id);
        }
    }

    }
