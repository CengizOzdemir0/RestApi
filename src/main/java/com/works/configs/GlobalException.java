package com.works.configs;

import com.works.Utils.RestEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {
    // exceptionu dinlemek için
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity MethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();
        hm.put(RestEnum.status, false);
        hm.put(RestEnum.errors, parseError(ex.getFieldErrors()));

        return new ResponseEntity(hm, HttpStatus.BAD_REQUEST);
    }

    private Object parseError(List<FieldError> fieldErrors) {
        List ls = new ArrayList();
        for (FieldError error : fieldErrors) {
            String field = error.getField();
            String message = error.getDefaultMessage();
            Map map = new LinkedHashMap();
            map.put("field",field);
            map.put("message",message);
            ls.add(map);
        }

        return ls;
    }


}
