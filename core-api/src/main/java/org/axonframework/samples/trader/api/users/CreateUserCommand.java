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

package org.axonframework.samples.trader.api.users;

import org.axonframework.common.Assert;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Command to create a new user.
 *
 * @author Jettro Coenradie
 */
public class CreateUserCommand {
    private UserId userId;
    @NotNull
    @Size(min = 3)
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    @NotNull
    @Size(min = 3)
    private String password;

    public CreateUserCommand(UserId userId, String firstName, String lastName, String username, String email, String phone, String password) {
        Assert.notNull(userId, "The provided userId cannot be null");
        Assert.notNull(firstName, "The provided name cannot be null");
        Assert.notNull(lastName, "The provided name cannot be null");
        Assert.notNull(email, "The provided name cannot be null");
        Assert.notNull(phone, "The provided name cannot be null");
        Assert.notNull(username, "The provided username cannot be null");
        Assert.notNull(password, "The provided password cannot be null");

        this.userId = userId;
        this.firstName = firstName;
        this.lastName=lastName;
        this.username = username;
        this.email=email;
        this.phone=phone;
        this.password = password;
    }

    public UserId getUserId() {
        return userId;
    }

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    public String getUsername() { return username; }

    public String getEmail() { return email; }

    public String getPhone() { return phone; }

    public String getPassword() {
        return password;
    }
}
