public class Stack<T> {
    private T[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public Stack(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public void push(T element) {
        if (size == data.length) {
            System.out.println("Стек переполнен");
            return;
        }
        data[size++] = element;
    }

    public T pop() {
        if (size == 0) {
            System.out.println("Стек пуст");
            return null;
        }
        T element = data[--size];
        data[size] = null;
        return element;
    }

    public T peek() {
        if (size == 0) return null;
        return data[size - 1];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
}
