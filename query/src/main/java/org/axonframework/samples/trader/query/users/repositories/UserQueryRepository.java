package org.axonframework.samples.trader.query.users.repositories;

import org.axonframework.samples.trader.query.users.UserEntry;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserQueryRepository extends PagingAndSortingRepository<UserEntry, String> {

    UserEntry findByUsername(String username);

    UserEntry findByIdentifier(String identifier);
}