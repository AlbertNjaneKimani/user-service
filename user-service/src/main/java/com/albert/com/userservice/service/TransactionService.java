package com.albert.com.userservice.service;

import com.albert.com.userservice.dto.TransactionRequestDto;
import com.albert.com.userservice.dto.TransactionResponseDto;
import com.albert.com.userservice.dto.TransactionStatus;
import com.albert.com.userservice.entity.UserTransaction;
import com.albert.com.userservice.repository.UserRepository;
import com.albert.com.userservice.repository.UserTransactionRepository;
import com.albert.com.userservice.util.EntityDtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TransactionService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserTransactionRepository userTransactionRepository;

    public Mono<TransactionResponseDto> createTransaction(final TransactionRequestDto requestDto) {
        return this.userRepository.updateUserBalance(requestDto.getUserId(), requestDto.getAmount())
                .filter(Boolean::booleanValue)
                .map(b -> EntityDtoUtil.toEntity(requestDto))
                .flatMap(this.userTransactionRepository::save)
                .map(ut -> EntityDtoUtil.toDto(requestDto, TransactionStatus.APPROVED))
                .defaultIfEmpty(EntityDtoUtil.toDto(requestDto, TransactionStatus.DECLINED));

    }
    public Flux<UserTransaction> getUserTransactions(int userId){
        return this.userTransactionRepository.findByUserId(userId);
    }
}

