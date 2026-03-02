import java.util.Scanner;
public class PalindromeCheckerApp {
    static void main() {
            Scanner sc = new Scanner(System.in);

            // Input from user
            System.out.print("Enter a string: ");
            String original = sc.nextLine();

            // Reverse the string using a for loop
            String reversed = "";
            for (int i = original.length() - 1; i >= 0; i--) {
                reversed += original.charAt(i); // String concatenation
            }

            // Compare original and reversed strings
            if (original.equals(reversed)) {
                System.out.println("The string is a palindrome.");
            } else {
                System.out.println("The string is NOT a palindrome.");
            }

            sc.close();
        }
    }
