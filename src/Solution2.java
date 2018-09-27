
/*

给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。

你可以假设除了数字 0 之外，这两个数字都不会以零开头。

 */

import java.util.Random;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution2 {
    Random random = new Random();

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        ListNode l1 = solution.getRandomList();
        ListNode l2 = solution.getRandomList();
        solution.pritnNumber(l1);
        solution.pritnNumber(l2);
        solution.pritnNumber(solution.addTwoNumbers(l1, l2));
    }

    public ListNode getRandomList() {
        int n = random.nextInt(10);
        ListNode head = new ListNode(0);
        ListNode current = head;
        for (int i = 0; i < n; i++) {
            current.next = new ListNode(random.nextInt(10));
            current = current.next;
        }
        return head.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }else if (l2 == null) {
            return l1;
        }

        int carry = 0;
        ListNode il1 = l1;
        ListNode il2 = l2;
        ListNode head = new ListNode(0);
        ListNode current = head;

        while (il1 != null && il2 != null) {
            int sum = il1.val + il2.val + carry;
            int val = sum % 10;
            carry = sum / 10;
            current.next = new ListNode(val);
            current = current.next;

            il1 = il1.next;
            il2 = il2.next;
        }

        while (il1 != null) {
            int sum = il1.val + carry;
            int val = sum % 10;
            carry = sum / 10;
            current.next = new ListNode(val);
            current = current.next;
            il1 = il1.next;
        }

        while (il2 != null) {
            int sum = il2.val + carry;
            int val = sum % 10;
            carry = sum /10;
            current.next = new ListNode(val);
            current = current.next;
            il2 = il2.next;
        }

        if (carry != 0) {
            current.next = new ListNode(carry);
            current = current.next;
        }

        return head.next;
    }

    public void pritnNumber(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode current = head;
        while (current != null) {
            sb.append(current.val);
            current = current.next;
        }

        System.out.println(sb.toString());
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
