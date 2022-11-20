package com.applaudostudios.week5assignment.repository;

import com.applaudostudios.week5assignment.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    Optional<UserEntity> findByUserEmail(String userEmail);

    <T> List<T> findBy(Class<T> class1);

        <T> T findByUserEmail(String email, Class<T> class1);
}
