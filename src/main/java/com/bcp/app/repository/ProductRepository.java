package com.bcp.app.repository;

import com.bcp.app.model.document.Customer;
import com.bcp.app.model.document.Product;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.reactive.RxJava2CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends RxJava2CrudRepository<Product, String> {
    Flowable<Product> findByCustomerId(String customerId);
}
