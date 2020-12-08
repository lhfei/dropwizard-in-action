/*
 * Copyright 2010-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package cn.lhfei.dropwizard.helloworld.core;

import java.security.Principal;
import java.util.Set;

/**
 * @version 0.1
 *
 * @author Hefei Li
 *
 * @since Feb 19, 2017
 */
public class User implements Principal {
  private final String name;

  private final Set<String> roles;

  public User(String name) {
    this.name = name;
    this.roles = null;
  }

  public User(String name, Set<String> roles) {
    this.name = name;
    this.roles = roles;
  }

  public String getName() {
    return name;
  }

  public int getId() {
    return (int) (Math.random() * 100);
  }

  public Set<String> getRoles() {
    return roles;
  }
}
