package model;

import java.sql.Date;
/*
 DTO객체(Data Transfer Object)
  : 데이터를 저장하기 위한 객체로 멤버변수, 생성자, getter/setter
	메소드를 가지고 있는 클라스로 일반적인 자바빈(Been)규약을 따른다
  */
public class MemberDTO {

	private String id;
	private String pass;
	private String name;
	private java.sql.Date regidate;
	
	
	//멤버변수 : 정보은닉을 위해 private으로 선언함
	public MemberDTO(String id, String pass, String name, Date regidate) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.regidate = regidate;
	}
	
	public MemberDTO() {}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public java.sql.Date getRegidate() {
		return regidate;
	}
	public void setRegidate(java.sql.Date regidate) {
		this.regidate = regidate;
	}
	
	

}