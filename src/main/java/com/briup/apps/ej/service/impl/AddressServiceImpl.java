package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.Address;
import com.briup.apps.ej.bean.AddressExample;
import com.briup.apps.ej.bean.extend.AddressExtend;
import com.briup.apps.ej.dao.AddressMapper;
import com.briup.apps.ej.dao.extend.AddressExtendMapper;
import com.briup.apps.ej.service.IAddressService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class AddressServiceImpl implements IAddressService {
    @Resource
    private AddressMapper addressMapper;
    @Resource
    private AddressExtendMapper addressExtendMapper;

    @Override
    public List<AddressExtend> query(Long customerId) {
        return addressExtendMapper.query(customerId);
    }
    @Override
    public List<Address> query(Address address) {
        //创建空模板
        AddressExample example=new AddressExample();
        //  在模板中添加条件
        if(address.getProvince()!=null){
            example
                    .createCriteria()
                    .andProvinceLike("%"+address.getProvince()+"%");
        }
        if(address.getCity()!=null){

            example
                    .createCriteria()
                    .andCityLike("%"+address.getCity()+"%");
        }
        if(address.getArea()!=null){
            example.createCriteria().andAreaLike("%"+address.getArea()+"%");
        }
        if(address.getAddress()!=null){
            example.createCriteria().andAddressLike("%"+address.getAddress()+"%");
        }
        if(address.getTelephone()!=null){
            example.createCriteria().andTelephoneLike("%"+address.getTelephone()+"%");
        }

        return addressMapper.selectByExample(example);
    }

    @Override
    public List<Address> findAll() {
        AddressExample example=new AddressExample();
        return addressMapper.selectByExample(example);
    }

    @Override
    public Address findById(long id) {
        return addressMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(Address address)throws Exception{
        if(address.getId()!=null){
            // 初始化属性
            //user.setStatus("正常");
            addressMapper.updateByPrimaryKey(address);

        }else {
            addressMapper.insert(address);
        }

    }

    @Override
    public void deleteById(long id) throws Exception {
       Address address = addressMapper.selectByPrimaryKey(id);
        if(address == null){
            throw new Exception("要删除的地址不存在");
        } else {
            addressMapper.deleteByPrimaryKey(id);
        }
    }
    @Override
    public void batchDelete(long[] ids) throws Exception {
        for(long id :ids){
            addressMapper.deleteByPrimaryKey(id);
        }
    }
}
