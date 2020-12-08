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

package cn.lhfei.dropwizard.helloworld.filter;

import java.io.IOException;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 * @version 0.1
 *
 * @author Hefei Li
 *
 * @since Feb 19, 2017
 */
@Provider
public class DateNotSpecifiedFilter implements ContainerRequestFilter {
  @Override
  public void filter(ContainerRequestContext requestContext) throws IOException {
    final String dateHeader = requestContext.getHeaderString(HttpHeaders.DATE);
    if (dateHeader == null) {
      throw new WebApplicationException(
          new IllegalArgumentException("Date Header was not specified"),
          Response.Status.BAD_REQUEST);
    }
  }
}
