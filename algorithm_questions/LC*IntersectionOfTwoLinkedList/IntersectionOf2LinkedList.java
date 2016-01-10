/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
/**
  * difficulty: easy
  * url: https://leetcode.com/problems/intersection-of-two-linked-lists/
  * tag: linkedlist
  * time complexity: O(n), space: O(1)
*/
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode p = new ListNode(0); p.next = headA;
        ListNode q = new ListNode(0); q.next = headB;
        int cntA = 0; int cntB = 0;
        
        while(p != null){
            cntA++;
            p = p.next;
        }
        while(q != null){
            cntB++;
            q = q.next;
        }
        p = (cntA > cntB) ? headA : headB;
        q = (cntA > cntB) ? headB : headA;
        int diff = Math.abs(cntA - cntB);
        
        while(diff > 0 && p != null){
            p = p.next;
            diff--;
        }
        while(p != null){
            if(p.val == q.val) return p;
            else{
                p = p.next;
                q = q.next;
            }
        }
        return null;
    }
}