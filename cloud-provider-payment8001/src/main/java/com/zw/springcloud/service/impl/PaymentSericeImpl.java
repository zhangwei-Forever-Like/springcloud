package com.zw.springcloud.service.impl;

import com.zw.springcloud.dao.PaymentDao;
import com.zw.springcloud.entities.Payment;
import com.zw.springcloud.service.PaymentSerice;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentSericeImpl implements PaymentSerice {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
