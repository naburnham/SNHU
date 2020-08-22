import java.util.Scanner;

public class TextMessageDecoder {

	public static void main(String[] args) {
		
		Scanner scnr = new Scanner(System.in);
		
		String userString = "";
		
		System.out.println("Enter text: ");
		userString = scnr.nextLine();
		
		if (userString.contains("IDK")) {
			userString = userString.replace("IDK", "I don't know");
			System.out.println("Replaced \"IDK\" with \"I don't know\".");
		}
		if (userString.contains("TTYL")) {
			userString = userString.replace("TTYL", "talk to you later");
			System.out.println("Replaced \"TTYL\" with \"talk to you later\".");
		}
		if (userString.contains("JK")) {
			userString = userString.replace("JK", "just kidding");
			System.out.println("Replaced \"JK\" with \"just kidding\".");
		}
		if (userString.contains("TMI")) {
			userString = userString.replace("TMI", "too much information");
			System.out.println("Replaced \"TMI\" with \"too much information\".");
		}
		if (userString.contains("BFF")) {
			userString = userString.replace("BFF", "best friend forever");
			System.out.println("Replaced \"BFF\" with \"best friend forever\".");
		}
		
		System.out.println("Expanded: " + userString);
		
		scnr.close();
	}

}
