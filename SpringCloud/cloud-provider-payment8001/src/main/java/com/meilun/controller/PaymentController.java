package com.meilun.controller;

import com.meilun.entities.CommentResult;
import com.meilun.entities.Payment;
import com.meilun.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @Autowired
    DiscoveryClient discoveryClient;


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

    @GetMapping("/payment/discovery")
    public DiscoveryClient getTheDiscoveryClient(){

        List<String> services = discoveryClient.getServices();
        for (String service:services) {
            System.out.println(service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");

        for (ServiceInstance instace: instances) {
            System.out.println(instace.getServiceId()+" "+instace.getUri()+" "+instace.getMetadata());
        }

        return this.discoveryClient;
    }

}
