package poe.spring.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import poe.spring.domain.User;
import poe.spring.repository.UserRepository;
import poe.spring.service.UserManagerService;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserManagerServiceTests {

	@Autowired
	UserManagerService userManagerService;

	@Autowired
	UserRepository userRepository;

	@Test
	public void checkUserCreation() {

		// ----------------------------------------------------------------
		// Start TI create User
		// ----------------------------------------------------------------
		// enregistre un nouvel utilisateur en BDD
		String login = "login";
		String password = "password";
		// login = "jean";
		// password = "secret";
//		User createdUser = userManagerService.signup("login", "password");
//
//		assertThat(createdUser).isNotNull();
//		assertThat(createdUser.getId()).isNotNull().isGreaterThan(0);
//
//		// récupération de l'utilisateur en base de données
//		Long createdUserId = createdUser.getId();
//		User user = userRepository.findOne(createdUserId);
//
//		// vérifications
//		assertThat(user).isNotNull();
//		assertThat(user.getLogin()).isEqualTo(login);
		// ----------------------------------------------------------------
		// End TI create User
		// ----------------------------------------------------------------
		// ----------------------------------------------------------------
		// Start TI create 10 Users
		// ----------------------------------------------------------------
		// End TI create 10 Users
		// ----------------------------------------------------------------

	}

}
