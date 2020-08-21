package com.bcp.app.service;

import com.bcp.app.model.document.Transaction;
import com.bcp.app.repository.TransactionRepository;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Single<Transaction> create(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Flowable<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Single<Transaction> update(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Completable delete(String id) {
        return transactionRepository.deleteById(id);
    }

    @Override
    public Maybe<Transaction> findById(String id) {
        return transactionRepository.findById(id);
    }
}
