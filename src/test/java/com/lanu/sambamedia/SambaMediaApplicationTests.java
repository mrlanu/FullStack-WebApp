package com.lanu.sambamedia;

import com.lanu.sambamedia.entities.Task;
import com.lanu.sambamedia.entities.User;
import com.lanu.sambamedia.services.TaskService;
import com.lanu.sambamedia.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SambaMediaApplicationTests {

	@Autowired
	private UserService userService;

	@Autowired
	private TaskService taskService;

	@Before
	public void initDb() {
		User newUser = new User("testUser@gmail.com", "testUser", "123456");
		userService.createUser(newUser);


		User newAdmin = new User("testAdmin@gmail.com", "testAdmin", "123456");
		userService.createUser(newAdmin);


		Task userTask = new Task("02/28/2018", "00:11", "11:00", "You need to work");
		User user = userService.findOne("testUser@gmail.com");

		taskService.addTask(userTask, user);
	}

	@Test
	public void testUser(){
		User user = userService.findOne("testUser@gmail.com");
		assertNotNull(user);
		User admin = userService.findOne("testAdmin@gmail.com");
		assertEquals(admin.getEmail(), "testAdmin@gmail.com");
	}

	@Test
	public void testTask(){
		User user = userService.findOne("testUser@gmail.com");
		List<Task> tasks = taskService.findUserTask(user);
		assertNotNull(tasks);
	}

}
