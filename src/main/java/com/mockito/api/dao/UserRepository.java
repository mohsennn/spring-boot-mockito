package com.mockito.api.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mockito.api.model.User;

public interface UserRepository extends MongoRepository<User, Integer> {

	List<User> findByAddress(String adress);
}
