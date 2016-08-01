/*
 * Copyright (c) 2010-2012. Axon Framework
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.axonframework.samples.trader.users.command;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.axonframework.samples.trader.api.product.ProductId;
import org.axonframework.samples.trader.api.users.*;
import org.axonframework.samples.trader.users.util.DigestUtils;

/**
 * @author Jettro Coenradie
 */
public class User extends AbstractAnnotatedAggregateRoot {
    private static final long serialVersionUID = 3291411359839192350L;
    @AggregateIdentifier
    private UserId userId;
    private String passwordHash;


    protected User() {}

    public User(UserId userId, String firstName, String lastName, String username, String email, String phone, String password) {
        apply(new UserCreatedEvent(userId, firstName, lastName, username, email, phone, hashOf(password.toCharArray())));
    }

    public boolean authenticate(char[] password) {
        boolean success = this.passwordHash.equals(hashOf(password));
        if (success) {
            apply(new UserAuthenticatedEvent(userId));
        }
        return success;
    }

    /**
     *
     * edit: Dragan Andonovski
     */
    public void addLineItemToCart(UserId userId, ProductId productId, int productQuantity) {
        apply(new LineItemAddedToCartEvent(userId, productId, productQuantity));
    }

    public void removeLineItemFromCart(UserId userId, ProductId productId) {
        apply(new LineItemRemovedFromCartEvent(userId, productId));
    }

    public void changeLineItemQtyInCart(UserId userId, ProductId productId, int productQuantity) {
        apply(new LineItemQtyInCartUpdatedEvent(userId, productId, productQuantity));
    }

    @EventHandler
    public void onUserCreated(UserCreatedEvent event) {
        this.userId = event.getUserIdentifier();
        this.passwordHash = event.getPassword();
    }

    private String hashOf(char[] password) {
        return DigestUtils.sha1(String.valueOf(password));
    }

    @Override
    public UserId getIdentifier() {
        return userId;
    }
}
