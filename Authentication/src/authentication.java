// Load Java tools
import java.util.ArrayList;
import java.security.MessageDigest;

// Load Java Input Streams
import java.io.FileInputStream;
import java.util.Scanner;

// Load Error Exceptions
import java.io.IOException;
import java.security.NoSuchAlgorithmException;


/**
 * Simple Authentication program for Zoo
 * 
 * @author naburnham
 */

public class authentication {

	static int attempts;
	
	public authentication() {
		authentication.attempts = 0;
	}
	
	
	/**
	 * First screen displayed.
	 * Allows user to continue by choosing to Login (login()) or Exit.
	 * If selection is not valid, will return to beginning of method.
	 * 
	 * @see login()
	 */	
	public static void main(String[] args) {
		
		Scanner menuScanner = new Scanner(System.in);		
		int menuChoice;
		
		System.out.println("MENU");
		System.out.println("1: Log-in");
		System.out.println("2: Exit");

		
		// Currently has error if entering anything other than an integer and exits program.
		// Ideally would handle exception and return user back to choice selection
		if (menuScanner.hasNext()) {
			menuChoice = menuScanner.nextInt();
				
			if (menuChoice == 1) {
				login();
			} else if (menuChoice == 2) {
				System.exit(0);
			} else {
				System.out.println("Invalid Choice");
				main(null);
			}
		}
		menuScanner.close();
	}

	
	/**
	 * Retrieves user name and password inputs from User.
	 * Calls method checkUserAndPass(), if true creates User
	 * else increments attempts and sends back to main.
	 * 
	 * Exits program on third failed attempt
	 * 
	 * @see checkUserAndPass, User createUser, main
	 */
	public static void login() {

		Scanner loginScanner = new Scanner(System.in);
		String username;
		String password;

		System.out.println("Username: ");
		username = loginScanner.nextLine();
		
		System.out.println("Password: ");
		password = loginScanner.nextLine();		

		if (checkUserAndPass(username, password)) {
			attempts = 0;
			User.main(createUser(username));
		} else {
			System.out.println("Wrong username or password");
			attempts += 1;

			// IF attempts GREATER THAN OR EQUAL TO 3, close loginScanner and exit the program.
			if (attempts >= 3) {
				loginScanner.close();
				System.out.println("Maximum attempts exceeded");
				System.exit(0);
			}
		}				

		main(null);
		loginScanner.close();
	}
	
	
	public static User createUser(String username) {
		/*
		 * Calls User class to create a User with a specific user type as indicated in file
		 */
		ArrayList<String> list = loadCredentialsFile();
		User user = null;
		for (String each: list) {
			if (each.contains(username)) {				
				if (each.substring(0, username.length()).equals(username)) {
					if (each.contains("admin")) {
						user = new User("admin");
					} else if (each.contains("veterinarian")) {
						user = new User("veterinarian");
					} else if (each.contains("zookeeper")) {
						user = new User("zookeeper");
					} 
				}
			}
		}
		return user;
	}
	
	
	/**
	 * Using username and password from login() method, verifies using credentials file and 
	 * convertsPassword() to ensure that the username and password are a match, returning true
	 * if so, and false otherwise.
	 * 
	 * @param username	user entered username
	 * @param password 	user entered password
	 * @return boolean 	return true/false depending on username password match
	 * @see login(), loadCredentialsFile(), convertPassword()
	 */
	public static boolean checkUserAndPass(String username, String password) {
		ArrayList<String> list = loadCredentialsFile();
		
		for (String each: list) {
			if (each.contains(username)) {
				if (each.substring(username.length() + 1, username.length() + 33).equals(convertPassword(password))){
					return true;
				}
			}
		}
		return false;
	}
	
	
	public static ArrayList<String> loadCredentialsFile() {
		/*
		 * Gets information from a file, and appends it to an ArrayList
		 */
		try {
			FileInputStream file = new FileInputStream("credentials.txt");
			Scanner fileIn = new Scanner(file);
			ArrayList<String> array = new ArrayList<String>();
			String line = "";
			
			line = fileIn.nextLine();
			while (fileIn.hasNextLine()) {
				array.add(line);
				line = fileIn.nextLine();
			}
			array.add(line);
			fileIn.close();
			return array;
		} catch (IOException e) {
			System.out.println("File not found.\nThe program will now close.");
		}
		return null;
	}
	
	
	/**
	 * Converts String user entered password to MD5 hashed password
	 * 
	 * @param password
	 * @return String passwordInMD5
	 * @see NoSuchAlgorithmException, MessageDigest
	 */	
	public static String convertPassword(String password) {
		String original = password;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(original.getBytes());
			byte[] digest = md.digest();
			StringBuffer sb = new StringBuffer();
			for (byte b : digest) {
				sb.append(String.format("%02x", b & 0xff));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}		
		return "";
	}
}
