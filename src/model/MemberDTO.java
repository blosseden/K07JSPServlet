package model;

import java.sql.Date;

import jdk.nashorn.internal.codegen.MethodEmitter;

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