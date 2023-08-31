package innerclasses;

public class Demon {

	private static String userName;
	private static String password;
	
	public Demon() {
		Demon.userName = "uexcel";
		Demon.password = "compromise#";
	}

       static class Validator {
		private String userNameInput;
		private String passwordInput;

		public Validator(String userNameInput, String passwordInput) {
			new Demon();
			this.userNameInput = userNameInput;
			this.passwordInput = passwordInput;
			
		}

		public Boolean validate() {
			return userName.equals(userNameInput) && password.equals(passwordInput);

		}
	}

}
