package org.xander.katas;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MyLinkedListTest {
    MyLinkedList myLinkedList;

    @Before
    public void setUp() {
        myLinkedList = new MyLinkedList();
    }

    @Test
    public void basic() {
        assertNotNull(myLinkedList);
    }

    @Test
    public void head() {
        MyLinkedList.Node node = new MyLinkedList.Node(5);
        myLinkedList.addToHead(node);
        assertEquals(5, myLinkedList.getHead().value);
        assertEquals(1, myLinkedList.getSize());
    }

    @Test
    public void addSecondHead() {
        MyLinkedList.Node node1 = new MyLinkedList.Node(5);
        MyLinkedList.Node node2 = new MyLinkedList.Node(15);
        myLinkedList.addToHead(node1);
        myLinkedList.addToHead(node2);
        assertEquals(15, myLinkedList.getHead().value);
        assertEquals(5, myLinkedList.getHead().next.value);
        assertEquals(2, myLinkedList.getSize());
    }

    @Test
    public void addThirdHead() {
        MyLinkedList.Node node1 = new MyLinkedList.Node(5);
        MyLinkedList.Node node2 = new MyLinkedList.Node(15);
        MyLinkedList.Node node3 = new MyLinkedList.Node(25);
        myLinkedList.addToHead(node1);
        myLinkedList.addToHead(node2);
        myLinkedList.addToHead(node3);
        assertEquals(25, myLinkedList.getHead().value);
        assertEquals(15, myLinkedList.getHead().next.value);
        assertEquals(5, myLinkedList.getHead().next.next.value);

        assertEquals(5, myLinkedList.getTail().value);

        assertEquals(3, myLinkedList.getSize());
    }

    @Test
    public void addToTail() {
        MyLinkedList.Node node1 = new MyLinkedList.Node(5);
        MyLinkedList.Node node2 = new MyLinkedList.Node(15);
        MyLinkedList.Node node3 = new MyLinkedList.Node(25);
        myLinkedList.addToTail(node1);
        myLinkedList.addToTail(node2);
        myLinkedList.addToTail(node3);
        assertEquals(25, myLinkedList.getTail().value);
        assertEquals(15, myLinkedList.getTail().prev.value);
        assertEquals(5, myLinkedList.getTail().prev.prev.value);

        assertEquals(5, myLinkedList.getHead().value);

        assertEquals(3, myLinkedList.getSize());
    }

    @Test
    public void getAtIndex() {
        MyLinkedList.Node node1 = new MyLinkedList.Node(5);
        MyLinkedList.Node node2 = new MyLinkedList.Node(15);
        MyLinkedList.Node node3 = new MyLinkedList.Node(25);
        myLinkedList.addToHead(node1);
        myLinkedList.addToHead(node2);
        myLinkedList.addToHead(node3);

        int index1 = 1;
        int index2 = 2;
        int index3 = 3;

        assertEquals(25, myLinkedList.getAt(index1).value);
        assertEquals(15, myLinkedList.getAt(index2).value);
        assertEquals(5, myLinkedList.getAt(index3).value);
    }

}
