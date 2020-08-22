import java.util.Scanner;

public class TextMsgExpander {

	public static void main(String[] args) {
		
		// Initializes scanner
		Scanner scnr = new Scanner(System.in);
		
		// Creates userString variable to store user input string
		String userString = "";
		
		// Gets user input
		System.out.println("Enter text: ");
		userString = scnr.nextLine();
		
		// Prints user input unmodified
		System.out.println("You entered: " + userString);
		System.out.println("");
		
		
		// If statements check userString for BFF, IDK, JK, TMI, or TTYL
		// if found, replace abbreviation with words in userString
		// then print "Replaced <ABBREV> with <EXPANDED VERSION>
		if (userString.contains("BFF")) {
			userString = userString.replace("BFF", "best friend forever");
			System.out.println("Replaced \"BFF\" with \"best friend forever\".");
		}
		if (userString.contains("IDK")) {
			userString = userString.replace("IDK", "I don't know");
			System.out.println("Replaced \"IDK\" with \"I don't know\".");
		}
		if (userString.contains("JK")) {
			userString = userString.replace("JK", "just kidding");
			System.out.println("Replaced \"JK\" with \"just kidding\".");
		}
		if (userString.contains("TMI")) {
			userString = userString.replace("TMI", "too much information");
			System.out.println("Replaced \"TMI\" with \"too much information\".");
		}
		if (userString.contains("TTYL")) {
			userString = userString.replace("TTYL", "talk to you later");
			System.out.println("Replaced \"TTYL\" with \"talk to you later\".");
		}
		
		// Print new expanded version of input
		System.out.println("");
		System.out.println("Expanded: " + userString);
		
		scnr.close();

	}

}
