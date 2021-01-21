package io.vimero.sovio.service;


import io.vimero.security.api.UserInformationService;
import io.vimero.security.api.UserSessionService;
import io.vimero.security.model.UserDetailsImpl;
import io.vimero.security.model.UserInformation;
import io.vimero.security.model.UserSession;
import io.vimero.sovio.entity.Person;
import io.vimero.sovio.entity.User;
import io.vimero.sovio.repository.PersonRepository;
import io.vimero.sovio.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Optional;

import static java.math.BigInteger.ONE;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

/**
 * @author Rony Villanueva <rony@vimero.io>
 * Created on 24/05/2020
 */

@Slf4j
@Service
@AllArgsConstructor
public class UserService implements UserDetailsService, UserInformationService, UserSessionService {

    private final UserRepository userRepository;
    private final PersonRepository personRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) {
        Optional<User> entity = userRepository.findByUsername(username);
        if (entity.isPresent()) {
            User user = entity.get();
            return new UserDetailsImpl(user.getUsername(), user.getPassword(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("Usuario no encontrado.");
        }
    }

    @Override
    public UserInformation retrieveUser(String username) {
        Optional<Person> entity = personRepository.findByDocumentNumberAndType(username, ONE.intValue());
        if (entity.isPresent()) {
            return new UserInformation(entity.get().getName(), entity.get().getFatherLastName());
        }
        throw new ResponseStatusException(NOT_FOUND, "El usuario no se encuentra registrado.");
    }

    @Override
    public UserSession getSession() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            String currentPrincipalName = authentication.getName();
            log.info(currentPrincipalName);
            Optional<User> entity = userRepository.findByUsername(currentPrincipalName);
            if (entity.isPresent()) {
                return entity.get();
            }
            throw new ResponseStatusException(NOT_FOUND, "El usuario no se encuentra registrado.");
        }
        throw new ResponseStatusException(UNAUTHORIZED, "El token esta vacio.");
    }
}
