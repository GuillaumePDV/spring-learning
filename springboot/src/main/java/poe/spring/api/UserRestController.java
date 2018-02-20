package poe.spring.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poe.spring.domain.User;
import poe.spring.repository.UserRepository;
import poe.spring.service.UserManagerService;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

	@Autowired
	UserManagerService userManagerService;

	@PostMapping
	public User save(@RequestBody User user) {
		User savedUser = userManagerService.signup(user.getLogin(), user.getPassword());
		System.out.println("user id sqsq: " + savedUser);
		return savedUser;
	}

	@GetMapping
	public List<User> listUsers() {
		List<User> listUsers = userManagerService.listUsers();
		System.out.println(listUsers);
		return listUsers;
	}

	@RequestMapping("/id/{id}")
	public User getUserById(@PathVariable(value = "id") Long id) {
		User user = userManagerService.getUserById(id);
		System.out.println(user);
		return user;
	}

	@RequestMapping("/login/{login}")
	public User getUserByLogin(@PathVariable(value = "login") String login) {
		User user = userManagerService.getUserByLogin(login);
		System.out.println(user);
		return user;
	}

	@RequestMapping("/delete/login/{login}")
	public void deleteUserByLogin(@PathVariable(value = "login") String login) {
		User user = userManagerService.getUserByLogin(login);
		System.out.println("Delete user : " + user);
		userManagerService.deleteUser(user);
	}
	
	@RequestMapping("/delete/id/{id}")
	public void deleteUserById(@PathVariable(value = "id") Long id) {
		User user = userManagerService.getUserById(id);
		System.out.println("Delete user : " + user);
		userManagerService.deleteUser(user);
	}

}