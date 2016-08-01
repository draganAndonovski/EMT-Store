package org.axonframework.samples.trader.webui.services;

import org.axonframework.samples.trader.query.category.CategoryEntry;
import org.axonframework.samples.trader.query.product.ProductEntry;
import org.axonframework.samples.trader.query.users.LineItemEntry;
import org.axonframework.samples.trader.query.users.UserEntry;
import org.axonframework.samples.trader.webui.cart.CartDTO;

import java.util.List;

/**
 * Created by DELL-PC on 6/18/2016.
 */
public interface StoreService {

    List<CategoryEntry> getMainCategories();

    List<CategoryEntry> getSubCategories();

    UserEntry findUser(String userId);

    List<LineItemEntry> getUserCart(String userId);

    ProductEntry findProduct(String productId);

    List<ProductEntry> findProductsByCategory(String categoryId);

    List<CartDTO> createCartDTO(String userId);

    int getTotalPriceOfLineItems(String userId);
}
