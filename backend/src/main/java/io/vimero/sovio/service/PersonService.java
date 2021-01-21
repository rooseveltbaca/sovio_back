package io.vimero.sovio.service;

import io.vimero.api.EmailAPI;
import io.vimero.ms.crud.CRUDService;
import io.vimero.sovio.api.data.PersonData;
import io.vimero.sovio.config.SovioMapper;
import io.vimero.sovio.dto.PersonReniec;
import io.vimero.sovio.entity.Person;
import io.vimero.sovio.entity.User;
import io.vimero.sovio.repository.PersonRepository;
import io.vimero.sovio.repository.UserRepository;
import io.vimero.web.DataResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigInteger;
import java.util.Optional;

@Slf4j
@Service
public class PersonService extends CRUDService<Person, Long, PersonData, PersonRepository> {

    private final UserRepository userRepository;
    private final EmailAPI emailComponent;
    private final PasswordEncoder passwordEncoder;
    private final RestTemplate restTemplate;

    public PersonService(PersonRepository repository, UserRepository userRepository,
                         EmailAPI emailComponent, PasswordEncoder passwordEncoder,
                         RestTemplate restTemplate) {
        super(repository);
        this.userRepository = userRepository;
        this.emailComponent = emailComponent;
        this.passwordEncoder = passwordEncoder;
        this.restTemplate = restTemplate;
    }

    @Override
    public Person getEntity(PersonData data) {
        return SovioMapper.INSTANCE.toPerson(data);
    }

    @Override
    public void validate(PersonData data) {
        Optional<Person> entity = getRepository().findByDocumentNumberAndType(
                data.getDocumentNumber(), BigInteger.ONE.intValue());
        if (entity.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Numero de documento " + data.getDocumentNumber() + " se encuentra registrado");
        }
    }

    @Override
    public void postPersist(Person person) {
        User user = new User();
        user.setUsername(person.getDocumentNumber());
        user.setPassword(passwordEncoder.encode("123456"));
        user.setPerson(person);
        user.setProfile(BigInteger.ONE.longValue());
        userRepository.save(user);
        emailComponent.sendPlainText(person.getEmail(), "Registro Exitoso",
                "El usuario se ha registrado correctamente. \n\n" +
                        "Usuario: " + person.getEmail() + "\n" +
                        "Password: 12456 \n\n\n Ministerio del Trabajo y Promocion del Empleo.");

    }

    public DataResponse getDataFromRENIEC(String document){
        ResponseEntity<PersonReniec> responseEntity = restTemplate.getForEntity( "https://api.reniec.cloud/dni/"+document, PersonReniec.class);
        if( responseEntity.getStatusCode().is2xxSuccessful() ){
            PersonReniec persona =  responseEntity.getBody();
            /*PersonaResponse response = new PersonaResponse();
            assert persona != null;
            response.setNombres(persona.getNombres());
            response.setApellidoMaterno(persona.getApellidoMaterno());
            response.setApellidoPaterno(persona.getApellidoPaterno());
            return new DataResponse(response, null);

             */
            return new DataResponse(persona);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Persona no encontrada");
        }

    }

}
