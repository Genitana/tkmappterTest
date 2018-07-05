package com.example.tkmappterTest.person.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tkmappterTest.person.dao.PersonDao;
import com.example.tkmappterTest.person.entity.Person;

import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

@Service
public class PersonService {

	@Autowired
	private PersonDao personDao ;
	
	public  Person findOne(String id){
		Person person =  new Person();
		Person person2 = personDao.selectByPrimaryKey(id);
		BeanUtils.copyProperties(person2, person);
		return person ;
	}
	
	public  Person findTheOne(Person p){
		Person person = personDao.selectOne(p);
		return person ;
	}
	
	/**
	 * 根据Example的条件查询
	 * @param p
	 * @return
	 */
	public  List<Person> findExampleOne(Person p){
		
		//创建condition (Condition extends Example) 
		Condition condition = new Condition(Person.class);
		//创建Criteria 
		Example.Criteria  criteria = condition.createCriteria();
		//添加条件
		criteria.andEqualTo("sex", 0);
		criteria.andLike("name", "%张%");		
		List<Person> person = personDao.selectByExample(condition);
		return person ;
	}
}
