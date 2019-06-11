package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Address;

import java.util.List;

public interface IAddressService {
    List<Address> query(Address address);

    List<Address> findAll();

    Address findById(long id);

    void saveOrUpdate(Address address) throws Exception;

    void deleteById(long id) throws Exception;
}
