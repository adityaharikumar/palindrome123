import java.util.Stack;

public class PalindromeChecker {

    public boolean checkPalindrome(String input) {

        input = input.toLowerCase();
        input = input.replaceAll("[^a-z0-9]", "");

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != stack.pop())
                return false;
        }

        return true;
    }
}