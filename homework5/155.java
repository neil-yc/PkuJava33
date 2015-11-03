class MinStack {
    
//     private Stack<Integer> stack = new Stack<>();
// 	private Stack<Integer> minStack = new Stack<>();
	
// 	public void push(int x) {
//         stack.push(x);
//         if(minStack.size() == 0){
//         	minStack.push(x);
//         }else if(x <= minStack.peek()){
//         // 	minStack.pop();
//         	minStack.push(x);
//         }
//     }

//     public void pop() {
//         stack.pop();
//         if(stack.peek()==minStack.peek()){
//         	minStack.pop();
//         }
//     }

//     public int top() {
//         return stack.peek();
//     }

//     public int getMin() 
class Node{
		int value;
		int min;
	}
	Node node;
	private Stack<Node> stack = new Stack<>();
//	private Stack<Integer> minStack = new Stack<>();
	
	public void push(int x) {
		node = new Node();
		if(stack.empty() || x < stack.peek().min){
			node.value = x;
			node.min = x;
		}else{
			node.value = x;
			//在min中保留当前最小值
			node.min = stack.peek().min;
		}
		
        stack.push(node);
        
    }

    public void pop() {
        stack.pop();
        
    }

    public int top() {
    	if(!stack.empty()){
    		return stack.peek().value;
    	}
        return -1;
    }

    public int getMin() {
    	if(!stack.empty()){
    		return stack.peek().min;
    	}
       return -1;
    }
}
