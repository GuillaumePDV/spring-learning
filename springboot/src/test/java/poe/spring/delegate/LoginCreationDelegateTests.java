package poe.spring.delegate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
//import org.apache.commons.codec.binary.Hex;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Random;

import javax.xml.bind.DatatypeConverter;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginCreationDelegateTests {

	@Test
	public void checkLoginOK() {
		String login = buildStringWithSizeBetween(LoginCreationDelegate.MIN_LOGIN_LENGTH);
		assertThat(LoginCreationDelegate.isSizeValid(login)).isTrue();
		login = buildStringWithSizeBetween(LoginCreationDelegate.MAX_LOGIN_LENGTH);
		assertThat(LoginCreationDelegate.isSizeValid(login)).isTrue();
	}

	@Test
	public void checkLoginSizeKO() {
		String login = buildStringWithSizeBetween(LoginCreationDelegate.MIN_LOGIN_LENGTH - 1);
		assertThat(LoginCreationDelegate.isSizeValid(login)).isFalse();
		login = buildStringWithSizeBetween(LoginCreationDelegate.MAX_LOGIN_LENGTH + 1);
		assertThat(LoginCreationDelegate.isSizeValid(login)).isFalse();
	}

	private String buildStringWithSizeBetween(int size) {
		String str = "";
		for (int i = 0; i < size; i++) {
			str += "0";
		}
		return str;
	}

	private String generateRandomUnicodeCharacter() {
		String RandomUnicodeCharacter = new String();
		String hexString = generateRandomUnicodeCharacterHexa();
//		byte[] bytes = Hex.decodeHex(hexString.toCharArray());
		byte[] bytes = DatatypeConverter.parseHexBinary(hexString);
//		RandomUnicodeCharacter = new String(bytes, "UTF-8");
		/*
		String hexString = "fd00000aa8660b5b010006acdc0100000101000100010000";    
		byte[] bytes = Hex.decodeHex(hexString.toCharArray());
		System.out.println(new String(bytes, "UTF-8"));
		 * */
		return RandomUnicodeCharacter;
	}

	private String generateRandomUnicodeCharacterHexa() {
		String RandomUnicodeCharacterHexa = new String();
		for (int i = 0; i < 4; i++) {
			RandomUnicodeCharacterHexa += intToHex(randInt(0, 15));
		}
		return RandomUnicodeCharacterHexa;
	}

	public Integer randInt(Integer min, Integer max) {
		Random rand = new Random();
		Integer randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}

	public String intToHex(Integer i) {
		return Integer.toHexString(i);
	}
}
