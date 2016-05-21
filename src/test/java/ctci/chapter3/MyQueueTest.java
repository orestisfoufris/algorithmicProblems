package ctci.chapter3;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * unit tests for MyQueue
 */
public class MyQueueTest {

    private MyQueue myQueue; // system under test

    @BeforeMethod
    public void setup() {
        myQueue = new MyQueue();
    }

    @Test
    public void testDeQueueOne() {
        myQueue.enQueue(8);
        myQueue.enQueue(7);
        myQueue.enQueue(6);
        myQueue.enQueue(5);
        myQueue.enQueue(4);

        assertEquals(myQueue.size(), 5);
        assertEquals(myQueue.deQueue().intValue(), 8);
        assertEquals(myQueue.deQueue().intValue(), 7);
        assertEquals(myQueue.deQueue().intValue(), 6);
        assertEquals(myQueue.deQueue().intValue(), 5);
        assertEquals(myQueue.deQueue().intValue(), 4);
        assertEquals(myQueue.deQueue(), null);
    }

    @Test
    public void testDeQueueTwo() {
        myQueue.enQueue(8);
        myQueue.enQueue(7);
        myQueue.enQueue(6);

        assertEquals(myQueue.size(), 3);
        assertEquals(myQueue.deQueue().intValue(), 8);
        assertEquals(myQueue.deQueue().intValue(), 7);

        myQueue.enQueue(5);

        assertEquals(myQueue.deQueue().intValue(),6);
        assertEquals(myQueue.deQueue().intValue(),5);
    }
}
