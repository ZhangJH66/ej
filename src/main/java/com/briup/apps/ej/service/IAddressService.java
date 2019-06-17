package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Address;
import com.briup.apps.ej.bean.extend.AddressExtend;

import java.util.List;

public interface IAddressService {
    List<AddressExtend> query(Long customerId);

    List<Address> query(Address address);

    List<Address>findAll();

    Address findById(long id);

    void saveOrUpdate(Address address)throws Exception;

    void deleteById(long id) throws Exception ;
    void batchDelete(long[] ids) throws Exception;
}
