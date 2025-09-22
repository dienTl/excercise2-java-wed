package com.javaweb.repository.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.internal.bytebuddy.asm.Advice.Local;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="role")
public class RoleEntity {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Integer id ;
	
	@ManyToMany(mappedBy = "roles" , fetch = FetchType.LAZY)
	private List<UserEntity> users = new ArrayList<UserEntity>();
	
	@Column(name ="name" ,unique = true, nullable = false)
	private String name ;
	
	@Column(name ="code" , nullable = false)
	private String code ;
	
	@Column(name ="createddate")
	private LocalDate createddate ;
	
	@Column(name ="modifieddate")
	private LocalDate modifieddate ;
	
	@Column(name ="createdby")
	private String createdby ;
	
	@Column( name ="modifiedby")
	private String modifiedby;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public String getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby;
	}
	
	
}
