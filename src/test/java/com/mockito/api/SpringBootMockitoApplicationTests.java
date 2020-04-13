package com.mockito.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.verification.Times;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

import com.mockito.api.dao.UserRepository;
import com.mockito.api.model.User;
import com.mockito.api.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMockitoApplicationTests {

	@Autowired
	UserService userService;

	@MockBean
	UserRepository userRepository;

	@Test
	public void getUsersTest() {

		when(userRepository.findAll()).thenReturn(Stream.of(new User(1, "aa", 22, "bb"), new User(2, "cc", 33, "dd"),
				new User(3, "ee", 44, "ff"), new User(4, "gg", 55, "hh")).collect(Collectors.toList()));
		assertEquals(4, userService.getUsers().size());
	}

	@Test
	public void getUserByAdress() {
		String address = "Tunisia";
		when(userRepository.findByAddress(address)).thenReturn(Stream
				.of(new User(1, "mohsen", 22, "Tunisia"), new User(1, "mohsen1", 22, "Tunisia")).collect(Collectors.toList()));
		assertEquals(2, userService.getUserByAdress(address).size());
	}

	@Test
	public void saveUserTest() {
		User user = new User(3, "mohsen1", 44, "Italy");
		when(userRepository.save(user)).thenReturn(user);
		assertEquals(user, userService.addUser(user));

	}
	
	@Test
	public void deleteTest() {
		User user = new User(5, "mohsen", 44, "France");
		userService.deletUser(user);
		//pour verifier si la methode delete a été appelé une seul fois ou pas 
		verify(userRepository,times(3)).delete(user);
	
	}

}
