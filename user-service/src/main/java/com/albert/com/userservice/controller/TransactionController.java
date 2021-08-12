package com.albert.com.userservice.controller;

import com.albert.com.userservice.dto.TransactionRequestDto;
import com.albert.com.userservice.dto.TransactionResponseDto;
import com.albert.com.userservice.entity.UserTransaction;
import com.albert.com.userservice.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("user/transaction")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public Mono<TransactionResponseDto> createTransaction(
            @RequestBody Mono<TransactionRequestDto> requestDtoMono) {
        return requestDtoMono.flatMap(this.transactionService::createTransaction);

    }
    @GetMapping
    public Flux<UserTransaction>getUserTransactions(@RequestParam("userId")int userId){
        return  this.transactionService.getUserTransactions(userId);
    }
}