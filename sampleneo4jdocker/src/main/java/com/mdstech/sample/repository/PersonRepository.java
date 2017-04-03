package com.mdstech.sample.repository;

import com.mdstech.sample.domain.Person;
import org.springframework.data.neo4j.repository.GraphRepository;


public interface PersonRepository extends GraphRepository<Person> {

    Person findByName(String name);
}
