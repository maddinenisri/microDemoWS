package com.mdstech.sample.service;

import com.mdstech.sample.domain.Person;
import com.mdstech.sample.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Srini on 4/1/17.
 */
@Service
public class PersonService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonService.class);

    @Autowired
    private PersonRepository personRepository;

    public void loadSampleData() {
        personRepository.deleteAll();

        Person pea = new Person("Manager");
        Person bee = new Person("Developer");
        Person nee = new Person("Tester");
        Person pang = new Person("Director");
        Person ni = new Person("Unkonwn");


        List<Person> friends = Arrays.asList(pea, bee, nee, pang);

        LOGGER.info("Before linking friend with Neo4j...");

        friends.stream()
                .forEach(person -> LOGGER.info("\t" + person.toString()));

        personRepository.save(pea);
        personRepository.save(bee);
        personRepository.save(nee);
        personRepository.save(pang);
        personRepository.save(ni);

        pea = personRepository.findByName(pea.getName());
        pea.friendOf(bee);
        pea.friendOf(nee);
        personRepository.save(pea);

        bee = personRepository.findByName(bee.getName());
        bee.friendOf(nee);

        personRepository.save(bee);

        pang = personRepository.findByName(pang.getName());
        pang.friendOf(nee);
        personRepository.save(pang);

        ni = personRepository.findByName(ni.getName());
        ni.friendOf(pea);
        personRepository.save(ni);

        LOGGER.info("Lookup each person ...");
        friends.stream().forEach(person -> LOGGER.info(
                "\t" + personRepository.findByName(person.getName()).toString()));


        LOGGER.info("Looking up for Pea's friends");
        pea.getFriends()
                .forEach(friend -> {
                    LOGGER.info("\t" + friend.getName());
                });

    }

    public List<Person> getAll() {
        List<Person> data = new ArrayList<>();
        personRepository.findAll().forEach(t -> data.add(t));
        return data;
    }

    public Person findOne(Long id) {
        return personRepository.findOne(id);
    }
}
