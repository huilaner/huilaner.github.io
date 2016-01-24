/**
 * difficulty: easy
 * url: https://leetcode.com/problems/odd-even-linked-list/
 * tag: linkedlist
 * time complexity: O(N), space: O(1)
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode p1 = head;//odd
        ListNode p2 = head.next;//even
        ListNode p2Head = p2;
        boolean getOut = false;
        while(p2 != null && p2.next != null){
                p1.next =p1.next.next;
                p2.next = p2.next.next;
                p1 = p1.next;
                p2 = p2.next;
        }
        p1.next = p2Head;
        
        return head;
    }
}