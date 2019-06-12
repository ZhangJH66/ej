package com.briup.apps.ej.web.controller;


import com.briup.apps.ej.bean.Order;
import com.briup.apps.ej.bean.OrderLine;
import com.briup.apps.ej.service.IOrderLineService;
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
@RequestMapping("/orderLine")
public class OrderLineController {
    @Autowired
    private IOrderLineService orderLineService;

    @ApiOperation("查询全部订单项目")
    @GetMapping("findAll")
    public Message findAll() {
        List<OrderLine> list = orderLineService.findAll();
        return MessageUtil.success("success", list);
    }

    @ApiOperation("通过id查询订单项目")
    @GetMapping("findById")
    public Message findById(
            @ApiParam(value = "主键", required = true)
            @RequestParam(value = "id") long id) {
        OrderLine orderLine = orderLineService.findById(id);
        return MessageUtil.success("success", orderLine);
    }


    @ApiOperation("保存或更新订单项目")
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(OrderLine orderline) {
        try {
            orderLineService.saveOrUpdate(orderline);
            return MessageUtil.success("保存成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    @ApiOperation("通过id删除订单项目")
    @GetMapping("deleteById")
    public Message deleteById(@ApiParam(value = "主键", required = true) @RequestParam("id") long id) {
        try {
            orderLineService.deleteById(id);
            return MessageUtil.success("删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    @PostMapping("batchDelete")
    @ApiOperation("批量删除订单项信息")
    public Message batchDelete(@NotNull(message = "ids不能为空") long[] ids) throws Exception{
        orderLineService.batchDelete(ids);
        return MessageUtil.success("批量删除成功");
    }
}