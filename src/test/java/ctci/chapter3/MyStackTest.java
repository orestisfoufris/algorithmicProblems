package ctci.chapter3;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Tests for my stack
 */
public class MyStackTest {

    private MyStack myStack;

    @BeforeMethod
    public void setup() {
        myStack = new MyStack();
    }

    @Test
    public void testMinimumValue() {
        myStack.push(6);
        myStack.push(2);
        myStack.push(7);
        myStack.push(1);
        myStack.push(0);
        myStack.push(3);

        assertEquals(myStack.findMinimum().intValue(), 0);
        myStack.pop();

        assertEquals(myStack.findMinimum().intValue(), 0);
        myStack.pop();

        assertEquals(myStack.findMinimum().intValue(), 1);
        myStack.pop();

        assertEquals(myStack.findMinimum().intValue(), 2);

    }
}
