package org.xander.katas;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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
        prepareListOfTwoNodesFromHeadSide();

        assertEquals(15, myLinkedList.getHead().value);
        assertEquals(5, myLinkedList.getHead().next.value);
        assertEquals(2, myLinkedList.getSize());
    }

    @Test
    public void addSecondTail() {
        prepareListOfTwoNodesFromTailSide();

        assertEquals(15, myLinkedList.getTail().value);
        assertEquals(5, myLinkedList.getTail().prev.value);
        assertEquals(2, myLinkedList.getSize());
    }

    private void prepareListOfTwoNodesFromHeadSide() {
        MyLinkedList.Node node1 = new MyLinkedList.Node(5);
        MyLinkedList.Node node2 = new MyLinkedList.Node(15);
        myLinkedList.addToHead(node1);
        myLinkedList.addToHead(node2);
    }

    private void prepareListOfTwoNodesFromTailSide() {
        MyLinkedList.Node node1 = new MyLinkedList.Node(5);
        MyLinkedList.Node node2 = new MyLinkedList.Node(15);
        myLinkedList.addToTail(node1);
        myLinkedList.addToTail(node2);
    }

    @Test
    public void addThirdHead() {
        prepareListOfThreeNodesFromHeadSide();

        assertEquals(25, myLinkedList.getHead().value);
        assertEquals(15, myLinkedList.getHead().next.value);
        assertEquals(5, myLinkedList.getHead().next.next.value);
        assertEquals(5, myLinkedList.getTail().value);
        assertEquals(3, myLinkedList.getSize());
    }

    @Test
    public void addThirdTail() {
        prepareListOfThreeNodesFromTailSide();

        assertEquals(25, myLinkedList.getTail().value);
        assertEquals(15, myLinkedList.getTail().prev.value);
        assertEquals(5, myLinkedList.getTail().prev.prev.value);
        assertEquals(5, myLinkedList.getHead().value);
        assertEquals(3, myLinkedList.getSize());
    }

    @Test
    public void addToTail() {
        prepareListOfThreeNodesFromHeadSide();

        assertEquals(5, myLinkedList.getTail().value);
        assertEquals(15, myLinkedList.getTail().prev.value);
        assertEquals(25, myLinkedList.getTail().prev.prev.value);
        assertEquals(25, myLinkedList.getHead().value);
        assertEquals(3, myLinkedList.getSize());
    }

    @Test
    public void getAtIndex() {
        prepareListOfThreeNodesFromHeadSide();

        assertEquals(25, myLinkedList.getAt(1).value);
        assertEquals(15, myLinkedList.getAt(2).value);
        assertEquals(5, myLinkedList.getAt(3).value);
        assertEquals(3, myLinkedList.getSize());
    }

    private void prepareListOfThreeNodesFromHeadSide() {
        MyLinkedList.Node node1 = new MyLinkedList.Node(5);
        MyLinkedList.Node node2 = new MyLinkedList.Node(15);
        MyLinkedList.Node node3 = new MyLinkedList.Node(25);
        myLinkedList.addToHead(node1);
        myLinkedList.addToHead(node2);
        myLinkedList.addToHead(node3);
    }

    private void prepareListOfThreeNodesFromTailSide() {
        MyLinkedList.Node node1 = new MyLinkedList.Node(5);
        MyLinkedList.Node node2 = new MyLinkedList.Node(15);
        MyLinkedList.Node node3 = new MyLinkedList.Node(25);
        myLinkedList.addToTail(node1);
        myLinkedList.addToTail(node2);
        myLinkedList.addToTail(node3);
    }

    @Test
    public void addAtIndex() {
        prepareListOfThreeNodesFromHeadSide();

        MyLinkedList.Node nodeForIndex = new MyLinkedList.Node(100);

        myLinkedList.addAtIndex(2, nodeForIndex);

        assertEquals(100, myLinkedList.getAt(2).value);
        assertEquals(25, myLinkedList.getAt(1).value);
        assertEquals(15, myLinkedList.getAt(3).value);
        assertEquals(5, myLinkedList.getAt(4).value);
        assertEquals(4, myLinkedList.getSize());
    }

    @Test
    public void addAtIndexCornerCaseAtHead() {
        MyLinkedList.Node node1 = new MyLinkedList.Node(5);
        myLinkedList.addToHead(node1);

        MyLinkedList.Node nodeForIndex = new MyLinkedList.Node(100);
        int index = 1;

        myLinkedList.addAtIndex(index, nodeForIndex);

        assertEquals(100, myLinkedList.getAt(index).value);
        assertEquals(5, myLinkedList.getAt(2).value);
    }

    @Test
    public void addAtIndexCornerCaseAtTail() {
        prepareListOfTwoNodesFromHeadSide();

        MyLinkedList.Node nodeForIndex = new MyLinkedList.Node(100);

        myLinkedList.addAtIndex(2, nodeForIndex);

        assertEquals(100, myLinkedList.getAt(2).value);
        assertEquals(15, myLinkedList.getAt(1).value);
        assertEquals(5, myLinkedList.getAt(3).value);
        assertEquals(3, myLinkedList.getSize());
    }

    @Test
    public void addAtZeroPositionUsingNonExistingIndex() {
        myLinkedList.addToHead(new MyLinkedList.Node(5));

        myLinkedList.addAtIndex(0, new MyLinkedList.Node(100));

        assertEquals(100, myLinkedList.getAt(1).value);
        assertEquals(5, myLinkedList.getAt(2).value);
        assertEquals(2, myLinkedList.getSize());
    }

    @Test
    public void addAtLastPlusOnePositionUsingNonExistingIndex() {
        myLinkedList.addToHead(new MyLinkedList.Node(5));

        myLinkedList.addAtIndex(2, new MyLinkedList.Node(100));

        assertEquals(5, myLinkedList.getAt(1).value);
        assertEquals(100, myLinkedList.getAt(2).value);
        assertEquals(2, myLinkedList.getSize());
    }

    @Test
    public void addToListWithoutNodes() {
        myLinkedList.addAtIndex(1, new MyLinkedList.Node(100));

        checkOneElementSizeList();
        assertEquals(1, myLinkedList.getSize());
    }

    @Test
    public void addToListWithoutNodesUsingZeroIndex() {
        myLinkedList.addAtIndex(0, new MyLinkedList.Node(100));

        checkOneElementSizeList();
        assertEquals(1, myLinkedList.getSize());
    }

    private void checkOneElementSizeList() {
        assertEquals(100, myLinkedList.getAt(1).value);
        assertEquals(100, myLinkedList.getHead().value);
        assertEquals(100, myLinkedList.getTail().value);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addUsingNonExistingIndex() {
        myLinkedList.addToHead(new MyLinkedList.Node(5));
        myLinkedList.addAtIndex(123, new MyLinkedList.Node(100));
    }

    @Test
    public void removeElementAtIndexOneFromOneElementList() {
        MyLinkedList.Node node1 = new MyLinkedList.Node(25);
        myLinkedList.addToTail(node1);

        int index = 1;

        myLinkedList.removeAtIndex(index);

        assertNull(myLinkedList.getHead());
        assertNull(myLinkedList.getTail());
        assertEquals(0, myLinkedList.getSize());
    }

    @Test
    public void removeElementAtIndexOneFromTwoElementsList() {
        prepareListOfTwoNodesFromHeadSide();

        int index = 1;

        myLinkedList.removeAtIndex(index);

        assertEquals(5, myLinkedList.getHead().value);
        assertNull(myLinkedList.getHead().next);
        assertNull(myLinkedList.getHead().prev);
        assertEquals(5, myLinkedList.getTail().value);
        assertNull(myLinkedList.getTail().next);
        assertNull(myLinkedList.getTail().prev);
        assertEquals(1, myLinkedList.getSize());
    }

    @Test
    public void removeElementAtIndexTwoFromTwoElementsList() {
        prepareListOfTwoNodesFromHeadSide();

        int index = 2;

        myLinkedList.removeAtIndex(index);

        assertEquals(15, myLinkedList.getHead().value);
        assertNull(myLinkedList.getHead().next);
        assertNull(myLinkedList.getHead().prev);
        assertEquals(15, myLinkedList.getTail().value);
        assertNull(myLinkedList.getTail().next);
        assertNull(myLinkedList.getTail().prev);
        assertEquals(1, myLinkedList.getSize());
    }

    @Test
    public void removeElementAtIndexInTheMiddleFromThreeElementsList() {
        prepareListOfThreeNodesFromHeadSide();

        int index = 2;

        myLinkedList.removeAtIndex(index);

        assertEquals(25, myLinkedList.getHead().value);
        assertEquals(5, myLinkedList.getHead().next.value);
        assertEquals(5, myLinkedList.getTail().value);
        assertEquals(25, myLinkedList.getTail().prev.value);
        assertEquals(2, myLinkedList.getSize());
    }

    @Test
    public void removeElementAtIndexInTheBeginningFromThreeElementsList() {
        prepareListOfThreeNodesFromHeadSide();

        int index = 1;

        myLinkedList.removeAtIndex(index);

        assertEquals(15, myLinkedList.getHead().value);
        assertEquals(5, myLinkedList.getHead().next.value);
        assertEquals(5, myLinkedList.getTail().value);
        assertEquals(15, myLinkedList.getTail().prev.value);
        assertEquals(15, myLinkedList.getAt(1).value);
        assertEquals(5, myLinkedList.getAt(2).value);
        assertEquals(2, myLinkedList.getSize());
    }

    @Test
    public void removeElementAtIndexInTheEndFromThreeElementsList() {
        prepareListOfThreeNodesFromHeadSide();

        int index = 3;

        myLinkedList.removeAtIndex(index);

        assertEquals(25, myLinkedList.getHead().value);
        assertEquals(15, myLinkedList.getHead().next.value);
        assertEquals(15, myLinkedList.getTail().value);
        assertEquals(25, myLinkedList.getTail().prev.value);
        assertEquals(2, myLinkedList.getSize());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeElementAtNonExistingIndex() {
        myLinkedList.removeAtIndex(myLinkedList.getSize() + 10);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeElementAtNonExistingZeroIndex() {
        myLinkedList.removeAtIndex(0);
    }
}
