package com.briup.apps.ej.bean.VM;

/**
 * 数据模型
 * 订单在前端显示的时候需要的数据模型
 * */
public class AddressVM {
    private String customerId;
    private Long addressId;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }
}
