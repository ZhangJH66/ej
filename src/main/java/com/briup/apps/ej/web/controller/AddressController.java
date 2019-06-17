package com.briup.apps.ej.web.controller;
import com.briup.apps.ej.bean.Address;
import com.briup.apps.ej.bean.extend.AddressExtend;
import com.briup.apps.ej.service.IAddressService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private IAddressService addressService;

    @GetMapping("query")
    @ApiOperation("查询订单信息，并且订单级联关键的属性")
    public Message query(Long customerId){
        List<AddressExtend> list = addressService.query(customerId);
        return MessageUtil.success("success",list);
    }
    //@ApiOperation("模糊查询")
   // @GetMapping("query")
   // public Message query(Address address){
    //    List<Address> list = addressService.query(address);
   //     return MessageUtil.success("success",list);
   // }

    @GetMapping("findAll") public Message findAll(){
        List<Address> list = addressService.findAll();
        return MessageUtil.success("success",list);
    }
    @ApiOperation("通过id查询")
    @GetMapping("findById")
    public Message findById(@ApiParam(value = "主键",required = true) @RequestParam(value = "id") long id){
        Address address=addressService.findById(id);
        return MessageUtil.success("success",address);
    }
    @PostMapping("saveOrUpdate")
    @ApiOperation("保存或者更新地址信息")
    public Message saveOrUpdate(@Valid @ModelAttribute Address address) throws Exception{
        addressService.saveOrUpdate(address);
        return MessageUtil.success("操作成功");
    }

    @GetMapping("deleteById")
    @ApiOperation("通过ID删除")
    public Message deleteById(@NotNull @RequestParam("id") Long id) throws Exception{
       addressService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @PostMapping("batchDelete")
    @ApiOperation("批量删除地址信息")
    public Message batchDelete(long[] ids) throws Exception{
        addressService.batchDelete(ids);
        return MessageUtil.success("批量删除成功");
    }
}
