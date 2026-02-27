import java.util.*;

public class PalindromeCheckerApp {

    static class Node {
        char data;
        Node next;
        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head = null;

    static void insert(char ch) {
        Node newNode = new Node(ch);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    static boolean isPalindrome() {
        if (head == null || head.next == null)
            return true;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node prev = null;
        Node curr = slow;
        Node next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node firstHalf = head;
        Node secondHalf = prev;

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data)
                return false;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine().toLowerCase();

        for (int i = 0; i < input.length(); i++) {
            insert(input.charAt(i));
        }

        if (isPalindrome())
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");

        sc.close();
    }
}