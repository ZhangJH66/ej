package com.briup.apps.ej.bean.extend;

import com.briup.apps.ej.bean.*;

import java.util.List;


public class AddressExtend extends Address {
    private Customer customer;
    private List<Address> addresses;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
