package com.tandil.blur.persistence.repository;


import org.springframework.data.repository.CrudRepository;

import com.tandil.blur.persistence.model.Student;

public interface StudentRepository extends CrudRepository<Student,Integer> {
    Student findById(int id);
}
