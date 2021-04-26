package com.launchcode.schoolmanagementdemo.data;

import com.launchcode.schoolmanagementdemo.models.Classes;
import org.springframework.data.repository.CrudRepository;

public interface ClassesRepository extends CrudRepository<Classes,Integer> {
}
