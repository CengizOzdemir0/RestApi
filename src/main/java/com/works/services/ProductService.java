package com.works.services;

import com.works.Utils.RestEnum;
import com.works.entities.Note;
import com.works.entities.Product;
import com.works.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductService {
    final ProductRepository productRepository;

    public ResponseEntity save(Product product){
        Map<RestEnum, Object> hm = new LinkedHashMap<>();

        try {
            productRepository.save(product);
            hm.put(RestEnum.status,true);
            hm.put(RestEnum.result,product);
            return new ResponseEntity(product, HttpStatus.OK);
        }catch (Exception ex){
            hm.put(RestEnum.status,false);
            hm.put(RestEnum.errors,ex.getMessage());
            return new ResponseEntity(hm,HttpStatus.BAD_REQUEST);

        }
    }
    public ResponseEntity list(int pageCount ){
        Pageable pageable = PageRequest.of(pageCount,5);
        Page<Product> productPage = productRepository.findAll(pageable);
        return new ResponseEntity(productPage,HttpStatus.OK);
    }
}