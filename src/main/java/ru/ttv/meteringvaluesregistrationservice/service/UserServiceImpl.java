package ru.ttv.meteringvaluesregistrationservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ttv.meteringvaluesregistrationservice.model.Role;
import ru.ttv.meteringvaluesregistrationservice.model.User;
import ru.ttv.meteringvaluesregistrationservice.model.UserRegistrationDTO;
import ru.ttv.meteringvaluesregistrationservice.repository.RoleRepository;
import ru.ttv.meteringvaluesregistrationservice.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Implementation of {@link UserService} interface
 * @author Teplykh Timofey  09.03.2019
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(UserRegistrationDTO registration) {
        User user = new User();
        user.setUsername(registration.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(registration.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.getOne(1L));
        user.setRoles(roles);
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for(Role role: user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(), grantedAuthorities);
    }
}
