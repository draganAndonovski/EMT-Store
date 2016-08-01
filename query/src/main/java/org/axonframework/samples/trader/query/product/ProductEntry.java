package org.axonframework.samples.trader.query.product;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.hibernate.metamodel.source.annotations.attribute.type.LobTypeResolver;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import javax.persistence.Entity;
import javax.persistence.Lob;
import java.sql.Blob;

/**
 * Created by DELL-PC on 5/29/2016.
 */
@Entity
public class ProductEntry {

    @Id
    @javax.persistence.Id
    private String identifier;
    private String productName;
    private String productCategoryIdentifier;
    private float productPrice;
    private int availableQuantity;
    private boolean productAvailability;
    private String productDescription;

    @Lob
    private byte[] productPicture;

    public String getIdentifier() { return identifier; }

    public void setIdentifier(String identifier) { this.identifier = identifier; }

    public String getProductName() { return productName; }

    public void setProductName(String productName) { this.productName = productName; }

    public String getProductCategoryIdentifier() { return productCategoryIdentifier; }

    public void setProductCategoryIdentifier(String productCategoryIdentifier) { this.productCategoryIdentifier = productCategoryIdentifier; }

    public float getProductPrice() { return productPrice; }

    public void setProductPrice(float productPrice) { this.productPrice = productPrice; }

    public int getAvailableQuantity() { return availableQuantity; }

    public void setAvailableQuantity(int availableQuantity) { this.availableQuantity = availableQuantity; }

    public boolean isProductAvailability() { return productAvailability; }

    public void setProductAvailability(boolean productAvailability) { this.productAvailability = productAvailability; }

    public String getProductDescription() { return productDescription; }

    public void setProductDescription(String productDescription) { this.productDescription = productDescription; }

    public byte[] getProductPicture() { return productPicture; }

    public void setProductPicture(byte[] productPicture) { this.productPicture = productPicture; }
}
