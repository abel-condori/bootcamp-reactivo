package com.bcp.app.model.dto;

import com.bcp.app.model.document.Customer;
import com.bcp.app.model.document.Debit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DebitAccount {
    private Customer customer;
    private Debit debit;
}
