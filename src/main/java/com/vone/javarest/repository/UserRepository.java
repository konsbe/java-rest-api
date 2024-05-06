package com.vone.javarest.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vone.javarest.entity.SciUserEntity;

@Repository
public interface UserRepository extends JpaRepository<SciUserEntity,Long>{
    SciUserEntity findByEmail(String email);
};
