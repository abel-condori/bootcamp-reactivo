package com.bcp.app.repository;

import com.bcp.app.model.document.Customer;
import io.reactivex.Maybe;
import io.reactivex.Single;
import org.springframework.data.repository.reactive.RxJava2CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends RxJava2CrudRepository<Customer, String> {
    Maybe<Customer> findByDocumentNumber(String documentNumber);
}
