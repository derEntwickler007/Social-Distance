package com.ujwal.socialDistance.dao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.ujwal.socialDistance.entity.User;
import com.ujwal.socialDistance.entity.UserFriendsRequestEntity;
import com.ujwal.socialDistance.entity.UserRemoveEntity;
import com.ujwal.socialDistance.repository.UserRepository;

@Repository
public class UserDao {
	
	@Autowired
	private UserRepository repository;
	
	public void save(User user) {
			repository.save(user);
	}
	public ResponseEntity<Map<String, Object>> addUserFriends(UserFriendsRequestEntity userFriendsRequestEntity) {
		Map<String, Object> result = new HashMap<String, Object>();
		Integer id1= userFriendsRequestEntity.getUserId();
		Integer id2 = userFriendsRequestEntity.getFriendId();
		User user1=null;
		User user2=null;
		user1=repository.getById(id1);
		user2=repository.getById(id2);
		user1.addUserFriends(user2);
		user2.addUserFriends(user1);
		this.repository.save(user1);
		this.repository.save(user2);
		result.put("success", true);
		return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
	}
	public ResponseEntity<Map<String, Object>> getUserFriendsList(Integer id) {
		Map<String, Object> result = new HashMap<String, Object>();
		if (id == null) {
			result.put("Error : ", "Invalid request");
			return new ResponseEntity<Map<String, Object>>(result, HttpStatus.BAD_REQUEST);
		}
		User user = this.repository.getById(id);
		Set<User> friends= user.getFriends();
		Set<User> friendList=new HashSet<>();
		for(User user1:friends) {
			User user2=new User();
			user2.setId(user1.getId());
			user2.setFirsName(user1.getFirsName());
			user2.setLastName(user1.getLastName());
			user2.setCity(user1.getCity());
			friendList.add(user2);
		}
		result.put("success", true);
		result.put("friends", friendList);
		result.put("count", friendList.size());
		return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
	}
	public ResponseEntity<Map<String, Object>> removeUserFriend(UserRemoveEntity userRemoveEntity) {
		Map<String, Object> result = new HashMap<String, Object>();
		if (userRemoveEntity == null) {
			result.put("Error : ", "Invalid request");
			return new ResponseEntity<Map<String, Object>>(result, HttpStatus.BAD_REQUEST);
		}
		Integer id1= userRemoveEntity.getUserId();
		Integer id2 = userRemoveEntity.getFriendId();
		User user1=null;
		User user2=null;
		user1=repository.getById(id1);
		user2=repository.getById(id2);
		user1.removeUserFriends(user2);
		user2.removeUserFriends(user1);
		repository.save(user1);
		repository.save(user2);
		result.put("success", true);
		return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
	}
}
