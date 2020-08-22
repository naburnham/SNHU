/*
 * Needed class to verify users load correct user type until user decides to log out
 */

// Load input streams
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

// Load java exceptions
import java.io.IOException;

public class User {
	
	private String userType;

	public User(String userType) {
		this.userType = userType;
	}

	public static void main(User userType) {
		/*
		 * Displays file after loaded, then gives user option to log-out
		 * returning user back to main menu
		 */
		loadUserFiles(userType.userType);
		System.out.println("\nEnter 'q' to log-out");
		
		Scanner scnr = new Scanner(System.in);
		String input = scnr.next();
		
		if (input.equals("q")) {
			authentication.main(null);
			scnr.close();
		} else {
			main(userType);
		}
	}
	
	public String getUserType() {
		// Introduced this method for testing purposes.
		return userType;
	}
	
	public static void loadUserFiles(String userType) {
		/*
		 * Loads file based on type of user.
		 */
		
		FileReader fileReader = null;
		BufferedReader buffReader = null;
		
		try {
			fileReader = new FileReader(userType + ".txt");
			buffReader = new BufferedReader(fileReader);
			
			String currentLine;
			
			while ((currentLine = buffReader.readLine()) != null) {
				System.out.println(currentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (buffReader != null) {
					buffReader.close();
				}
				
				if (fileReader != null) {
					fileReader.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
