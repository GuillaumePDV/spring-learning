package poe.spring.delegate;

public class LoginCreationDelegate {

	public Boolean testStringLength(String s) {
		Boolean bool;
		if (s.length() >= 4 && s.length() <= 10) {
			bool = true;
		} else {
			bool = false;
		}
		return bool;
	}

	public Boolean testForbiddenString(String s) {
		Boolean bool;
		if (s.equals("") || s.equals("toto") || s.equals("titi") || s.equals("tata")) {
			bool = false;
		} else {
			bool = true;
		}
		return bool;
	}

}
