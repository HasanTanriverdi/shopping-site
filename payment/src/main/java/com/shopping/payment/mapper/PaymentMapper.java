package com.shopping.payment.mapper;

import com.shopping.payment.dto.PaymentDto;
import com.shopping.payment.entity.PaymentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper extends IEntityMapper<PaymentDto, PaymentEntity>{
}
