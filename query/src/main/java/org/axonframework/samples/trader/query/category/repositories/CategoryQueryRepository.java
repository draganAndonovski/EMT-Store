package org.axonframework.samples.trader.query.category.repositories;

import org.axonframework.samples.trader.query.category.CategoryEntry;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by DELL-PC on 6/13/2016.
 */
public interface CategoryQueryRepository extends PagingAndSortingRepository<CategoryEntry, String> {

    List<CategoryEntry> findByMainCategoryTrue();

    List<CategoryEntry> findByMainCategoryFalse();
}