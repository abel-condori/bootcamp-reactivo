package com.bcp.app.repository;

import com.bcp.app.model.document.Transaction;
import org.springframework.data.repository.reactive.RxJava2CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends RxJava2CrudRepository<Transaction, String> {
}
