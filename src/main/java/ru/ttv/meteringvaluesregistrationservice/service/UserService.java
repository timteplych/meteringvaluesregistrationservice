package ru.ttv.meteringvaluesregistrationservice.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.ttv.meteringvaluesregistrationservice.model.User;
import ru.ttv.meteringvaluesregistrationservice.model.UserRegistrationDto;

/**
 * service class for {@link User}
 * @author Teplykh Timofey  09.03.2019
 */
public interface UserService extends UserDetailsService {

    void save(UserRegistrationDto registration);

    User findByUsername(String username);

}
