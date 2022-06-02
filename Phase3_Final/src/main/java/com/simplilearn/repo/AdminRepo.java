package com.simplilearn.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.model.Admin;

@Repository
public interface AdminRepo extends CrudRepository<Admin, String> {

}
