package DataStructures;

public class Stack<Tp> {
    private Object[] elements;
    private int top_distance;

    public Stack() {
        elements = new Object[8];
        top_distance = 0;
    }

    public void push(Tp item) {
        if (top_distance == elements.length) {
            resize_upward();
        }
        elements[top_distance++] = item;
    }

    public void pop() {
        top_distance--;
    }

    @SuppressWarnings("unchecked")
    public Tp top() {
        return (Tp)elements[top_distance];
    }

    private void resize_upward() {
        Object[] temp = elements;
        elements = new Object[elements.length + elements.length/2];
        System.arraycopy(temp, 0, elements, 0, top_distance);
    }

}
