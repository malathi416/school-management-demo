package com.launchcode.schoolmanagementdemo.data;

import com.launchcode.schoolmanagementdemo.models.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeachersRepository extends CrudRepository<Teacher,Integer> {
}
