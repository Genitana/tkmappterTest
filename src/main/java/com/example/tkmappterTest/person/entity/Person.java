
package com.example.tkmappterTest.person.entity;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="person")
public class Person implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5756999787029566802L;

	@Id
	private String uuid ;
	private String name ;
	private Integer sex ;
	private String country ;
	private Integer age ;
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	

}

