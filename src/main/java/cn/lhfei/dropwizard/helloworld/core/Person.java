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

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @version 0.1
 *
 * @author Hefei Li
 *
 * @since Feb 19, 2017
 */
@Entity
@Table(name = "people")
@NamedQueries({@NamedQuery(name = "cn.lhfei.dropwizard.helloworld.core.Person.findAll",
    query = "SELECT p FROM Person p")})
public class Person {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "fullName", nullable = false)
  private String fullName;

  @Column(name = "jobTitle", nullable = false)
  private String jobTitle;

  public Person() {}

  public Person(String fullName, String jobTitle) {
    this.fullName = fullName;
    this.jobTitle = jobTitle;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getJobTitle() {
    return jobTitle;
  }

  public void setJobTitle(String jobTitle) {
    this.jobTitle = jobTitle;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Person)) {
      return false;
    }

    final Person that = (Person) o;

    return Objects.equals(this.id, that.id) && Objects.equals(this.fullName, that.fullName)
        && Objects.equals(this.jobTitle, that.jobTitle);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, fullName, jobTitle);
  }
}
