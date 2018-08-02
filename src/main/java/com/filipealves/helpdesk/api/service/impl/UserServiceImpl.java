package com.filipealves.helpdesk.api.service.impl;

//simport java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.stereotype.Service;

import com.filipealves.helpdesk.api.entity.User;
import com.filipealves.helpdesk.api.repository.UserRepository;
import com.filipealves.helpdesk.api.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	public User findByEmail(String email) {
		return this.userRepository.findByEmail(email);
	}

	public User createOrUpdate(User user) {
		return this.userRepository.save(user);
	}

	@Override
	public User findById(String id) {
	return this.userRepository.findById(id).get();
	}

	@Override
	public void delete(String id) {
	this.userRepository.deleteById(id);
	}

	@Override
	public Page<User> findAll(int page, int count) {
	return this.userRepository.findAll(PageRequest.of(page, count));
	}
}
