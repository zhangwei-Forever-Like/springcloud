package com.zw.springcloud.controller;

import com.zw.springcloud.entities.CommonResult;
import com.zw.springcloud.entities.Payment;
import com.zw.springcloud.service.PaymentSerice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentSerice paymentSerice;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result=paymentSerice.create(payment);
        log.info("=================插入的结果："+result);

        if(result>0){
            return new CommonResult(200,"插入数据库成功,serverPort："+serverPort,result);
        }else{
            return  new CommonResult(400,"插入失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment=paymentSerice.getPaymentById(id);
        log.info("=================插入的结果："+payment);

        if(payment !=null){
            return new CommonResult(200,"插入数据库成功,serverPort："+serverPort,payment);
        }else{
            return  new CommonResult(400,"插入失败"+id,null);
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }
}
