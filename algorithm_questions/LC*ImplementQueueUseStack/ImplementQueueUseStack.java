/**
  * difficulty: easy
  * url: https://leetcode.com/problems/implement-queue-using-stacks/
  * tag: stack, design
*/
class MyQueue {
    public Stack<Integer> stack = new Stack<>();
    public Stack<Integer> tmpStack = new Stack<>();
    
    // Push element x to the back of queue.
    public void push(int x) {
        while(!this.stack.isEmpty()){
            this.tmpStack.push(this.stack.pop());
        }
        stack.push(x);
        while(!this.tmpStack.isEmpty()){
            this.stack.push(this.tmpStack.pop());
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        this.stack.pop();
    }

    // Get the front element.
    public int peek() {
        return this.stack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return this.stack.isEmpty();
    }
}
