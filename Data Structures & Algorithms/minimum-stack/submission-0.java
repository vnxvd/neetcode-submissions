class MinStack {
    class Element {
        int val;
        int min;

        public Element(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    private Stack<Element> stack;
    
    public MinStack() {
        stack = new Stack();
    }
    
    public void push(int val) {
        if (stack.isEmpty()) {
            Element e = new Element(val, val);
            stack.push(e);
        } else {
            int min = Math.min(stack.peek().min, val);
            Element e = new Element(val, min);
            stack.push(e); 
        }
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        Element e = stack.peek();
        return e != null ? e.val : -1;
    }
    
    public int getMin() {
        Element e = stack.peek();
        return e != null ? e.min : -1;
    }
}
