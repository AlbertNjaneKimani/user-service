package com.albert.com.userservice.controller;

import com.albert.com.userservice.dto.UserDto;
import com.albert.com.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public Flux<UserDto> getAllUsers() {
        return this.userService.allUsers();
    }

    @GetMapping("{userId}")
    public Mono<ResponseEntity<UserDto>> getUserById(@PathVariable("userId") Integer userId) {
        return this.userService.getUserById(userId)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<UserDto> createUser(@RequestBody Mono<UserDto> userDtoMono) {
        return this.userService.createUser(userDtoMono);
    }

    @PutMapping("{userId}")
    public Mono<ResponseEntity<UserDto>> updateUser(@PathVariable("userId") Integer userId,
                                                    @RequestBody Mono<UserDto> userDtoMono) {
        return this.userService.updateUser(userId, userDtoMono)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{userId}")
    public Mono<Void> deleteUser(@PathVariable("userId") Integer userId) {
        return this.userService.deleteUser(userId);
    }
}
