/**
 * difficulty: medium
 * url: https://leetcode.com/problems/insertion-sort-list/
 * tag: LinkedList, sort
 * time: O(n^2), space: O(1)
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0);//dummy.next = head;
        ListNode next = null;//next node to be inserted
        ListNode curr = head;//to be inserted
        ListNode pre = dummy;//insert betwen pre and pre.next
        while(curr != null){
            next = curr.next;
           while(pre.next != null && curr.val >= pre.next.val){
               pre = pre.next;
           }
           curr.next = pre.next;
           pre.next = curr;
           pre = dummy;
           curr = next;
           
        }
        return dummy.next;
    }
}