package com.bcp.app.service;

import com.bcp.app.model.document.Debit;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DebitService {
    Single<Debit> create(Debit debit);

    Flowable<Debit> findAll();

    Completable update(Debit debit);

    Completable delete(String id);

    Maybe<Debit> findById(String id);
}
