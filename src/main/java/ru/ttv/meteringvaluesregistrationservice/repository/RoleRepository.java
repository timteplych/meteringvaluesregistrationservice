package ru.ttv.meteringvaluesregistrationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ttv.meteringvaluesregistrationservice.model.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
