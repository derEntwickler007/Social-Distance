package com.ujwal.socialDistance.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ujwal.socialDistance.dao.UserDao;
import com.ujwal.socialDistance.entity.User;
import com.ujwal.socialDistance.entity.UserFriendsRequestEntity;

@RestController
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	private UserDao userDao;
	
	@PostMapping("save")
	public String saveUser(@RequestBody User user) {
		userDao.save(user);
		return "User Created Sucessfully";
	}
	
	@PostMapping("/userFriendRequest")
	public ResponseEntity<Map<String, Object>> userFriendRequest(@RequestBody UserFriendsRequestEntity userFriendsRequestEntity) {
		return this.userDao.addUserFriends(userFriendsRequestEntity);
	}

	@GetMapping("/getUserFriendList")
	public ResponseEntity<Map<String, Object>> getUserFriendList(@RequestParam Integer id) {
		return this.userDao.getUserFriendsList(id);
	}
	
	@PostMapping("/removeUserFriend")
	public ResponseEntity<Map<String, Object>> removeUserFriend(@RequestBody UserFriendsRequestEntity userFriendsRequestEntity) {
		return this.userDao.removeUserFriend(userFriendsRequestEntity);
	}
//
//	@PostMapping("/getCommonUserFriends")
//	public ResponseEntity<Map<String, Object>> getCommonUserFriends(@RequestBody User userFriendsRequestEntity) {
//		return this.userDao.getCommonUserFriends(userFriendsRequestEntity);
//	}
}