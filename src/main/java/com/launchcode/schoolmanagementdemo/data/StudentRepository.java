package com.launchcode.schoolmanagementdemo.data;

import com.launchcode.schoolmanagementdemo.models.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student,Integer> {
}
