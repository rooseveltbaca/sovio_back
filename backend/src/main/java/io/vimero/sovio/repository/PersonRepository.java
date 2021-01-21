package io.vimero.sovio.repository;

import io.vimero.sovio.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByDocumentNumberAndType(String number, Integer type);

}
