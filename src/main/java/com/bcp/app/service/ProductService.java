package com.bcp.app.service;

import com.bcp.app.model.document.Product;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
    Single<Product> create(Product product);

    Flowable<Product> findAll();

    Completable update(Product product);

    Completable delete(String id);

    Maybe<Product> findById(String id);

    Flowable<Product> findByCustomerId(String customerId);
}
