package com.aulamatriz.ms.management.repository;

import com.aulamatriz.ms.management.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserEntity,Long> {
}
