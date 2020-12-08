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

import io.dropwizard.views.View;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.nio.charset.StandardCharsets;

/**
 * @version 0.1
 *
 * @author Hefei Li
 *
 * @since Feb 18, 2017
 */
@Path("/views")
public class ViewResource {
  @GET
  @Produces("text/html;charset=UTF-8")
  @Path("/utf8.ftl")
  public View freemarkerUTF8() {
    return new View("/views/ftl/utf8.ftl", StandardCharsets.UTF_8) {};
  }

  @GET
  @Produces("text/html;charset=ISO-8859-1")
  @Path("/iso88591.ftl")
  public View freemarkerISO88591() {
    return new View("/views/ftl/iso88591.ftl", StandardCharsets.ISO_8859_1) {};
  }

  @GET
  @Produces("text/html;charset=UTF-8")
  @Path("/utf8.mustache")
  public View mustacheUTF8() {
    return new View("/views/mustache/utf8.mustache", StandardCharsets.UTF_8) {};
  }

  @GET
  @Produces("text/html;charset=ISO-8859-1")
  @Path("/iso88591.mustache")
  public View mustacheISO88591() {
    return new View("/views/mustache/iso88591.mustache", StandardCharsets.ISO_8859_1) {};
  }
}
