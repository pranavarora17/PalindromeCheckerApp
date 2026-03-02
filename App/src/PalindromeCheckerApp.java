import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {

    // Method to check if a string is a palindrome using a stack
    public static boolean isPalindrome(String input) {
        if (input == null) {
            return false; // Null strings are not palindromes
        }

        // Remove spaces and convert to lowercase for uniform comparison
        String cleaned = input.replaceAll("\\s+", "").toLowerCase();

        // Edge case: empty string is considered a palindrome
        if (cleaned.isEmpty()) {
            return true;
        }

        Stack<Character> stack = new Stack<>();

        // Push all characters into the stack
        for (char ch : cleaned.toCharArray()) {
            stack.push(ch);
        }

        // Pop characters and compare with original sequence
        for (char ch : cleaned.toCharArray()) {
            if (stack.pop() != ch) {
                return false; // Mismatch found
            }
        }

        return true; // All characters matched
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to check palindrome: ");
        String input = scanner.nextLine();

        try {
            if (isPalindrome(input)) {
                System.out.println("✅ The string is a palindrome.");
            } else {
                System.out.println("❌ The string is NOT a palindrome.");
            }
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
