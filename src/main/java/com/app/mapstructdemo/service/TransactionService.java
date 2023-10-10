package com.app.mapstructdemo.service;


import com.app.mapstructdemo.dto.TransactionDTO;
import com.app.mapstructdemo.dto.TransactionViewDTO;
import com.app.mapstructdemo.mapper.TransactionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {

	private final TransactionMapper transactionMapper;

	public TransactionViewDTO getTransactionDetails(TransactionDTO transactionDTO) {
		return transactionMapper.toViewDTO(transactionDTO);
	}

}