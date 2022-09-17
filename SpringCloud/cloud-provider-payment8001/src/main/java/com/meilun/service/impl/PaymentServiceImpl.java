package com.meilun.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.meilun.entities.Payment;
import com.meilun.service.PaymentService;
import com.meilun.mapper.PaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment>
    implements PaymentService{

//    @Autowired
//    PaymentMapper paymentMapper;

}




