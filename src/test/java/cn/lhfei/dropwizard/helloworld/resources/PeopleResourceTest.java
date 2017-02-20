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

package cn.lhfei.dropwizard.helloworld.resources;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.junit.MockitoJUnitRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.collect.ImmutableList;

import cn.lhfei.dropwizard.helloworld.core.Person;
import cn.lhfei.dropwizard.helloworld.dao.PersonDAO;
import io.dropwizard.testing.junit.ResourceTestRule;

/**
 * @version 0.1
 *
 * @author Hefei Li
 *
 * @since Feb 20, 2017
 */
@RunWith(MockitoJUnitRunner.class)
public class PeopleResourceTest {
    private static final PersonDAO PERSON_DAO = mock(PersonDAO.class);
    @ClassRule
    public static final ResourceTestRule RESOURCES = ResourceTestRule.builder()
            .addResource(new PeopleResource(PERSON_DAO))
            .build();
    @Captor
    private ArgumentCaptor<Person> personCaptor;
    private Person person;

    @Before
    public void setUp() {
        person = new Person();
        person.setFullName("Full Name");
        person.setJobTitle("Job Title");
    }

    @After
    public void tearDown() {
        reset(PERSON_DAO);
    }

    @Test
    public void createPerson() throws JsonProcessingException {
        when(PERSON_DAO.create(any(Person.class))).thenReturn(person);
        final Response response = RESOURCES.client().target("/people")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(person, MediaType.APPLICATION_JSON_TYPE));

        assertThat(response.getStatusInfo()).isEqualTo(Response.Status.OK);
        verify(PERSON_DAO).create(personCaptor.capture());
        assertThat(personCaptor.getValue()).isEqualTo(person);
    }

    @Test
    public void listPeople() throws Exception {
        final ImmutableList<Person> people = ImmutableList.of(person);
        when(PERSON_DAO.findAll()).thenReturn(people);

        final List<Person> response = RESOURCES.client().target("/people")
            .request().get(new GenericType<List<Person>>() {
            });

        verify(PERSON_DAO).findAll();
        assertThat(response).containsAll(people);
    }
}