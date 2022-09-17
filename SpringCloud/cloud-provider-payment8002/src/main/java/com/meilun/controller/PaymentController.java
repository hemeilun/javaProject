package com.meilun.controller;

import com.meilun.entities.CommentResult;
import com.meilun.entities.Payment;
import com.meilun.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @Value("${server.port}")
    private String port;


    @PostMapping("/payment/create")
    public CommentResult<Payment> insertPayment(@RequestBody Payment payment){

        boolean save = paymentService.save(payment);
        if(save){
            return new CommentResult<>(200,"插入成功,port: "+port);
        }else{
            return new CommentResult<>(444,"插入失败");
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommentResult<Payment> setletcById(@PathVariable(value = "id") Integer id){
        Payment byId = paymentService.getById(id);
        if(byId!=null){
            return new CommentResult<>(200,"查询成功,port: "+port,byId);
        }else {
            return new CommentResult<>(444,"没有id对应的数据");
        }
    }

}
