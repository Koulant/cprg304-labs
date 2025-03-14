package exercise2;

public class MyDList<E> {
    public MyNode<E> head;
    public MyNode<E> tail;
    public int size;

    public MyDList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addFirst(E item) {
        MyNode<E> newNode = new MyNode<>(item);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        size++;
    }

    public void addLast(E item) {
        MyNode<E> newNode = new MyNode<>(item);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        E removedItem = head.item;
        head = head.next;

        if (head != null) {
            head.prev = null;
        } else {
            tail = null; // The list is now empty
        }

        size--;
        return removedItem;
    }

    public E removeLast() {
        if (isEmpty()) {
            return null;
        }

        E removedItem = tail.item;
        tail = tail.prev;

        if (tail != null) {
            tail.next = null;
        } else {
            head = null; // The list is now empty
        }

        size--;
        return removedItem;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static class MyNode<E> {
    	public E item;
    	public MyNode<E> prev;
    	public MyNode<E> next;

        public MyNode(E item) {
            this.item = item;
            this.prev = null;
            this.next = null;
        }
    }
}
