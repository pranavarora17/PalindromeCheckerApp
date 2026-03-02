import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input string
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Validate input
        if (input == null || input.isEmpty()) {
            System.out.println("Input cannot be empty.");
            return;
        }

        // Create a Deque to store characters
        Deque<Character> deque = new ArrayDeque<>();

        // Insert characters into deque
        for (char ch : input.toCharArray()) {
            deque.addLast(ch); // add to rear
        }

        boolean isSame = true;

        // Compare front and rear until deque is empty or mismatch found
        while (deque.size() > 1) { // stop when 0 or 1 element left
            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if (front != rear) {
                isSame = false;
                break;
            }
        }

        // Output result
        if (isSame) {
            System.out.println("Front and rear elements matched for all comparisons.");
        } else {
            System.out.println("Mismatch found between front and rear elements.");
        }
    }
}
