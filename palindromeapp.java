package palindrome123;
import java.util.*;

public class palindromeapp {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        input = input.toLowerCase();
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            queue.add(ch);      // Enqueue
            stack.push(ch);     // Push
        }
        boolean isPalindrome = true;
        while (!queue.isEmpty()) {
            char qChar = queue.remove();   // Dequeue
            char sChar = stack.pop();      // Pop

            if (qChar != sChar) {
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome)
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");

        sc.close();
    }
}