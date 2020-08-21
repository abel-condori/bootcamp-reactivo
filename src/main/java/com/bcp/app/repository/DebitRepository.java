package com.bcp.app.repository;

import com.bcp.app.model.document.Debit;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.reactive.RxJava2CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DebitRepository extends RxJava2CrudRepository<Debit, String> {
}
