package com.briup.apps.ej.bean.vm;

import io.swagger.annotations.ApiParam;

public class AddressVM {
    @ApiParam(value = "顾客ID",required = true)
    private Long customerId;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
