import java.util.*;

public class PalindromeChecker {

    interface PalindromeStrategy {
        boolean check(String input);
    }

    static class StackStrategy implements PalindromeStrategy {

        public boolean check(String input) {
            input = input.toLowerCase().replaceAll("[^a-z0-9]", "");
            Stack<Character> stack = new Stack<>();

            for (char c : input.toCharArray())
                stack.push(c);

            for (char c : input.toCharArray())
                if (c != stack.pop())
                    return false;

            return true;
        }
    }

    static class DequeStrategy implements PalindromeStrategy {

        public boolean check(String input) {
            input = input.toLowerCase().replaceAll("[^a-z0-9]", "");
            Deque<Character> deque = new LinkedList<>();

            for (char c : input.toCharArray())
                deque.addLast(c);

            while (deque.size() > 1)
                if (!deque.removeFirst().equals(deque.removeLast()))
                    return false;

            return true;
        }
    }

    private PalindromeStrategy strategy;

    public PalindromeChecker(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean execute(String input) {
        return strategy.check(input);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        System.out.println("Choose Strategy:");
        System.out.println("1. Stack");
        System.out.println("2. Deque");

        int choice = sc.nextInt();

        PalindromeStrategy strategy;

        if (choice == 1)
            strategy = new StackStrategy();
        else
            strategy = new DequeStrategy();

        PalindromeChecker checker = new PalindromeChecker(strategy);

        if (checker.execute(input))
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");

        sc.close();
    }
}