public class Exercise11_10 {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push("First element");
        stack.push("Second element");
        stack.push("Third element");
        stack.push("Fourth element");
        stack.push("Fifth element");

        int size = stack.size();
        for (int i = 0; i < size; i++) System.out.println(stack.pop());
    }
}

class MyStack extends java.util.ArrayList<Object> {
    public MyStack() {
    }

    public Object peek() {
        return this.get(this.size() - 1);
    }

    public Object pop() {
        int index = this.size() - 1;
        Object o = this.get(index);
        this.remove(index);
        return o;
    }

    public void push(Object o) {
        this.add(o);
    }
}
