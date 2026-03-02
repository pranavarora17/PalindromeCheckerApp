import java.util.Scanner;

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        // Step 1: Normalize string (remove non-alphanumeric, lowercase)
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Step 2: Apply palindrome logic
        boolean isPalindrome = checkPalindrome(normalized);

        // Step 3: Output result
        if (isPalindrome) {
            System.out.println("✅ It's a palindrome!");
        } else {
            System.out.println("❌ Not a palindrome.");
        }
        sc.close();
    }

    private static boolean checkPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
