/**
 * difficulty: medium
 * url: https://leetcode.com/problems/linked-list-cycle-ii/
 * tag: linkedlist, 2 pointers
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    //with extra space
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode p = head;
        HashSet<ListNode> set = new HashSet<>();
        while(p != null){
            if(set.contains(p)) return p;
            set.add(p);
            p = p.next;
        }
        return null;
    }
}

public class Solution {
    //if use slow and fast pointer, should going back to the same begining after two rounds
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        boolean firstMeet = false;
        while(slow != null && fast != null && fast.next != null && !firstMeet){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) firstMeet = true;
        }
        if(!firstMeet) return null;
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
