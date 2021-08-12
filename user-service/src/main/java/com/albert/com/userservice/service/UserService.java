package com.albert.com.userservice.service;

import com.albert.com.userservice.dto.UserDto;
import com.albert.com.userservice.repository.UserRepository;
import com.albert.com.userservice.util.EntityDtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    //Get All Users
    public Flux<UserDto> allUsers() {
        return this.userRepository.findAll()
                .map(EntityDtoUtil::toDto);
    }

    //Get user by id
    public Mono<UserDto> getUserById(final int userId) {
        return this.userRepository.findById(userId)
                .map(EntityDtoUtil::toDto);
    }

    //Save New User
    public Mono<UserDto> createUser(Mono<UserDto> userDtoMono) {
        return userDtoMono.map(EntityDtoUtil::toEntity)
                .flatMap(this.userRepository::save)
                .map(EntityDtoUtil::toDto);
    }

    //Update User
    public Mono<UserDto> updateUser(final int userId, Mono<UserDto> userDtoMono) {
        return this.userRepository.findById(userId)
                .flatMap(u -> userDtoMono.map(EntityDtoUtil::toEntity))
                .doOnNext(e -> e.setId(userId))
                .flatMap(this.userRepository::save)
                .map(EntityDtoUtil::toDto);

    }

    // Delete User
    public Mono<Void> deleteUser(final int userId) {
        return this.userRepository.deleteById(userId);
    }
}

