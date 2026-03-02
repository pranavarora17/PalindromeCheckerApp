import java.util.Scanner;

public class PalindromeCheckerApp {

    /**
     * Recursive method to check if a string is a palindrome.
     * @param str   The string to check
     * @param start Starting index
     * @param end   Ending index
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindrome(String str, int start, int end) {
        // Base condition: If start >= end, all characters matched
        if (start >= end) {
            return true;
        }

        // If mismatch found, it's not a palindrome
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive call: move towards the center
        return isPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Remove spaces and convert to lowercase for uniform comparison
        String cleaned = input.replaceAll("\\s+", "").toLowerCase();

        // Validate input
        if (cleaned.isEmpty()) {
            System.out.println("Empty string is considered a palindrome.");
        } else {
            boolean result = isPalindrome(cleaned, 0, cleaned.length() - 1);
            if (result) {
                System.out.println("The string is a palindrome.");
            } else {
                System.out.println("The string is NOT a palindrome.");
            }
        }

        scanner.close();
    }
}
