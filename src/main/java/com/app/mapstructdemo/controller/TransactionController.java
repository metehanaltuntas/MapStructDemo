package com.app.mapstructdemo.controller;


import com.app.mapstructdemo.dto.TransactionDTO;
import com.app.mapstructdemo.dto.TransactionViewDTO;
import com.app.mapstructdemo.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping("/transaction")
    public ResponseEntity<TransactionViewDTO> getTransactionDetails(@RequestBody TransactionDTO transactionDTO) {
        return ResponseEntity.ok(transactionService.getTransactionDetails(transactionDTO));
    }

}