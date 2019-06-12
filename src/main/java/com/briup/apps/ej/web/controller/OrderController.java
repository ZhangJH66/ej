package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Order;
import com.briup.apps.ej.service.IOrderService;

import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



import javax.validation.constraints.NotNull;
import java.util.List;


@Validated
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
    @PostMapping("saveOrUpdate")
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
    @PostMapping("batchDelete")
    @ApiOperation("批量删除订单信息")
    public Message batchDelete(@NotNull(message = "ids不能为空") long[] ids) throws Exception{
        orderService.batchDelete(ids);
        return MessageUtil.success("批量删除成功");
    }
    }

