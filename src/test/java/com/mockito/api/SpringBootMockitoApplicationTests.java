package com.mockito.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.when;


import com.mockito.api.dao.UserRepository;
import com.mockito.api.model.User;
import com.mockito.api.service.UserService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMockitoApplicationTests {

	@Autowired
	UserService userService;
	
	@MockBean
	UserRepository  userRepository;
	
	@Test
	public void getAllUsers() {
	 
		when(userRepository.
		    findAll()).thenReturn(Stream.of( new User(1,"aa",22,"bb"),new User(2,"cc",33,"dd")					,new User(3,"ee",44,"ff")
								,new User(4,"gg",55,"hh"))
				                .collect(Collectors.toList()));
		assertEquals(4, userService.getUsers().size());
				                                     
	 
	}
	
}
