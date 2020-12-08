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

package cn.lhfei.dropwizard.helloworld.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import cn.lhfei.dropwizard.helloworld.filter.DateRequired;

/**
 * @version 0.1
 *
 * @author Hefei Li
 *
 * @since Feb 18, 2017
 */
@Path("/filtered")
public class FilteredResource {

  @GET
  @DateRequired
  @Path("hello")
  public String sayHello() {
    return "hello";
  }
}
