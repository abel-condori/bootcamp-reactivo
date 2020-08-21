package com.bcp.app.service;

import com.bcp.app.model.document.Product;
import com.bcp.app.repository.ProductRepository;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Single<Product> create(Product product) {
       return productRepository.save(product);
    }

    @Override
    public Flowable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Single<Product> update(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Completable delete(String id) {
        return productRepository.deleteById(id);
    }

    @Override
    public Maybe<Product> findById(String id) {
        return productRepository.findById(id);
    }

    @Override
    public Flowable<Product> findByCustomerId(String customerId) {
        return productRepository.findByCustomerId(customerId);
    }
}
