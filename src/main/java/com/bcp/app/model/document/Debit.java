package com.bcp.app.model.document;

import com.bcp.app.model.AccountType;
import com.bcp.app.model.CustomerType;
import com.bcp.app.model.DebitType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Getter
@Setter
@Document(collection = "debit")
public class Debit extends Account {

    @Id
    private String accountId;
    private DebitType debitType;
    private double amount;
    private double interestRate;
    private LocalDate startDate;
    private LocalDate endtDate;

    public Debit() {
        setAccountType(AccountType.DEBIT);
        setCreationDate(LocalDate.now());
    }
}
