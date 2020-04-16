package com.chat.repositories;


import com.chat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AdminRepository extends JpaRepository<User, Integer> {

    User findUserById(int id);

    @Query(value = "SELECT * from User u where u.name LIKE %:param% OR u.last_name LIKE %:param% OR u.email LIKE %:param%", nativeQuery = true)
    List<User> findAllSearch(@Param("param") String param);

    @Modifying
    @Query(value = "delete from user_role where user_id = :id", nativeQuery = true)
    void deleteUserFromUserRole(@Param("id") int id);

    @Modifying
    @Query(value = "delete from user where user_id= :id", nativeQuery = true)
    void deleteUserFromUser(@Param("id") int id);



}
