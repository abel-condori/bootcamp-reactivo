package com.bcp.app.controller;

import com.bcp.app.model.document.Debit;
import com.bcp.app.model.request.BaseResponse;
import com.bcp.app.service.DebitService;
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
@RequestMapping("/api/debit")
public class DebitController {

    @Autowired
    private DebitService debitService;

    @PostMapping
    public Single<BaseResponse> create(@RequestBody Debit debit) {
        return debitService.create(debit)
                .subscribeOn(Schedulers.io())
                .map(o -> BaseResponse.successNoData());
    }

    @GetMapping
    public Flowable<BaseResponse> findAll() {
        return debitService.findAll()
                .subscribeOn(Schedulers.io())
                .map(debit -> BaseResponse.successWithData(debit));
    }

    @PutMapping
    public Single<BaseResponse> update(@RequestBody Debit debit) {
        return debitService.update(debit)
                .subscribeOn(Schedulers.io())
                .toSingle(() -> BaseResponse.successNoData());
    }

    @DeleteMapping("/{id}")
    public Single<BaseResponse> delete(@PathVariable String id) {
        return debitService.delete(id)
                .subscribeOn(Schedulers.io())
                .toSingle(() -> BaseResponse.successNoData());

    }

    @GetMapping("/{id}")
    public Single<BaseResponse> findById(@PathVariable String id) {
        return debitService.findById(id)
                .subscribeOn(Schedulers.io())
                .toSingle()
                .map(credit -> BaseResponse.successWithData(credit));
    }
}
