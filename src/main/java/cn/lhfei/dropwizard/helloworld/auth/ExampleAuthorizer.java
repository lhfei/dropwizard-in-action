/*
 * Copyright 2010-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.lhfei.dropwizard.helloworld.auth;

import cn.lhfei.dropwizard.helloworld.core.User;
import io.dropwizard.auth.Authorizer;

/**
 * @version 0.1
 *
 * @author Hefei Li
 *
 * @since Feb 19, 2017
 */

public class ExampleAuthorizer implements Authorizer<User> {

	@Override
    public boolean authorize(User user, String role) {
        return user.getRoles() != null && user.getRoles().contains(role);
    }
}
