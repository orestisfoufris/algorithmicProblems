package ctci.chapter2;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Tests for custom double LinkedList
 */
public class LinkedListTest {

    private LinkedList<Integer> linkedList;

    @BeforeMethod
    public void setUp() {
        linkedList = new LinkedList<>();
    }

    @AfterMethod
    public void tear() {
        linkedList = null;
    }

    @Test
    public void testAddElement() {
        int[] expected = {1, 6, 7, 10, 4, 6};
        int[] actual = new int[expected.length];

        addElements(linkedList);

        for (int i = 0; i < linkedList.size(); ++i) {
            actual[i] = linkedList.get(i);
        }

        assertEquals(Arrays.toString(actual), Arrays.toString(expected));
        assertEquals(linkedList.getFirst().intValue(), 1);
        assertEquals(linkedList.getLast().intValue(), 6);
    }

    @Test
    public void testRemoveHead() {
        int[] expected = {6, 7, 10, 4, 6};
        int[] actual = new int[expected.length];

        addElements(linkedList);

        assertEquals(linkedList.size(), 6);
        boolean removed = linkedList.remove(new Integer(1));

        for (int i = 0; i < linkedList.size(); ++i) {
            actual[i] = linkedList.get(i);
        }

        assertTrue(removed);
        assertEquals(Arrays.toString(actual), Arrays.toString(expected));
        assertEquals(linkedList.getFirst().intValue(), 6);
        assertEquals(linkedList.getLast().intValue(), 6);
        assertEquals(linkedList.size(), 5);
    }

    @Test
    public void testAddIndex() {
        int[] expected = {1, 6, 7, 12, 10, 4, 6};
        int[] actual = new int[expected.length];

        addElements(linkedList);
        linkedList.add(3, 12);

        for (int i = 0; i < linkedList.size(); ++i) {
            actual[i] = linkedList.get(i);
        }

        assertEquals(Arrays.toString(actual), Arrays.toString(expected));

    }

    @Test
    public void testDuplicateRemoval() {
        int[] expected = {1, 8, 4, 2};
        int[] actual = new int[expected.length];

        linkedList.add(1);
        linkedList.add(8);
        linkedList.add(1);
        linkedList.add(4);
        linkedList.add(8);
        linkedList.add(2);

        linkedList.removeDuplicates();

        for (int i = 0; i < linkedList.size(); ++i) {
            actual[i] = linkedList.get(i);
        }

        assertEquals(Arrays.toString(actual), Arrays.toString(expected));
    }

    @Test
    public void testGetIndex() {
        addElements(linkedList);

        int first = linkedList.get(0);
        int second = linkedList.get(1);

        assertEquals(linkedList.size(), 6);
        assertEquals(first, 1);
        assertEquals(second, 6);
    }

    @Test
    public void testGetIndex2() {
        linkedList.add(1);
        linkedList.add(1);
        linkedList.add(8);
        linkedList.add(1);
        linkedList.add(4);
        linkedList.add(8);
        linkedList.add(8);
        linkedList.add(2);
        linkedList.add(2);

        int first = linkedList.get(0);
        int second = linkedList.get(1);
        int third = linkedList.get(2);

        assertEquals(linkedList.size(), 9);
        assertEquals(first, 1);
        assertEquals(second, 1);
        assertEquals(third, 8);
    }

    @Test // TODO
    public void testRemove() {

    }

    @Test
    public void testPartition() {
        linkedList.add(3);
        linkedList.add(9);
        linkedList.add(2);
        linkedList.add(5);
        linkedList.add(4);
        linkedList.add(7);
        linkedList.add(1);

        int[] actual = new int[linkedList.size()];

        LinkedList.Node<Integer> res = linkedList.partition(5);

        int i = 0;
        while (res != null) {
            actual[i] = res.data;
            res = res.next;
            i++;
        }

        System.out.println(Arrays.toString(actual));
    }

    @Test
    public void testPalindrome() {
        LinkedList<Character> characterLinkedList = new LinkedList<>();
        characterLinkedList.add('a');
        characterLinkedList.add('a');
        characterLinkedList.add('b');
        characterLinkedList.add('b');
        characterLinkedList.add('a');
        characterLinkedList.add('a');

        boolean actual = LinkedList.isPalindrome(characterLinkedList);
        assertEquals(actual, true);
    }

    @Test
    public void testPalindromeFalse() {
        LinkedList<Character> characterLinkedList = new LinkedList<>();
        characterLinkedList.add('a');
        characterLinkedList.add('a');
        characterLinkedList.add('b');
        characterLinkedList.add('b');
        characterLinkedList.add('c');
        characterLinkedList.add('a');
        characterLinkedList.add('a');

        boolean actual = LinkedList.isPalindrome(characterLinkedList);
        assertEquals(actual, false);
    }

    @Test
    public void testPalindromeTrue2() {
        LinkedList<Character> characterLinkedList = new LinkedList<>();
        characterLinkedList.add('a');
        characterLinkedList.add('b');
        characterLinkedList.add('a');

        boolean actual = LinkedList.isPalindrome(characterLinkedList);
        assertEquals(actual, true);
    }

    /**
     * You are given two numbers as linked lists, you should reverse them add the numbers
     * and return the sum in a linked list.
     */
    @Test
    public void reverseTwoListsAndAddTheNumbers() {
        LinkedList<Integer> firstList = new LinkedList<>();
        LinkedList<Integer> secondeList = new LinkedList<>();

        firstList.add(7);
        firstList.add(1);
        firstList.add(6);

        secondeList.add(5);
        secondeList.add(9);
        secondeList.add(2);

        linkedList.reverseLinkedList(firstList);
        linkedList.reverseLinkedList(secondeList);

        StringBuilder firstNumber = new StringBuilder();
        StringBuilder secondNumber = new StringBuilder();

        LinkedList.Node<Integer> firstHead = firstList.getHead();
        LinkedList.Node<Integer> secondHead = secondeList.getHead();

        while (firstHead != null) {
            firstNumber.append(String.valueOf(firstHead.data));
            firstHead = firstHead.next;
        }

        while (secondHead != null) {
            secondNumber.append(String.valueOf(secondHead.data));
            secondHead = secondHead.next;
        }

        int sum = Integer.valueOf(firstNumber.toString()) + Integer.valueOf(secondNumber.toString());
        assertEquals(sum, 912);

        LinkedList<Integer> sumList = new LinkedList<>();
        while (sum > 0) {
            int number = sum % 10;
            sumList.add(number);
            sum = sum / 10;
        }

        System.out.println(sumList);
    }

    @Test
    public void reverseTwoListsAndAddTheNumbers2() {
        LinkedList<Integer> firstList = new LinkedList<>();
        LinkedList<Integer> secondList = new LinkedList<>();

        firstList.add(7);
        firstList.add(1);
        firstList.add(6);
        firstList.add(2);

        secondList.add(5);
        secondList.add(9);
        secondList.add(2);

        linkedList.reverseLinkedList(firstList);
        linkedList.reverseLinkedList(secondList);

        StringBuilder firstNumber = new StringBuilder();
        StringBuilder secondNumber = new StringBuilder();

        LinkedList.Node<Integer> firstHead = firstList.getHead();
        LinkedList.Node<Integer> secondHead = secondList.getHead();

        while (firstHead != null) {
            firstNumber.append(String.valueOf(firstHead.data));
            firstHead = firstHead.next;
        }

        while (secondHead != null) {
            secondNumber.append(String.valueOf(secondHead.data));
            secondHead = secondHead.next;
        }

        int sum = Integer.valueOf(firstNumber.toString()) + Integer.valueOf(secondNumber.toString());
        assertEquals(sum, 2912);

        LinkedList<Integer> sumList = new LinkedList<>();
        while (sum > 0) {
            int number = sum % 10;
            sumList.add(number);
            sum = sum / 10;
        }

        System.out.println(sumList);
    }

    @Test
    public void testDuplicateRemoval2() {
        int[] expected = {1, 8, 4, 2};
        int[] actual = new int[expected.length];

        linkedList.add(1);
        linkedList.add(1);
        linkedList.add(8);
        linkedList.add(1);
        linkedList.add(4);
        linkedList.add(8);
        linkedList.add(8);
        linkedList.add(2);
        linkedList.add(2);

        linkedList.removeDuplicates();

        for (int i = 0; i < linkedList.size(); ++i) {
            actual[i] = linkedList.get(i);
        }

        assertEquals(Arrays.toString(actual), Arrays.toString(expected));
    }

    private void addElements(LinkedList<Integer> linkedList) {
        linkedList.add(1);
        linkedList.add(6);
        linkedList.add(7);
        linkedList.add(10);
        linkedList.add(4);
        linkedList.add(6);
    }
}
