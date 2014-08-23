package org.xander.katas;

public class MyLinkedList {
    private Node tail;
    private Node head;
    private int size = 0;

    public void addToHead(Node first) {
        Node oldHead = head;
        Node newHead = new Node(null, first.value, oldHead);
        head = newHead;

        if (oldHead == null) {
            tail = newHead;
        } else {
            oldHead.prev = newHead;
        }
        size++;
    }

    public void addToTail(Node last) {
        Node oldTail = tail;
        Node newTail = new Node(oldTail, last.value, null);
        tail = newTail;

        if (oldTail == null) {
            head = newTail;
        } else {
            oldTail.next = newTail;
        }
        size++;
    }

    public Node getTail() {
        return tail;
    }

    public Node getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }

    public Node getAt(int index) {
        Node head = getHead();

        for (int i = 0; i < index - 1; i++) {
            head = head.next;
        }

        return head;
    }

    public void addAtIndex(int index, Node nodeForIndex) {
        if (index >= 0 && index - size > 1) {
            throw new IndexOutOfBoundsException("it is not possible to insert to the non-existing index");
        }

        if (index - size == 1) {
            addToTail(nodeForIndex);
        } else if (index == 0) {
            addToHead(nodeForIndex);
        } else {
            Node currentAtIndex = getAt(index);
            Node theOneBeforeAtIndex = currentAtIndex.prev;

            Node newElement = new Node(theOneBeforeAtIndex, nodeForIndex.value, currentAtIndex);

            if (theOneBeforeAtIndex != null) {
                theOneBeforeAtIndex.next = newElement;
            }

            if (index == size) {
                if (head == tail) {
                    head = newElement;
                }
            }
            currentAtIndex.prev = newElement;
            size++;
        }
    }

    public static class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this(null, value, null);
        }

        Node(Node prev, int value, Node next) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
