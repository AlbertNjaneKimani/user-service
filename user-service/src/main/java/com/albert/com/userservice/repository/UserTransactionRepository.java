package com.albert.com.userservice.repository;

import com.albert.com.userservice.dto.TransactionResponseDto;
import com.albert.com.userservice.entity.UserTransaction;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface UserTransactionRepository extends ReactiveCrudRepository<UserTransaction, Integer> {
    Flux<UserTransaction>findByUserId(int userId);
}
