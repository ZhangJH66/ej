package com.briup.apps.ej.dao.extend;

import com.briup.apps.ej.bean.extend.AddressExtend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressExtendMapper {
    List<AddressExtend> query(
            @Param("customerId") Long customerId

    );
}
