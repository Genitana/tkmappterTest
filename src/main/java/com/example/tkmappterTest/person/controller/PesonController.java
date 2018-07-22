package com.example.tkmappterTest.person.controller;

import com.example.tkmappterTest.person.dao.PersonDao;
import com.example.tkmappterTest.person.entity.Person;
import com.example.tkmappterTest.person.service.PersonService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;
import java.util.UUID;

@RestController
public class PesonController {

	@Autowired
	private PersonService personService ;
	@Autowired
	private PersonDao personDao ;

	@GetMapping("/person")
	public ResponseEntity<?> getPerson(  int page,int size){
		List<Person> pesonlist = personService.findPersons(page , size);
		PageInfo<List<Person>> pageinfo = new PageInfo(pesonlist);
		return new ResponseEntity<>(pageinfo, HttpStatus.OK);
	}

	@PostMapping("/save")
	public Person savePerson(@RequestBody Person person){
		person.setUuid(UUID.randomUUID().toString());
		personDao.insert(person);
//		return new ResponseEntity<>("success",HttpStatus.OK);
		return person;
	}

	@GetMapping("/person2")
	public List<Person> getPerson(){
		Condition condition = new Condition(Person.class);
		condition.setOrderByClause("age desc");
		condition.createCriteria().andEqualTo("sex",0);
		return personDao.selectByExample(condition);
	}
 }
