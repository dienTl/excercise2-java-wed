package com.javaweb.repository.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="User")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id ;
	
	
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="user_role",
			joinColumns = @JoinColumn(name="user_id", nullable = false),
			inverseJoinColumns = @JoinColumn(name="role_id", nullable = false))
	private List<RoleEntity> roles = new ArrayList<RoleEntity>();
	
	
	public List<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}

	@Column(name ="username", nullable = false)
	private String username ;
	
	@Column(name ="password" , nullable = false)
	private String password;
	
	@Column(name ="fullname" , nullable = false)
	private String fullname;
	
	@Column( name = "phone" , nullable = false)
	private String phone;
	
	@Column( name ="email", nullable = false)
	private String email ;
	
	@Column(name ="status")
	private Integer status ;
	
	@Column( name ="createddate")
	private LocalDate createddate ;
	
	@Column(name ="modifieddate")
	private LocalDate modifieddate ;
	
	@Column(name="createdby")
	private LocalDate createdby;
	
	@Column(name="modifiedby")
	private LocalDate modifiedby;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public LocalDate getCreateddate() {
		return createddate;
	}

	public void setCreateddate(LocalDate createddate) {
		this.createddate = createddate;
	}

	public LocalDate getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(LocalDate modifieddate) {
		this.modifieddate = modifieddate;
	}

	public LocalDate getCreatedby() {
		return createdby;
	}

	public void setCreatedby(LocalDate createdby) {
		this.createdby = createdby;
	}

	public LocalDate getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(LocalDate modifiedby) {
		this.modifiedby = modifiedby;
	}
	
	
}
