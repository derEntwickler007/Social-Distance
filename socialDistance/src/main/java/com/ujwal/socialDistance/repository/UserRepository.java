package com.ujwal.socialDistance.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.ujwal.socialDistance.entity.User;


public interface UserRepository extends JpaRepository<User, Integer> {
	User getById(Integer id);
}
