package com.example.Employee_information.study.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.Employee_information.study.Exception.UserNotFoundException;
import com.example.Employee_information.study.Repo.Empoyee_information_repository;
import com.example.Employee_information.study.entity.Empolyee_information_entity;

@RestController
public class Empolyee_controller {

	@Autowired
	private Empoyee_information_repository employee_repo;

	@GetMapping("/")
	public String welcomepage() {

		return "This is welcome page, please use the correct URI to get employee details";
	}
// To fetch all user details
	@GetMapping("/getalluser")
	public List<Empolyee_information_entity> getAllUser() {
		return employee_repo.findAll();

	}

	@GetMapping("/id/{id}")
	public Optional<Empolyee_information_entity> gettinguserbyId(@PathVariable Integer id) {
		Optional<Empolyee_information_entity> user = employee_repo.findById(id);
		if (user == null) {
			throw new UserNotFoundException("id" + id);
		}
		return user;
	}

	@DeleteMapping("/id/{id}")
	public String deleteId(@PathVariable Integer id) {
		employee_repo.deleteById(id);
		return "User deleted";

	}

	@GetMapping("/from/{from}/to/{to}")
	public Empolyee_information_entity gettinguserbyId(@PathVariable String from, @PathVariable String to) {

		Empolyee_information_entity user = employee_repo.findByFromAndTo(from, to);
		return user;

	}

	@PostMapping("/user/add")
	public Empolyee_information_entity addUser(@RequestBody Empolyee_information_entity user) {
		return employee_repo.save(user);
	}

	@PutMapping("/user/{id}/update")
	public ResponseEntity<Empolyee_information_entity> updateUser(@PathVariable int id,
			@RequestBody Empolyee_information_entity user) throws UserNotFoundException {
		Empolyee_information_entity userentity = employee_repo.findById(id).orElse(employee_repo.save(user));

		userentity.setName(user.getName());
		userentity.setFrom(user.getFrom());
		userentity.setTo(user.getTo());
		userentity.setStatus(user.getStatus());
		final Empolyee_information_entity updatedEmp = employee_repo.save(userentity);

		return ResponseEntity.ok(updatedEmp);
	}

	@PatchMapping("/user/{id}/update")
	public ResponseEntity<Empolyee_information_entity> PatchUser(@PathVariable int id,
			@RequestBody Empolyee_information_entity user) throws UserNotFoundException {
		Empolyee_information_entity userentity = employee_repo.findById(id).orElse(employee_repo.save(user));

		userentity.setName(user.getName());
		userentity.setFrom(user.getFrom());
		userentity.setTo(user.getTo());
		userentity.setStatus(user.getStatus());
		final Empolyee_information_entity updatedEmp = employee_repo.save(userentity);

		return ResponseEntity.ok(updatedEmp);
	}
}
