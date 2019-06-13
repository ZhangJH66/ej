package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Product;
import com.briup.apps.ej.service.IProductService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ApiOperation("查询所有商品")
    @GetMapping("/findAll")
    public Message findAll(){
        List<Product> list = productService.findAll();
        return MessageUtil.success("success",list);
    }

    @ApiOperation("按商品ID查询商品")
    @GetMapping("/findById")
    public Message findById(long id){
        Product product = productService.findById(id);
        return MessageUtil.success("success",product);
    }

    @ApiOperation("模糊查询")
    @GetMapping("/query")
    public Message query(Product product){
        List<Product> list = productService.query(product);
        return MessageUtil.success("success",list);
    }

    @ApiOperation("更新或添加商品")
    @PostMapping("/saveOrUpdate")
    public Message saveOrUpdate(Product product){
        try {
            productService.saveOrUpdate(product);
            return MessageUtil.success("保存成功！");
        }catch (Exception e){
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    @ApiOperation("删除商品")
    @GetMapping("/deleteById")
    public Message deleteById(@NotNull long id){
        try {
            productService.deleteById(id);
            return MessageUtil.success("删除成功！");
        }catch (Exception e){
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    @PostMapping("batchDelete")
    @ApiOperation("批量删除商品信息")
    public Message batchDelete(@NotNull(message = "ids不能为空") long[] ids) throws Exception{
        productService.batchDelete(ids);
        return MessageUtil.success("批量删除成功");
    }
}
