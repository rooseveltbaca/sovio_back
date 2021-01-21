package io.vimero.sovio.api.rest;

import io.vimero.ms.crud.APIRest;
import io.vimero.sovio.api.data.PersonData;
import io.vimero.sovio.entity.Person;
import io.vimero.sovio.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/persons")
public class PersonController extends APIRest<Person, Long, PersonData, PersonService> {


    public PersonController(PersonService service) {
        super(service);
    }

}
