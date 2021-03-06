/**
 * difficulty: easy
 * url: https://leetcode.com/problems/palindrome-linked-list/
 * tag: linkedlist, 2 pointers
 * time complexity: O(n), space: O(1)
 ***** need to review!! *****
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode fast = head;
        ListNode slow = head;

        while(fast.next != null && fast.next.next != null){//slow go to the middle of the linkedlist
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode secondHead = slow.next;
        slow.next = null;
        
        ListNode p1 = secondHead;
        ListNode p2 = p1.next;
        
        secondHead.next = null;
        
        while(p1 != null && p2 != null){//reverse 2nd half
            ListNode tmp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = tmp;
        }
        
        ListNode p = (p2 == null) ? p1 : p2;
        ListNode q = head;
        
        while(p != null){
            if(p.val != q.val) return false;
            p = p.next;
            q = q.next;
        }
        
        return true;
    }
}