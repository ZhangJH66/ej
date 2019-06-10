package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Order;
import com.briup.apps.ej.service.IOrderService;

import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {


    @Autowired
    private IOrderService orderService;

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



    @ApiOperation("保存或更新订单信息")
    @GetMapping("saveOrUpdate")
    public Message saveOrUpdate(Order order){
        try {
            orderService.saveOrUpdate(order);
            return MessageUtil.success("保存成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
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
}