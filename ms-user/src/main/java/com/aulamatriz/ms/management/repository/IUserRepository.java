package com.aulamatriz.ms.management.repository;

import com.aulamatriz.ms.management.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<UserEntity,Long> {

    Optional<UserEntity> findByName(String name);

    Optional<UserEntity> findByDocumentAndTypeDocument(String name,String typeDocument);

    //JPQL
    @Query(value = "SELECT u FROM UserEntity u WHERE u.document = :documento")
    Optional<UserEntity> buscarPorDocumento(@Param("documento") String documento);
}
