package com.bcp.app.model.document;

import com.bcp.app.model.AccountType;
import com.bcp.app.model.DebitType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Account {
    private AccountType accountType;
    private LocalDate creationDate;
}
