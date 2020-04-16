package com.chat.repositories;


import com.chat.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Integer> {

    @Query(value = "SELECT u from Role u where u.role LIKE %:role%")
    Role findByRole(String role);
}
