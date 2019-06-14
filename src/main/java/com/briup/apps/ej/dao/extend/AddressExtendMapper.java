package com.briup.apps.ej.dao.extend;

import com.briup.apps.ej.bean.VM.AddressVM;
import com.briup.apps.ej.bean.extend.AddressExtend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressExtendMapper {
    List<AddressExtend> query(
            @Param("customerId") Long customerId,
            @Param("addressId") Long addressId);
    List<AddressVM> queryBasic(
            @Param("customerId") Long customerId,
            @Param("addressId") Long addressId);

}
