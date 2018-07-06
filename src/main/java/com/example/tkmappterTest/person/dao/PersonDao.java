package com.example.tkmappterTest.person.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.tkmappterTest.person.entity.Person;



@Mapper
public interface PersonDao extends TKMapper<Person> {

	
}
