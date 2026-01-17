class MyQueue {
    private Stack<Integer> prim;
    private Stack<Integer> temp;

    public MyQueue() {
        prim = new Stack<>();
        temp = new Stack<>();
    }

    public void push(int x) {
        while (!prim.isEmpty()) {
            temp.push(prim.pop());
        }
        prim.push(x);
        while (!temp.isEmpty()) {
            prim.push(temp.pop());
        }
    }

    public int pop() {
        return prim.pop();
    }

    public int peek() {
        return prim.peek();
    }

    public boolean empty() {
        return prim.empty();
    }

}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */