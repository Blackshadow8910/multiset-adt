public class LinkedListMultiSet<T> implements MultiSet<T> {
    private Node<T> front;
    private int size = 0;

    @Override
    public boolean add(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = front;
        front = newNode;
        size++;
        return true;
    }

    @Override
    public void remove(T value) {
        Node<T> cur = front;
        Node<T> prev = null;
        while (cur != null) {
            if (cur.item == value) {
                size--;
                if (prev != null) {
                    prev.next = cur.next;
                } else {
                    front = cur.next;
                }
            }
            prev = cur;
            cur = cur.next;
        }
    }

    @Override
    public boolean contains(T value) {
        Node<T> cur = front;
        while (cur != null) {
            if (cur.item == value) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public int count(T value) {
        int n = 0;
        Node<T> cur = front;
        while (cur != null) {
            if (cur.item == value) {
                n++;
            }
            cur = cur.next;
        }
        return n;
    }

    @Override
    public int size() {
        return size;
    }
}