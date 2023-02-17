package com.works.services;

import com.works.Utils.RestEnum;
import com.works.entities.Note;
import com.works.entities.Product;
import com.works.ifeings.IDummyJson;
import com.works.props.DummyProduct;
import com.works.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.Map;


@Service
@RequiredArgsConstructor

public class ProductService {
    final ProductRepository productRepository;
    final RestTemplate restTemplate;
    final IDummyJson iDummyJson;
    private static Logger logger = Logger.getLogger(ProductService.class);

    public ResponseEntity save(Product product) {
        Map<RestEnum, Object> hm = new LinkedHashMap<>();

        try {
            logger.info("start save product");
            productRepository.save(product);
            hm.put(RestEnum.status, true);
            hm.put(RestEnum.result, product);
            // Marker marker = MarkerFactory.getMarker("product");
            //log.info(marker,"Arg-1","Arg-2");
            return new ResponseEntity(product, HttpStatus.OK);
        } catch (Exception ex) {
            hm.put(RestEnum.status, false);
            hm.put(RestEnum.errors, ex.getMessage());
            return new ResponseEntity(hm, HttpStatus.BAD_REQUEST);

        }
    }

    public ResponseEntity list(int pageCount) {
        Pageable pageable = PageRequest.of(pageCount, 5);
        Page<Product> productPage = productRepository.findAll(pageable);
        return new ResponseEntity(productPage, HttpStatus.OK);
    }

    public ResponseEntity dummyProduct() {
        String url = "https://dummyjson.com/products";
        DummyProduct stData = restTemplate.getForObject(url,DummyProduct.class);
        System.out.println(iDummyJson.dummyProduct().getProducts().get(0).getTitle());
        return  new ResponseEntity(iDummyJson.dummyProduct(),HttpStatus.OK);
    }

}
