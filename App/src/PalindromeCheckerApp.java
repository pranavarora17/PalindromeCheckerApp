import java.util.*;

// 1. Strategy Interface
interface PalindromeStrategy {
    boolean isPalindrome(String text);
}

// 2. Concrete Strategy: Using Stack
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String text) {
        if (text == null) return false;
        String cleaned = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char c : cleaned.toCharArray()) {
            stack.push(c);
        }
        for (char c : cleaned.toCharArray()) {
            if (stack.pop() != c) return false;
        }
        return true;
    }
}

// 3. Concrete Strategy: Using Deque
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String text) {
        if (text == null) return false;
        String cleaned = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : cleaned.toCharArray()) {
            deque.addLast(c);
        }
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) return false;
        }
        return true;
    }
}

// 4. Context Class
class PalindromeChecker {
    private PalindromeStrategy strategy;

    // Inject strategy at runtime
    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean check(String text) {
        if (strategy == null) {
            throw new IllegalStateException("No palindrome strategy set.");
        }
        return strategy.isPalindrome(text);
    }
}

// 5. Demo
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        PalindromeChecker checker = new PalindromeChecker();

        // Choose Stack strategy
        checker.setStrategy(new StackStrategy());
        System.out.println("Stack Strategy: 'Madam' -> " + checker.check("Madam"));

        // Switch to Deque strategy
        checker.setStrategy(new DequeStrategy());
        System.out.println("Deque Strategy: 'A man, a plan, a canal: Panama' -> " +
                checker.check("A man, a plan, a canal: Panama"));

        // Edge case: Not a palindrome
        System.out.println("Deque Strategy: 'Hello' -> " + checker.check("Hello"));
    }
}
