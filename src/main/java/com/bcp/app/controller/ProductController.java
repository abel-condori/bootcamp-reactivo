package com.bcp.app.controller;

import com.bcp.app.model.document.Product;
import com.bcp.app.model.request.BaseResponse;
import com.bcp.app.service.ProductService;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    /*@PostMapping
    public Single<BaseResponse> create(@RequestBody Product product) {
        return productService.create(product)
                .subscribeOn(Schedulers.io())
                .map(o -> BaseResponse.successNoData());
    }

    @GetMapping
    public Flowable<BaseResponse> findAll() {
        return productService.findAll()
                .subscribeOn(Schedulers.io())
                .map(product -> BaseResponse.successWithData(product));
    }

    @PutMapping
    public Single<BaseResponse> update(@RequestBody Product product) {
        return productService.update(product)
                .subscribeOn(Schedulers.io())
                .toSingle(() -> BaseResponse.successNoData());
    }

    @DeleteMapping("/{id}")
    public Single<BaseResponse> delete(@PathVariable String id) {
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Single<BaseResponse> findById(@PathVariable String id) {
        return new ResponseEntity<>(productService.findById(id),HttpStatus.OK);
    }*/
}
