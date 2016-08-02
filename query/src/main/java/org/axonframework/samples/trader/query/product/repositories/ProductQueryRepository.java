package org.axonframework.samples.trader.query.product.repositories;

import org.axonframework.samples.trader.query.product.ProductEntry;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by DELL-PC on 5/29/2016.
 */
public interface ProductQueryRepository extends PagingAndSortingRepository<ProductEntry, String> {
    List<ProductEntry> findByProductCategoryIdentifier(String productCategoryId);
}