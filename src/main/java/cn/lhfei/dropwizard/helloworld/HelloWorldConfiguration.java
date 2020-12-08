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

package cn.lhfei.dropwizard.helloworld;

import java.util.Collections;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableMap;

import cn.lhfei.dropwizard.helloworld.core.Template;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

/**
 * @version 0.1
 *
 * @author Hefei Li
 *
 * @since Feb 18, 2017
 */
public class HelloWorldConfiguration extends Configuration {
  @Valid
  @NotNull
  @JsonProperty
  private String name;

  @Valid
  @NotNull
  @JsonProperty
  private Integer port;

  @Valid
  @NotNull
  @JsonProperty
  private String vipAddress;

  @Valid
  @NotNull
  @JsonProperty
  private String defaultServiceUrl;

  @NotEmpty
  private String template;

  @NotEmpty
  private String defaultName = "Hefei Li";

  @Valid
  @NotNull
  private DataSourceFactory database = new DataSourceFactory();

  @NotNull
  private Map<String, Map<String, String>> viewRendererConfiguration = Collections.emptyMap();


  /*
   * @Override public EurekaClientConfiguration getEureka() { EurekaClientConfiguration
   * configuration = new EurekaClientConfiguration(); configuration.setName(name);
   * configuration.setPort(port); configuration.setVipAddress(vipAddress);
   * configuration.setDefaultServiceUrl(defaultServiceUrl);
   * 
   * return configuration; }
   */

  @JsonProperty
  public String getTemplate() {
    return template;
  }

  @JsonProperty
  public void setTemplate(String template) {
    this.template = template;
  }

  @JsonProperty
  public String getDefaultName() {
    return defaultName;
  }

  @JsonProperty
  public void setDefaultName(String defaultName) {
    this.defaultName = defaultName;
  }

  public Template buildTemplate() {
    return new Template(template, defaultName);
  }

  @JsonProperty("database")
  public DataSourceFactory getDataSourceFactory() {
    return database;
  }

  @JsonProperty("database")
  public void setDataSourceFactory(DataSourceFactory dataSourceFactory) {
    this.database = dataSourceFactory;
  }

  @JsonProperty("viewRendererConfiguration")
  public Map<String, Map<String, String>> getViewRendererConfiguration() {
    return viewRendererConfiguration;
  }

  @JsonProperty("viewRendererConfiguration")
  public void setViewRendererConfiguration(
      Map<String, Map<String, String>> viewRendererConfiguration) {
    final ImmutableMap.Builder<String, Map<String, String>> builder = ImmutableMap.builder();
    for (Map.Entry<String, Map<String, String>> entry : viewRendererConfiguration.entrySet()) {
      builder.put(entry.getKey(), ImmutableMap.copyOf(entry.getValue()));
    }
    this.viewRendererConfiguration = builder.build();
  }
}
