package com.adminservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adminservice.entity.User;
@Repository
public interface IUserRepository extends JpaRepository<User, Integer>  {

}
