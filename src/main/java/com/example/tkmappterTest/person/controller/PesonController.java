package com.example.tkmappterTest.person.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tkmappterTest.person.entity.Person;
import com.example.tkmappterTest.person.service.PersonService;
import com.github.pagehelper.PageInfo;

@RestController
public class PesonController {

	@Autowired
	private PersonService personService ;
	
	@GetMapping("/person")
	public ResponseEntity<?> getPerson(  int page,int size){
		List<Person> pesonlist = personService.findPersons(page , size);
		PageInfo<List<Person>> pageinfo = new PageInfo(pesonlist);
		return new ResponseEntity<>(pageinfo, HttpStatus.OK);
	}
}
