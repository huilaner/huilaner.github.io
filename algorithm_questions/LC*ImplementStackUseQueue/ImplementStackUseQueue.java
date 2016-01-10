/**
  * difficulty: easy
  * url: https://leetcode.com/problems/implement-stack-using-queues/
  * tag: Stack, Design
  * time complexity for push: O(n), space: O(n)
*/
class MyStack {
    Queue<Integer> q = new LinkedList<Integer>();
    Queue<Integer> tmp = new LinkedList<Integer>();
    
    // Push element x onto stack.
    public void push(int x) {
       this.tmp.add(x); 
       while(!q.isEmpty()){
           int n = this.q.remove();
           this.tmp.add(n);
       }
       this.q = this.tmp;
       this.tmp = new LinkedList<Integer>();
       
    }

    // Removes the element on top of the stack.
    public void pop() {
        this.q.remove();
    }

    // Get the top element.
    public int top() {
        return this.q.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();
    }
}