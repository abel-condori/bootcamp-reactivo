package com.bcp.app.service;

import com.bcp.app.model.document.Customer;
import io.reactivex.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {
    Single<Customer> create(Customer customer);

    Flowable<Customer> findAll();

    Single<Customer> update(Customer customer);

    Completable delete(String id);

    Maybe<Customer> findById(String id);

    Maybe<Customer> findByDocumentNumber(String documentNumber);
}
