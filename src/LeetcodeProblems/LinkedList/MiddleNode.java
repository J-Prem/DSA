// LeetCode 876: Middle of the Linked List | Algorithm: Two Pointer Technique
package LeetcodeProblems.LinkedList;

public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
