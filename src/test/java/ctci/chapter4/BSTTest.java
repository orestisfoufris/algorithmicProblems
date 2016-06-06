package ctci.chapter4;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class BSTTest {

    private BST bst;

    @BeforeMethod
    public void setup() {
        bst = new BST();
    }

    @Test
    public void testInsert() {
        bst.add(6);
        bst.add(5);
        bst.add(4);
        bst.add(3);

        bst.inOrderTreeWalk();
    }

    @Test
    public void testFindSuccessor() {
        bst.add(6);
        bst.add(5);
        bst.add(7);
        bst.add(2);
        bst.add(5);
        bst.add(8);

        Integer successor = bst.findSuccessor(2);
        assertEquals(successor.intValue(), 5);
    }

    @Test
    public void testIfBalanced_Unbalanced1() {
        bst.add(6);
        bst.add(5);
        bst.add(4);
        bst.add(3);

        assertEquals(BST.isBalanced(bst.getRoot()), false);
    }

    @Test
    public void testIfBalanced_Unbalanced2() {
        bst.add(6);
        bst.add(5);
        bst.add(4);
        bst.add(3);
        bst.add(7);
        bst.add(9);
        bst.add(10);

        assertEquals(false, BST.isBalanced(bst.getRoot()));
    }

    @Test
    public void testIfBalanced_Unbalanced3() {
        bst.add(6);
        bst.add(5);
        bst.add(7);
        bst.add(4);
        bst.add(9);
        bst.add(10);
        bst.add(3);


        assertEquals(false, BST.isBalanced(bst.getRoot()));
    }

    @Test
    public void testIfBalanced_Balanced1() {
        bst.add(6);
        bst.add(5);
        bst.add(7);
        bst.add(4);
        bst.add(9);


        assertEquals(true, BST.isBalanced(bst.getRoot()));
    }
}
