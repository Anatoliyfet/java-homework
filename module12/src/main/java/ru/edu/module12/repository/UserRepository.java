package ru.edu.module12.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.edu.module12.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByNameOrderByNameAsc(String name);
    User findUserByName(String name);
}

//public interface UserRepository extends  JpaRepository<User, String> {
//    User findUserByName
//}