package org.sid.billingservice.feign;

import org.sid.billingservice.model.Customer;
import org.sid.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

//Communiquer avec le microservice "PRODUCT-SERVICE"
@FeignClient(name = "PRODUCT-SERVICE")
public interface ProductItemRestClient {

    @GetMapping(path = "/products")
    PagedModel<Product> pageProducts(@RequestParam(value = "page") int page,
                                     @RequestParam(name = "size") int size);

    @GetMapping(path = "/products/{id}")
    Product getProductById(@PathVariable(name = "id") Long id);
}
