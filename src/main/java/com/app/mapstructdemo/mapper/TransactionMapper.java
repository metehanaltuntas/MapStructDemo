package com.app.mapstructdemo.mapper;

import com.app.mapstructdemo.dto.TransactionDTO;
import com.app.mapstructdemo.dto.TransactionViewDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ValueMapping;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    @Mapping(target = "paymentViewType", source = "paymentType")
    @ValueMapping(source = "NETBANKING", target = "NET_BANKING")
    //@ValueMapping(source = "CREDIT_CARD", target = "CARD") // one by one
    //@ValueMapping(source = "DEBIT_CARD", target = "CARD") // one by one
    //@ValueMapping(source = MappingConstants.ANY_REMAINING, target = "CARD") // all remaining
    @ValueMapping(source = MappingConstants.ANY_UNMAPPED, target = "CARD") // all unmapped
    TransactionViewDTO toViewDTO(TransactionDTO transactionDTO);

}