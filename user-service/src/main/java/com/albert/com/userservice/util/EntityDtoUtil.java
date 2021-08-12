package com.albert.com.userservice.util;

import com.albert.com.userservice.dto.TransactionRequestDto;
import com.albert.com.userservice.dto.TransactionResponseDto;
import com.albert.com.userservice.dto.TransactionStatus;
import com.albert.com.userservice.dto.UserDto;
import com.albert.com.userservice.entity.User;
import com.albert.com.userservice.entity.UserTransaction;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;


//Util class to do conversion from entity to Dto and Dto to entity
public class EntityDtoUtil {
    public static UserDto toDto(User user) {
        UserDto dto = new UserDto();
        BeanUtils.copyProperties(user, dto);
        return dto;
    }

    public static User toEntity(UserDto userDto) {
        User userEntity = new User();
        BeanUtils.copyProperties(userDto, userEntity);
        return userEntity;
    }

    public static UserTransaction toEntity(TransactionRequestDto requestDto) {
        UserTransaction ut = new UserTransaction();
        ut.setUserId(requestDto.getUserId());
        ut.setAmount(requestDto.getAmount());
        ut.setTransactionDate(LocalDateTime.now());
        return ut;
    }

    public static TransactionResponseDto toDto(TransactionRequestDto requestDto, TransactionStatus status) {
        TransactionResponseDto responseDto = new TransactionResponseDto();
        responseDto.setAmount(requestDto.getAmount());
        responseDto.setUserId(requestDto.getUserId());
        responseDto.setStatus(status);
        return responseDto;
      }

}
