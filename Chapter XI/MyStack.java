import java.util.*;

public class MyStack {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        stack.pop();
        System.out.println(stack.peek());
        System.out.println("Size: " + stack.getSize());
    }
}

class Stack {
    private ArrayList<Object> list = new ArrayList<>();

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public int getSize() {
        return this.list.size();
    }

    public Object peek() {
        return this.list.get(getSize() - 1);
    }

    public Object pop() {
        int index = getSize() - 1;
        Object o = list.get(index);
        this.list.remove(index);
        return o;
    }

    public void push(Object o) {
        this.list.add(o);
    }
}
