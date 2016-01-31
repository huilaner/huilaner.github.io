/**
 * difficulty: medium
 * url: https://leetcode.com/problems/partition-list/
 * tag: LinkedList, 2 pointers
 * time: O(n), space: O(n)
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null) return null;
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode curr1 = dummy1;
        ListNode curr2 = dummy2;
        while(head != null){
            if(head.val < x){
                curr1.next = head;
                curr1 = curr1.next;
            }else{
                curr2.next = head;
                curr2 = curr2.next;
            }
            head = head.next;
        }
        curr1.next = dummy2.next;
        curr2.next = null;
        return dummy1.next;
        
    }
}

//how to do it in place????
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode L2 = head;
        ListNode L1 = dummy;
        ListNode R1 = dummy;
        ListNode R2 = head;

        while(L2 != null && L2.next != null){
            while (L2 != null && R2 != null && R1 != null && L1 != null && L2.val < x){
                System.out.println("R2:"+R2.val+"L2:"+L2.val);
                L2 = L2.next;
                L1 = L1.next;
                R1 = R1.next;
                R2 = R2.next;
            }
            if(L2 != null){
                while (R2 != null && R2.val >= x){
                    R2 = R2.next;
                    R1 = R1.next;
                }
                System.out.println("R2:"+R2.val);
                //swap
                if(L2 != null && R1 != null && L1 != null){
                    System.out.println("L2:"+L2.val+" R2:"+R2.val+"swap!");
                    ListNode Rnext = R2.next;
                    L1.next = R1.next;
                    R2.next = L2.next;
                    R1.next = L2;
                    L2.next = Rnext;
                }
                
                //next
                if(L1 != null){
                    L1 = L1.next;
                    L2 = L1.next;  
                }//else L2 = null;
   
            }
        }
        return dummy.next;
    }
}