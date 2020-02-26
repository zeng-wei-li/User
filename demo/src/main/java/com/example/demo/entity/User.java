package com.example.demo.entity;
import java.math.*;
import java.util.Date;
import java.sql.Timestamp;
import org.beetl.sql.core.annotatoin.Table;


/* 
* 
* gen by beetlsql 2020-02-26
*/
@Table(name="text.User")
public class User extends org.beetl.sql.core.TailBean  {
	
	private Integer id ;
	private String name ;
	
	public User() {
	}
	
	public Integer getId(){
		return  id;
	}
	public void setId(Integer id ){
		this.id = id;
	}
	
	public String getName(){
		return  name;
	}
	public void setName(String name ){
		this.name = name;
	}
	

}
