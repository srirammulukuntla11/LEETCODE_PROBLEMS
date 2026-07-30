/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null) return null;

        ListNode fast = head;
        ListNode slow = head;

        // move fast n steps ahead
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // if deleting the head node
        if (fast == null) {
            return head.next;
        }

        // move both pointers
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // delete nth node from end
        slow.next = slow.next.next;

        return head;
    }
}
