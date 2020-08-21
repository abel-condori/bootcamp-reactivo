package com.bcp.app.model.document;

import com.bcp.app.model.CustomerType;
import com.bcp.app.model.TransactionType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "transaction")
public class Transaction {

    @Id
    private String transactionId;
    private String accountId;
    private String customerId;
    private TransactionType transactionType;
    private double amount;
    private double concept;
}
