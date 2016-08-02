package org.axonframework.samples.trader.query.product;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.TextScore;

import javax.persistence.Lob;

/**
 * Created by DELL-PC on 5/29/2016.
 */
@Document
public class ProductEntry {

    @Id
    private String identifier;

    @TextIndexed(weight = 5.0f)
    private String productName;

    private String productCategoryIdentifier;
    private float productPrice;
    private int availableQuantity;
    private boolean productAvailability;

    @TextIndexed(weight = 1.0f)
    private String productDescription;

    @TextScore
    private Float score;

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

    public Float getScore() { return score; }

    public void setScore(Float score) { this.score = score; }

    public byte[] getProductPicture() { return productPicture; }

    public void setProductPicture(byte[] productPicture) { this.productPicture = productPicture; }
}