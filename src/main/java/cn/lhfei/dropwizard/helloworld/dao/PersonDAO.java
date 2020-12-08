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

package cn.lhfei.dropwizard.helloworld.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import cn.lhfei.dropwizard.helloworld.core.Person;
import io.dropwizard.hibernate.AbstractDAO;

/**
 * @version 0.1
 *
 * @author Hefei Li
 *
 * @since Feb 19, 2017
 */

public class PersonDAO extends AbstractDAO<Person> {
	public PersonDAO(SessionFactory factory) {
		super(factory);
	}

	public Optional<Person> findById(Long id) {
		return Optional.ofNullable(get(id));
	}

	public Person create(Person person) {
		return persist(person);
	}

	public List<Person> findAll() {
		return list((Query<Person>) namedQuery("cn.lhfei.dropwizard.helloworld.core.Person.findAll"));
	}
}
