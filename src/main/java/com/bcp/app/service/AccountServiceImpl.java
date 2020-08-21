package com.bcp.app.service;

import com.bcp.app.model.RelationType;
import com.bcp.app.model.document.Credit;
import com.bcp.app.model.document.Customer;
import com.bcp.app.model.document.Debit;
import com.bcp.app.model.document.Product;
import com.bcp.app.model.dto.CreditAccount;
import com.bcp.app.model.dto.DebitAccount;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import javax.persistence.EntityNotFoundException;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private DebitService debitService;

    @Autowired
    private CreditService creditService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    @Override
    public Single<DebitAccount> createDebitAccount(DebitAccount debitAccount) {
        Flowable<Boolean> flag;
        Customer customer = customerService.findByDocumentNumber(debitAccount.getCustomer().getDocumentNumber())
                .switchIfEmpty(customerService.create(debitAccount.getCustomer()))
                .blockingGet();

        /*int fflag =  productService.findByCustomerId(customer.getCustomerId())
                .map(product -> {
                    return debitService.findById(product.getAccountId())
                            .filter(debit -> debit.getDebitType().equals(debitAccount.getDebit().getDebitType()))
                            .subscribe();
                });*/
        Debit debit = debitService.create(debitAccount.getDebit()).blockingGet();

        Product product = new Product();
        product.setCustomerId(customer.getCustomerId());
        product.setAccountId(debit.getAccountId());
        product.setRelationType(RelationType.TITULAR);

        product = productService.create(product).blockingGet();

        debitAccount.setCustomer(customer);
        debitAccount.setDebit(debit);

        return Single.just(debitAccount);
    }

    @Override
    public Single<CreditAccount> createCredittAccount(CreditAccount creditAccount) {
        Customer customer = customerService.findByDocumentNumber(creditAccount.getCustomer().getDocumentNumber())
                .switchIfEmpty(customerService.create(creditAccount.getCustomer()))
                .blockingGet();
        Credit credit = creditService.create(creditAccount.getCredit()).blockingGet();

        Product product = new Product();
        product.setCustomerId(customer.getCustomerId());
        product.setAccountId(credit.getAccountId());
        product.setRelationType(RelationType.TITULAR);

        product = productService.create(product).blockingGet();

        creditAccount.setCustomer(customer);
        creditAccount.setCredit(credit);

        return Single.just(creditAccount);
    }
}
