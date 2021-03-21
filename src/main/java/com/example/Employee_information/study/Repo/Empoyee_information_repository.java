package com.example.Employee_information.study.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Employee_information.study.entity.Empolyee_information_entity;

public interface Empoyee_information_repository extends JpaRepository<Empolyee_information_entity, Integer> {

	Empolyee_information_entity findByFromAndTo(String from, String to);

}
