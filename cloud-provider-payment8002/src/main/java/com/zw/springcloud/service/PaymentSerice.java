package com.zw.springcloud.service;

import com.zw.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentSerice {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

}
