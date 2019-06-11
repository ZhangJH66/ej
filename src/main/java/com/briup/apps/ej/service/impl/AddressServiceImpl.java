package com.briup.apps.ej.service.impl;


import com.briup.apps.ej.bean.Address;
import com.briup.apps.ej.bean.AddressExample;
import com.briup.apps.ej.dao.AddressMapper;
import com.briup.apps.ej.service.IAddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AddressServiceImpl implements IAddressService {
    // 自动注入mapper实例
    @Resource
    private AddressMapper addressMapper;

    @Override
    public List<Address> query(Address address) {
        // 创建空模板
        AddressExample example = new AddressExample();
        // 在模板中添加条件
        if (address.getProvince() != null) {
            example
                    .createCriteria()
                    .andProvinceLike("%" + address.getAddress() + "%");
        }
        if (address.getCity() != null) {
            example
                    .createCriteria()
                    .andCityLike("%"+address.getCity()+"%");
        }
        if (address.getArea() != null) {
            example
                    .createCriteria()
                    .andAreaEqualTo("%"+address.getArea()+"%");
        }
        if (address.getTelephone() != null) {
            example
                    .createCriteria()
                    .andTelephoneEqualTo("%"+address.getTelephone()+"%");
        }
        if (address.getCustomerId() != null) {
            example.createCriteria().andCityLike("%"+address.getCustomerId()+"%");
        }
        return addressMapper.selectByExample(example);
    }

    @Override
    public List<Address> findAll() {
        AddressExample example = new AddressExample();
        return addressMapper.selectByExample(example);
    }

    @Override
    public Address findById(long id) {
        return addressMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(Address address) throws Exception {
        if (address.getId()==null){
            addressMapper.insert(address);
        }else {
            addressMapper.updateByPrimaryKey(address);
        }
    }



    @Override
    public void deleteById(long id) throws Exception {
        Address address = addressMapper.selectByPrimaryKey(id);
        if(address == null){
            throw new Exception("要删除的用户不存在");
        }else{
            addressMapper.deleteByPrimaryKey(id);
        }
    }
}