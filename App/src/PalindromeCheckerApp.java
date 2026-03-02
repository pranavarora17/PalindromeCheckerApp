public class PalindromeCheckerApp {
    public static void main(String[] args) {
        String test = "racecar"; // Use a longer string for better results

        // 1. StringBuilder Approach
        long start1 = System.nanoTime();
        boolean res1 = new StringBuilder(test).reverse().toString().equals(test);
        long end1 = System.nanoTime();

        // 2. Two-Pointer Approach
        long start2 = System.nanoTime();
        boolean res2 = isTwoPointerPalindrome(test);
        long end2 = System.nanoTime();

        System.out.println("StringBuilder Time: " + (end1 - start1) + " ns");
        System.out.println("Two-Pointer Time: " + (end2 - start2) + " ns");
    }

    public static boolean isTwoPointerPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}