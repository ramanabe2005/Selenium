
import java.util.Scanner;
public class ReverseString {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter a string");
		String original = scan.nextLine();
		while(original.isEmpty() || original == null){
			System.out.println("Please enter a valid string, empty and null strings are not accepted");
			original = scan.nextLine();
		}
		scan.close();
		ReverseString output = new ReverseString();
		String reverse = output.reversechar(original);
		System.out.println("The reverse string of the entered string is " + reverse);
	}
	private String reversechar(String originalstring){
		String reverse = "";
		for(int i= originalstring.length()-1;i>=0;i--){
			reverse = reverse + originalstring.charAt(i);		
		}
		return reverse;
	}
}
	