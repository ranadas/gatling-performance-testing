package com.rdas.perftest.repositpry;

import com.rdas.perftest.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonsRepository extends CrudRepository<Person, Long> {
}
