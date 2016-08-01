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

/**
 * Event to indicate a new user has been created.
 *
 * @author Jettro Coenradie
 */
public class UserCreatedEvent {

    private UserId userId;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;

    public UserCreatedEvent(UserId userId, String firstName, String lastName, String username, String email, String phone, String password) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName=lastName;
        this.username = username;
        this.email=email;
        this.phone=phone;
        this.password = password;
    }

    public UserId getUserIdentifier() {
        return this.userId;
    }

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    public String getEmail() { return email; }

    public String getPhone() { return phone; }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "UserCreatedEvent{" +
                "userId=" + userId +
                ", first name='" + firstName + '\'' +
                ", last name='" + lastName + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
