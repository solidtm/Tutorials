package assignments.assignment3.storage;

import java.util.Iterator;

public class BinImpl<E> implements Bin<E> {
    private Node<E> head;
    private int size;

    public BinImpl(){
        head = null;
        size = 0;
    }

    @Override
    public E grab() {
        if(head == null) throw new DisorganizationException("Bin is empty");

        E item = head.data;
        head = head.next;
        size--;

        return item;
    }

    @Override
    public void add(E entry) {
        Node<E> newNode = new Node<>(entry);
        newNode.next = head;
        head = newNode;
        size++;
    }

    @Override
    public boolean hasStuff() { return head != null; }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    public int getSize(){
        return size;
    }
}
