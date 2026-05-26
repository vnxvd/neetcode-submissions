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
        // Dummy node 
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // 2 pointers
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        // Fast jump n steps
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        
        // Move both pointers until fast reach the end
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        // Remove node after slow
        slow.next = slow.next.next;
        
        // Return new list
        return dummy.next;
    }
}
