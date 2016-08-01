package org.axonframework.samples.trader.query.users;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by DELL-PC on 5/29/2016.
 */
@Entity
public class LineItemEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer jpaId;

    private String productId;
    private int productQuantity;

    public String getProductId() { return productId; }

    public void setProductId(String productId) { this.productId = productId; }

    public int getProductQuantity() { return productQuantity; }

    public void setProductQuantity(int productQuantity) { this.productQuantity = productQuantity; }
}
