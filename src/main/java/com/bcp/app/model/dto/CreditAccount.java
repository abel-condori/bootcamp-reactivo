package com.bcp.app.model.dto;

import com.bcp.app.model.document.Credit;
import com.bcp.app.model.document.Customer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditAccount {
    private Customer customer;
    private Credit credit;
}
