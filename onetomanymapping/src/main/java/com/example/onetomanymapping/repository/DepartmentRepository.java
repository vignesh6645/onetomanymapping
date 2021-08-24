package com.example.onetomanymapping.repository;

import com.example.onetomanymapping.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {

    List<Department> findByWorker(Integer id);

}
