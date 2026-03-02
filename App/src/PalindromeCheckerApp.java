import java.util.Scanner;
public class PalindromeCheckerApp {
    public static boolean isPalindrome(char[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            // Skip non-alphanumeric characters
            while (left < right && !Character.isLetterOrDigit(arr[left])) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(arr[right])) {
                right--;
            }

            // Compare characters ignoring case
            if (Character.toLowerCase(arr[left]) != Character.toLowerCase(arr[right])) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    static void main() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Validate input
        if (input == null || input.trim().isEmpty()) {
            System.out.println("Invalid input. Please enter a non-empty string.");
            sc.close();
            return;
        }

        // Convert string to character array
        char[] charArray = input.toCharArray();

        // Check palindrome
        if (isPalindrome(charArray)) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is NOT a palindrome.");
        }

        sc.close();
        }
    }
