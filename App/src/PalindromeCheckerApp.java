import java.util.Scanner;
import java.util.Stack;

/**
 * PalindromeChecker class encapsulates the logic for checking palindromes.
 * It follows SRP: This class has only one responsibility — palindrome validation.
 */
class PalindromeChecker {

    /**
     * Checks if the given string is a palindrome using a Stack.
     *
     * @param input The string to check.
     * @return true if palindrome, false otherwise.
     */
    public boolean checkPalindrome(String input) {
        if (input == null) {
            return false; // Null is not a palindrome
        }

        // Normalize: remove spaces, convert to lowercase
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        // Use Stack to reverse
        Stack<Character> stack = new Stack<>();
        for (char ch : normalized.toCharArray()) {
            stack.push(ch);
        }

        // Compare original with reversed
        for (char ch : normalized.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

/**
 * Main class to run the program.
 */
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PalindromeChecker checker = new PalindromeChecker();

        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        if (checker.checkPalindrome(input)) {
            System.out.println("✅ It's a palindrome!");
        } else {
            System.out.println("❌ Not a palindrome.");
        }

        scanner.close();
    }
}
