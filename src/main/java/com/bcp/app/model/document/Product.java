package com.bcp.app.model.document;

import com.bcp.app.model.RelationType;
import com.bcp.app.model.TransactionType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "product")
public class Product {

    @Id
    private String productId;
    private String accountId;
    private String customerId;
    private RelationType relationType;

    public Product() {
    }

    public Product(String accountId, String customerId, RelationType relationType) {
        this.accountId = accountId;
        this.customerId = customerId;
        this.relationType = relationType;
    }
}
