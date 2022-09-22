package com.adminservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adminservice.dto.Admin;

public interface AdminRepository extends  JpaRepository<Admin, Integer> {

}
