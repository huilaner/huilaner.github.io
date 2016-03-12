### 解题报告
### 题目
remove 从List末尾往前数第N个的node
http://www.lintcode.com/en/problem/remove-nth-node-from-end-of-list/#

### 算法，数据结构
LinkedList

### 收获


### bug
- 审题要看清楚 from end
- edge cases: n >= linkedlist size

```java
/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: The head of linked list.
     * test: [],1; [1],0; 
     */
    ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prevDel = dummyHead;
        
        for(int i = 0; i < n; i++){
            if(head == null){
                return null;
            }
            head = head.next;
        }
        while(head != null){
            head = head.next;
            prevDel = prevDel.next;
        }
        if(prevDel.next != null){
            prevDel.next = prevDel.next.next;
        }
        
        return dummyHead.next;
    }
}

```
