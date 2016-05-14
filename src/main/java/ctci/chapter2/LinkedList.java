package ctci.chapter2;

import java.util.*;

/**
 * A custom doubly LinkedList. Do not use for anything serious.
 */
public class LinkedList<T extends Comparable<T>> {
    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public boolean contains(Object o) {
        boolean found = false;
        Node<T> first = head;

        while (first != null) {
            found = first.data.equals(o);
            if (found) {
                break;
            }

            first = first.next;
        }
        return found;
    }

    /**
     *
     * @param t the new element to be added at the end of the list
     *          NOTE: null items are not allowed
     *
     * @return true if added
     */
    public boolean add(T t) {

        if (t == null) {
            return false;
        }
        // if head is null add as head
        if (head == null) {
            head = new Node<>(t, null, null);
            tail = head;
        } else {
            Node<T> newTail = new Node<>(t, tail, null);
            tail.next = newTail;
            tail = newTail;
        }
        size++;
        return true;
    }

    /**
     * Write a code to remove duplicates from an unsorted linked list.
     * FOLLOW UP: How would you solve this problem if a temporary buffer
     * is not allowed?
     */
    public void removeDuplicates() {
        Node<T> first = head;
        while (first != null) {
            Node<T> second = first;
            while (second.next != null) {
                if (first.data.equals(second.next.data)) {
                    second.next = second.next.next;
                    if (second.next != null) {
                        tail = second.next;
                        second.next.previous = second;
                    }
                    size--;
                } else {
                    second = second.next;
                }
            }
            first = first.next;
        }
    }

    /**
     * 2.4 Write code to partition a linked list around a value x, such as all
     * nodes less than x come before all nodes greater than or equal to x.
     *
     * Do not use the previous link
     * TODO: sort out the previous links
     */
    Node<T> partition(T value) {
        Node<T> node = head;
        Node<T> h = node;
        Node<T> t = node;

        while (node != null) {
            Node<T> next = node.next;
            if (node.data.compareTo(value) == -1) {
                // move to head
                node.next = h;
                h = node;
            } else if (node.data.compareTo(value) >= 0) {
                // move to tail
                t.next = node;
                t = node;
            }

            node = next;
        }
        t.next = null;

        return h;
    }
    /**
     * 2.7 implement a function to check if a linked list is a palindrome
     * DO NOT use the previous links
     */
    static <E extends Comparable<E>> boolean isPalindrome(LinkedList<E> list) {
        Deque<E> stack = new ArrayDeque<>();
        double middle = Math.ceil(list.size() / 2.0);
        Node<E> start = list.getHead();

        int count = 0;
        while (middle != count) {
            start = start.next;
            count++;
        }

        while (start != null) {
            stack.push(start.data);
            start = start.next;
        }

        Node<E> head = list.getHead();
        while (stack.peek() != null && head != null) {
            if (stack.pop() != head.data) {
                return false;
            }
            head = head.next;
        }

        return true;
    }


    /**
     * reverse a linked list
     * NOTE: do not use previous links!
     *
     * @param list to be reversed
     */
    void reverseLinkedList(LinkedList<T> list) {
        Node<T> current = list.getHead();

        while (current != null) {
            Node<T> previous = current.previous;
            Node<T> next = current.next;
            current.next = previous;
            current = next;
        }

        Node<T> prevHead = list.getHead();
        list.setHead(list.getTail());
        list.setTail(prevHead);
    }
    /**
     *
     * @param o item to be removed. NOTE: removes the first occurrence only
     * @return true if item was found and removed otherwise false.
     */
    public boolean remove(Object o) {
        if (o == null) {
            return false;
        }

        Node<T> first = head;
        boolean removed = false;

        while (first != null) {
            if (first.data.equals(o)) {
                Node<T> prev = first.previous;
                Node<T> next = first.next;

                if (first == head) {
                    assert first.previous == null;
                    next.previous = null;
                    head = next;
                    removed = true;

                } else if(first == tail) {
                    assert first.next == null;
                    prev.next = null;
                    tail = prev;
                    removed = true;

                } else {
                    prev.next = next;
                    next.previous = prev;
                    removed = true;
                }
            }

            first = first.next;
        }

        if (removed) {
            size--;
        }

        return removed;
    }

    public T get(int index) {
        Node<T> node = head;
        int i = 0;
        while(node != null) {
            if (i == index) {
                return node.data;
            }
            i++;
            node = node.next;
        }

        return null;
    }

    public T set(int index, T element) {
        return null;
    }

    public void add(int index, T element) {
        Node<T> newNode = new Node<>(element, null, null);
        if (index == 0) {
            newNode.next = head;
            head.previous = newNode;
        }

        if (index == size) {
            add(element);
        }

        Node<T> first = head;
        int i = 0;
        while (i != index) {
            first = first.next;
            i++;
        }

        Node<T> prev = first.previous;

        newNode.previous = prev.next;
        prev.next = newNode;
        first.previous = newNode;
        newNode.next = first;

        size++;
    }

    public T remove(int index) {
        int i = 0;
        Node<T> first = head;
        while (i != index && first != null) {
            first = first.next;
            i++;
        }

        if (i != index) {
            return null;
        }

        if (first.equals(head)) {
            removeHead();
        } else if (first.equals(tail)) {
            removeTail();
        } else {
            Node<T> prev = first.previous;
            Node<T> next = first.next;

            if (next != null) {
                next.previous = prev;
            }

            if (prev != null) {
                prev.next = next;
            }
        }

        size--;

        return first.data;
    }

    private void removeHead() {
        Node<T> next = head.next;
        next.previous = null;
        head = next;
    }

    private void removeTail() {
        if (head != null) {
            Node<T> first = head;

            while (first.next != null) {
                first = first.next;
            }

            first.previous.next = null;
            tail = first.previous;
        }
    }

    public T getFirst() {
        return head.data;
    }

    public Node<T> getHead() {
        return head;
    }

    public T getLast() {
        return tail.data;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }

    public Node<T> getTail() {
        return tail;
    }

    public static class Node<T extends Comparable<T>>  {
        T data;
        Node<T> previous;
        Node<T> next;

        Node(T data, Node<T> previous, Node<T> next) {
            this.data = data;
            this.previous = previous;
            this.next = next;
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> node = getHead();
        while (node != null) {
            sb.append(node.data).append("->");
            node = node.next;
        }

        return "LinkedList= " + sb.append("NULL").toString();
    }
}
