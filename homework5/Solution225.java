class Solution225 {
    Queue<Integer> queue = new LinkedList<Integer>();
    Queue<Integer> temp = new LinkedList<Integer>();
    
    public void push(int x) {
        queue.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        while(queue.size()>1) temp.offer(queue.poll());
        queue.poll();
        Queue<Integer> q = queue;
        queue = temp;
        temp = q;
    }

    // Get the top element.
    public int top() {
        while(queue.size()>1) temp.offer(queue.poll());
        int x = queue.poll();
        temp.offer(x);
        Queue<Integer> q = queue;
        queue = temp;
        temp = q;
        return x;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}