package org.axonframework.samples.trader.webui.cart;

import org.axonframework.samples.trader.query.product.ProductEntry;
import org.axonframework.samples.trader.query.users.LineItemEntry;

/**
 * Created by DELL-PC on 6/2/2016.
 */
public class CartDTO {
    public LineItemEntry lineItemEntry;

    public ProductEntry productEntry;
}