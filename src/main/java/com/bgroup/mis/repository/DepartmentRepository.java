package com.bgroup.mis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bgroup.mis.model.Department;
@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer>{

}
