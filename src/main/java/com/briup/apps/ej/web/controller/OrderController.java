package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Order;
import com.briup.apps.ej.bean.VM.OrderAndOrderLineVM;
import com.briup.apps.ej.bean.VM.OrderVM;
import com.briup.apps.ej.bean.extend.OrderExtend;
import com.briup.apps.ej.service.IOrderService;

import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;



@Api(description = "订单管理相关接口")
@Validated
@RestController
@RequestMapping("/order")
public class OrderController {


    @Autowired
    private IOrderService orderService;


    @GetMapping("queryBasic")
    @ApiOperation("查询订单信息，返回列表数据")
    public Message queryBasic(Long customerId,Long waiterId){
        List<OrderVM> list = orderService.queryBasic(customerId,waiterId);
        return MessageUtil.success("success",list);
    }


    @GetMapping("query")
    @ApiOperation("查询订单信息，并且订单级联关键的属性")
    public Message query(Long customerId,Long waiterId) {
        List<OrderExtend> list = orderService.query(customerId, waiterId);
        return MessageUtil.success("success", list);
    }

    @ApiOperation("查询全部订单")
    @GetMapping("findAll")
    public Message findAll() {
        List<Order> list = orderService.findAll();
        return MessageUtil.success("success", list);
    }



    @ApiOperation("通过id查询订单")
    @GetMapping("findById")
    public Message findById(
            @ApiParam(value = "主键",required = true)
            @RequestParam(value = "id") long id){
        Order order = orderService.findById(id);
        return MessageUtil.success("success",order);
    }


    @PostMapping("save")
    @ApiOperation("保存订单信息")
    public Message saveOrUpdate(@Valid @ModelAttribute OrderAndOrderLineVM order) throws Exception{
        orderService.save(order);
        return MessageUtil.success("操作成功");
    }



    @ApiOperation("通过id删除订单信息")
    @GetMapping("deleteById")
    public Message deleteById(@ApiParam(value = "主键",required = true) @RequestParam("id") long id){
        try {
            orderService.deleteById(id);
            return MessageUtil.success("删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }
    @PostMapping("batchDelete")
    @ApiOperation("批量删除订单信息")
    public Message batchDelete(@NotNull(message = "ids不能为空") long[] ids) throws Exception{
        orderService.batchDelete(ids);
        return MessageUtil.success("批量删除成功");
    }
    }

