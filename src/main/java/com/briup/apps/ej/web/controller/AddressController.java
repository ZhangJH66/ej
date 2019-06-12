package com.briup.apps.ej.web.controller;


import com.briup.apps.ej.bean.Address;
import com.briup.apps.ej.service.IAddressService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired//自动注入
    private IAddressService addressService;

    @ApiOperation("模糊查询")
    @GetMapping("query")
    public Message query(Address address) {
        List<Address> list = addressService.query(address);
        return MessageUtil.success("success", list);
    }

    @GetMapping("/查询所有")
    public Message findAll() {
        List<Address> list = addressService.findAll();
        return MessageUtil.success("success", list);

    }

    @ApiOperation("通过id查询")
    @GetMapping("/findById")
    public Message findById(
            @ApiParam(value = "主键", required = true)
            @RequestParam(value = "id") long id) {
        Address address = addressService.findById(id);
        return MessageUtil.success("success", address);
    }


    @ApiOperation("保存或更新用户信息")
    @PostMapping("/saveOrUpdate")
    public Message saveOrUpdate(Address address) {
        try {
            addressService.saveOrUpdate(address);
            return MessageUtil.success("保存成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    @ApiOperation("删除用户")
    @GetMapping("/deleteById")
    public Message deleteById(@ApiParam(value = "主键", required = true) @RequestParam("id") long id) {
        try {
            addressService.deleteById(id);
            return MessageUtil.success("删除成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }

    }

    @PostMapping("batchDelete")
    @ApiOperation("批量删除服务员信息")
    public Message batchDelete(@NotNull(message = "ids不能为空") long[] ids) throws Exception {
        addressService.batchDelete(ids);
        return MessageUtil.success("批量删除成功");
    }
}