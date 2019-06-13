package com.briup.apps.ej.web.controller;


import com.briup.apps.ej.bean.Customer;
import com.briup.apps.ej.service.ICustomerService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@Api(description = "顾客管理相关接口")
@Validated
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @ApiOperation("查询所有顾客")
    @GetMapping("/findAll")
    public Message findAll(){
        List<Customer> list=customerService.findAll();
        return MessageUtil.success("success",list);
    }

    @ApiOperation("按顾客姓名模糊查找")
    @GetMapping("/query")
    public Message query(Customer customer){
        List<Customer> list=customerService.query(customer);
        return MessageUtil.success("success",list);
    }

    @ApiOperation("通过id查询")
    @GetMapping("/findById")
    public Message findById(long id){
        Customer customer= customerService.findById(id);
        return MessageUtil.success("success",customer);
    }

    @ApiOperation("新增或更新顾客信息")
    @PostMapping("/saveOrUpdate")
    public Message saveOrUpdate(Customer customer){
        try {
            customerService.saveOrUpdate(customer);
            return MessageUtil.success("success",customer);
        }catch (Exception e){
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    @ApiOperation("按ID删除顾客信息")
    @GetMapping("/deleteById")
    public Message deleteById(long id){
        try {
            customerService.deleteById(id);
            return MessageUtil.success("删除成功！");
        }catch (Exception e){
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }
    @PostMapping("batchDelete")
    @ApiOperation("批量删除顾客信息")
    public Message batchDelete(@NotNull(message = "ids不能为空") long[] ids) throws Exception{
        customerService.batchDelete(ids);
        return MessageUtil.success("批量删除成功");
    }
}
