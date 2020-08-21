package com.bcp.app.controller;

import com.bcp.app.model.document.Customer;
import com.bcp.app.model.request.BaseResponse;
import com.bcp.app.service.CustomerService;
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
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public Single<BaseResponse> create(@RequestBody Customer customer) {
        return customerService.create(customer)
                .subscribeOn(Schedulers.io())
                .map(obj -> BaseResponse.successNoData());
    }

    @GetMapping
    public Flowable<BaseResponse> findAll() {
        return customerService.findAll()
                .subscribeOn(Schedulers.io())
                .map(customer -> BaseResponse.successWithData(customer));
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody Customer customer) {
        customerService.update(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public Single<BaseResponse> delete(@PathVariable String id) {
        return customerService.delete(id)
                .subscribeOn(Schedulers.io())
                .toSingle(() -> BaseResponse.successNoData());
    }

    @GetMapping("/{id}")
    public Single<BaseResponse> findById(@PathVariable String id) {
        return customerService.findById(id)
                .subscribeOn(Schedulers.io())
                .toSingle()
                .map(customer -> BaseResponse.successWithData(customer));

    }
}
