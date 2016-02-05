/**
 * difficulty: medium
 * url: https://leetcode.com/problems/reorder-list/
 * tag: linkedlist
 * time: O(n), space: O(1)
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        
        //go to the middle
        ListNode fast = head;
        ListNode slow = head;
        ListNode front = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //reverse 2nd haf
        ListNode prev=null;
        while(slow != null){
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        
        slow = prev;//before null
        
        while(front != null && front.next != null && slow != null && slow.next != null){
            ListNode frontNext = front.next;
            ListNode slowNext = slow.next;
            slow.next = frontNext;
            front.next = slow;
            front = frontNext;
            slow = slowNext;
            
        }
        
        return;
    }
}