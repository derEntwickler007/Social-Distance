package com.ujwal.socialDistance.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.util.CollectionUtils;


@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String firstName;
	private String lastName;
	@Column(name = "email")
	private String emailId;
	private String password;
	private String mobileNo;
	private String city;
	@ManyToMany
	@JoinTable(name="user_friends", joinColumns = @JoinColumn(name="usedId"), inverseJoinColumns = @JoinColumn(name="friendId"))
	private Set<User> friends;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirsName() {
		return firstName;
	}
	public void setFirsName(String firsName) {
		this.firstName = firsName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Set<User> getFriends() {
		return friends;
	}
	public void setFriends(Set<User> friends) {
		this.friends = friends;
	}
	public void addUserFriends(User user) {
		if (CollectionUtils.isEmpty(this.friends)) {
			this.friends = new HashSet<>();
		}
		this.friends.add(user);
	}
	public void removeUserFriends(User user) {
		if (CollectionUtils.isEmpty(this.friends)) {
			this.friends = new HashSet<>();
		}
		this.friends.remove(user);
	}
}
