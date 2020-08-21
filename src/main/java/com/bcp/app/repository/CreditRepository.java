package com.bcp.app.repository;

import com.bcp.app.model.document.Credit;
import org.springframework.data.repository.reactive.RxJava2CrudRepository;
import org.springframework.data.repository.reactive.RxJava2SortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditRepository extends RxJava2SortingRepository<Credit, String> {
}
