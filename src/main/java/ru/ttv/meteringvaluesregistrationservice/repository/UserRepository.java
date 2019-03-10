package ru.ttv.meteringvaluesregistrationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ttv.meteringvaluesregistrationservice.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
