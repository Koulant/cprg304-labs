package exercise1;

import java.util.ArrayList;	
import java.util.Iterator;

public class MyAList<E> implements Iterable<E> {
    private ArrayList<E> elements;

    public MyAList() {
        elements = new ArrayList<>();
    }

    public void add(E item) {
        elements.add(item);
    }

    public void addAll(MyAList<E> items) {
        elements.addAll(items.elements);
    }

    public E get(int index) {
        if (index >= 0 && index < elements.size()) {
            return elements.get(index);
        } else {
        	throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    public void remove(int index) {
        if (index >= 0 && index < elements.size()) {
            elements.remove(index);
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    public void set(int index, E item) {
        if (index >= 0 && index < elements.size()) {
            elements.set(index, item);
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    public int size() {
        return elements.size();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public Object[] toArray() {
        return elements.toArray();
    }

    public void clear() {
        elements.clear();
    }

    public Iterator<E> iterator() {
        return elements.iterator();
    }

}
