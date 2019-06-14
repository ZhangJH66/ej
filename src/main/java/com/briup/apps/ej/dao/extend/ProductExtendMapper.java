package com.briup.apps.ej.dao.extend;

import com.briup.apps.ej.bean.VM.ProductVM;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductExtendMapper {
    List<ProductVM> queryBasic(
            @Param("categoryId") Long categoryId
    );
}
