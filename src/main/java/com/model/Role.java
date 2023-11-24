//package com.model;
//
//import java.util.List;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.ManyToMany;
//import jakarta.persistence.Table;
////import jakarta.validation.constraints.NotEmpty;
//
//@Entity
//@Table(name="roles")
//public class Role {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private int id;
//	
////	@NotEmpty
//	@Column(nullable = false, unique = true)
//	private String name;
//	
//	@ManyToMany(mappedBy = "roles")
//	private List<User> users;
//
//	public Role() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public Role(int id,String name, List<User> users) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.users = users;
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public List<User> getUsers() {
//		return users;
//	}
//
//	public void setUsers(List<User> users) {
//		this.users = users;
//	}
//	
////	public Role(@NotEmpty String name, List<User> users) {
////		super();
////		this.name = name;
////		this.users = users;
////	}
//
//	@Override
//	public String toString() {
//		return "Role [id=" + id + ", name=" + name + ", users=" + users + "]";
//	}
//	
//}
