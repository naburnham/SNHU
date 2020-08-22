public class Testing {
	
	public static boolean checkUserAndPassTest(String user, String pass) {
		
		return authentication.checkUserAndPass(user, pass);
	}
	
	public static boolean convertPasswordTest(String password, String result) {
		return authentication.convertPassword(password).equals(result);
	}

	public static void main(String[] args) {
		System.out.println("Testing checkUserAndPass()");
		
		System.out.println("nathan.burnham, password: Expecting true, got: " + checkUserAndPassTest("nathan.burnham", "password"));
		System.out.println("nathan.burnham, password: Expecting false, got: " + checkUserAndPassTest("nathan.burnham", "password1"));
		System.out.println("nathan.burnham, password: Expecting false, got: " + checkUserAndPassTest("nathan.burnhamg", "password"));
		
		System.out.println("checkUserAndPass() Test completed");
		
		System.out.println("Test user class");
		
		User testUser = new User("zookeeper");
		if (testUser.getUserType() != "zookeeper") {
			System.out.println("new User(\"zookeeper\") failed");
		}
		
		User testUser2 = new User("administrator");
			if (testUser2.getUserType() != "administrator") {
				System.out.println("new User(\"adminstrator\") failed");
			}
			
		System.out.println("Test user class completed");
		
		System.out.println("Testing convert password");
		System.out.println("Testing password and 5f4dcc3b5aa765d61d8327deb882cf99, expecting true: " + convertPasswordTest("password", "5f4dcc3b5aa765d61d8327deb882cf99"));
		System.out.println("Testing password1 and 5f4dcc3b5aa765d61d8327deb882cf99, expecting false: " + convertPasswordTest("password1", "5f4dcc3b5aa765d61d8327deb882cf99"));
		
		System.out.println("Testing convert password completed.");
		
	}

}
