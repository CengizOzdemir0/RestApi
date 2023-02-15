package com.works.configs;

import com.works.Utils.RestEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {
    // exceptionu dinlemek için
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity MethodArgumentNotValid(){
        Map<RestEnum, Object> hm = new LinkedHashMap<>();
        hm.put(RestEnum.status,false);
        return new ResponseEntity(hm, HttpStatus.BAD_REQUEST);
    }


}
