/**
 * difficulty: medium
 * url: https://leetcode.com/problems/sort-list/
 * tag: linkedlist, sort
 * time: O(NlogN), space: O(1)
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 //very basic knowledge, need to revisit to review merge sort, linkedlist basic operations
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head ==  null || head.next == null) return head;
        else return sort(head);
    }

    private ListNode sort(ListNode head){
        if(head ==  null || head.next == null) return head;//base case

        //cut into 2 halves
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;//need to make the 1st list has end
        
        //sort each
        ListNode l1 = sort(head);
        ListNode l2 = sort(slow);
        
        //merge two lists
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                p.next = l1;
                l1 = l1.next;
            }
            else{
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;   
        }
        if(l1 != null) p.next = l1;
        if(l2 != null) p.next = l2;
        return dummyHead.next;
    }
}
