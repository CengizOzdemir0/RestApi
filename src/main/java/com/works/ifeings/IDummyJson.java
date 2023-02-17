package com.works.ifeings;

import com.works.props.DummyProduct;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "UDummyJson",url = "https://dummyjson.com/")
public interface IDummyJson {

    @GetMapping("/products")
    DummyProduct dummyProduct();


}
