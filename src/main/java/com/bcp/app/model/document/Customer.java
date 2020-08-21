package com.bcp.app.model.document;

import com.bcp.app.model.CustomerType;
import com.bcp.app.model.DocumentType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "customer")
public class Customer {

    @Id
    private String customerId;
    private DocumentType documentType;
    private String documentNumber;
    private String name;
    private String lastName;
    private String address;
    private String cellphone;
    private CustomerType customerType;
}
