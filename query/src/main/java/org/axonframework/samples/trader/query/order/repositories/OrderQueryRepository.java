package org.axonframework.samples.trader.query.order.repositories;

import org.axonframework.samples.trader.query.order.OrderEntry;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by DELL-PC on 7/3/2016.
 */
public interface OrderQueryRepository extends PagingAndSortingRepository<OrderEntry, String> {
}