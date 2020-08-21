package com.bcp.app.service;

import com.bcp.app.model.RelationType;
import com.bcp.app.model.document.Credit;
import com.bcp.app.model.document.Customer;
import com.bcp.app.model.document.Debit;
import com.bcp.app.model.document.Product;
import com.bcp.app.model.dto.CreditAccount;
import com.bcp.app.model.dto.DebitAccount;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

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

        Customer customer = customerService.findByDocumentNumber(debitAccount.getCustomer().getDocumentNumber())
                .switchIfEmpty(customerService.create(debitAccount.getCustomer()))
                .blockingGet();

        productService.findByCustomerId(customer.getCustomerId())
                .map(product -> {
                            debitService.findAll()
                                    .filter(debit -> debit.getDebitType().equals(debitAccount.getDebit().getDebitType()))
                                    .count());
                        }

                .map();


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
        /*
        Customer customer = customerService.findById(creditAccount.getCustomer().getDocumentNumber()).block();
        if(customer == null) {
            customer = customerService.create(creditAccount.getCustomer()).block();
        }
        Credit credit = creditService.create(creditAccount.getCredit()).block();

        Product product = productService.create(new Product(credit.getAccountId(),customer.getCustomerId(), RelationType.TITULAR)).block();
        */
        return null;
    }
}
