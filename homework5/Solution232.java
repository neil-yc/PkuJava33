import java.util.*;

class Solution232 {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> temp = new Stack<>();

    // Push element x to the back of queue.
    public void push(int x) {
        stack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(!temp.isEmpty()) temp.pop();
        else {
            while(!stack.isEmpty()) temp.push(stack.pop());
            temp.pop();
        }
    }

    // Get the front element.
    public int peek() {
        if(!temp.isEmpty()) return temp.peek();
        else {
            while(!stack.isEmpty()) temp.push(stack.pop());
            return temp.peek();
        }
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.empty();
    }
}
