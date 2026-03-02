public class PalindromeCheckerApp {
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    static void main() {
        String st = "madam";
        boolean result=isPalindrome(st);
        System.out.println(result);
    }
}
