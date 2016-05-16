package ctci.chapter3;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Stack;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

/**
 * Unit tests for SetOfStacks.java
 */
public class SetOfStacksTest {

    private SetOfStacks setOfStacks;

    @BeforeMethod
    public void setup() {
        setOfStacks = new SetOfStacks(3);
    }

    @Test
    public void testPush() {
        populateStack(setOfStacks, 4, 1, 3);

        Stack<Integer> expected = new Stack<>();
        expected.push(4);
        expected.push(1);
        expected.push(3);

        Stack<Integer> actualStack = setOfStacks.getStacks().get(0);
        assertEquals(setOfStacks.getStacks().size(), 1);
        assertEquals(actualStack, expected);
        assertEquals(actualStack.pop().intValue(), 3);
        assertEquals(actualStack.pop().intValue(), 1);
        assertEquals(actualStack.pop().intValue(), 4);
        assertTrue(actualStack.isEmpty());
    }

    @Test
    public void testPushCreatesTwoInternalStacks() {
        populateStack(setOfStacks, 4, 2, 3, 5, 6, 7);

        assertEquals(setOfStacks.getStacks().size(), 2);
    }

    @Test
    public void testCustomPop() {
        populateStack(setOfStacks, 4, 2, 3, 5, 6, 7);

        assertEquals(setOfStacks.getStacks().size(), 2);

        Integer element1 = setOfStacks.pop();
        Integer element2 = setOfStacks.pop();

        assertEquals(setOfStacks.getStacks().size(), 2);

        Integer element3 = setOfStacks.pop();
        assertEquals(setOfStacks.getStacks().size(), 1);

        assertEquals(element1.intValue(), 7);
        assertEquals(element2.intValue(), 6);
        assertEquals(element3.intValue(), 5);

        Integer element4 = setOfStacks.pop();
        assertEquals(element4.intValue(), 3);
        assertEquals(setOfStacks.getStacks().get(0).size(), 2);
    }

    @Test
    public void testCustomPopFromSpecificSubStack() {
        populateStack(setOfStacks, 4, 2, 3, 5, 6, 7, 43, 45, 46);

        assertEquals(setOfStacks.getStacks().size(), 3);

        assertEquals(setOfStacks.pop(1).intValue(), 7);
        assertEquals(setOfStacks.pop(1).intValue(), 6);
        assertEquals(setOfStacks.pop(1).intValue(), 5);

        assertEquals(setOfStacks.getStacks().size(), 2);

        assertEquals(setOfStacks.pop(1).intValue(), 46);

        assertEquals(setOfStacks.pop(0).intValue(), 3);
        assertEquals(setOfStacks.pop(0).intValue(), 2);
        assertEquals(setOfStacks.pop(0).intValue(), 4);

        assertEquals(setOfStacks.getStacks().size(), 1);

        assertEquals(setOfStacks.pop().intValue(), 45);
        assertEquals(setOfStacks.pop().intValue(), 43);
        assertEquals(setOfStacks.pop(), null);

        populateStack(setOfStacks, 65);
        assertEquals(setOfStacks.getStacks().size(), 1);
        assertEquals(setOfStacks.pop(0).intValue(), 65);

        populateStack(setOfStacks, 4, 2, 3);
        assertNull(setOfStacks.pop(89));
    }

    /**
     *
     * @param stack to be populated
     * @param values will be pushed to stack
     */
    private void populateStack(SetOfStacks stack, Integer... values) {
        for (Integer element : values) {
            stack.push(element);
        }
    }

}
