package com.vti.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.vti.entity.enumerate.EUserRole;
import com.vti.entity.enumerate.EUserGender;
import com.vti.entity.generator.UserGenderConvertor;
import com.vti.entity.generator.UserRoleConvertor;

@Entity
@Table(name = "`User`", catalog = "TestingSystem")
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;
	
	@Column(name = "username", length = 50, nullable = false, unique = true)
	private String username;
	
	@Column(name = "email", length = 50, nullable = false, unique = true)
	private String email;
	
	@Column(name = "password", length = 800, nullable = false)
	private String password;
	
	@Column(name = "firstName", length = 50, nullable = false)
	private String firstName;
	
	@Column(name = "lastName", length = 50, nullable = false)
	private String lastName;
	
	@Column(name = "gender", nullable = false)
	@Convert(converter = UserGenderConvertor.class)
	private EUserGender gender;
	
	@Column(name = "date_Of_Birth", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	
	@Column(name = "address", length = 100, nullable = false)
	private String address;
	
	@Column(name = "phone", length = 15, nullable = false)
	private String phone;
	
	@Column(name = "role", nullable = false)
	@Convert(converter = UserRoleConvertor.class)
	private EUserRole role;
	
	@Column(name = "status")
	private short status;
	
	public User() {
		
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public EUserGender getGender() {
		return gender;
	}

	public void setGender(EUserGender gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public EUserRole getRole() {
		return role;
	}

	public void setRole(EUserRole role) {
		this.role = role;
	}

	public short getStatus() {
		return status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", dateOfBirth="
				+ dateOfBirth + ", address=" + address + ", phone=" + phone + ", role=" + role + ", status=" + status
				+ "]";
	}
	
	
}
