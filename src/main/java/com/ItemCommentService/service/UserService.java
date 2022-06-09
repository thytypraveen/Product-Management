package com.ItemCommentService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ItemCommentService.entity.User;
import com.ItemCommentService.repository.UserRepository;


@Service
public class UserService {
	 @Autowired
	    private UserRepository userRepository;

	public User createUser(User user) {
        return userRepository.save(user);
    }

}
