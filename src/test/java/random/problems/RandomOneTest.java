package random.problems;


import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.testng.Assert.assertEquals;

/**
 * Created by Orestis on 11/10/2014
 */
public class RandomOneTest {
    private RandomOne randomOne = new RandomOne();


    @Test
     public void test1() throws Exception {
        List<Integer> given = newArrayList(1,3,4,5,8);
        ArrayList<ArrayList<Integer>> actual = randomOne.solution(given);
        ArrayList<ArrayList<Integer>> expected = newArrayList(newArrayList(1), newArrayList(3,4,5), newArrayList(8));
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
        assertEquals(actual, expected);
    }

    @Test
    public void test2() throws Exception {
        List<Integer> given = newArrayList(1,3,4,5,6,8);
        ArrayList<ArrayList<Integer>> actual = randomOne.solution(given);
        ArrayList<ArrayList<Integer>> expected = newArrayList(newArrayList(1), newArrayList(3,4,5,6), newArrayList(8));
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
        assertEquals(actual, expected);
    }

    @Test
    public void test3() throws Exception {
        List<Integer> given = newArrayList(1,2,3,4,5,6,8,20,21,40,45,30);
        ArrayList<ArrayList<Integer>> actual = randomOne.solution(given);
        ArrayList<ArrayList<Integer>> expected = newArrayList(newArrayList(1,2,3,4,5,6), newArrayList(8), newArrayList(20,21), newArrayList(30), newArrayList(40), newArrayList(45));
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
        assertEquals(actual, expected);
    }

    @Test
    public void test4() throws Exception {
        List<Integer> given = newArrayList(1,2,3,4,5,6,8,20,21,40,45,30,2,3);
        ArrayList<ArrayList<Integer>> actual = randomOne.solution(given);
        ArrayList<ArrayList<Integer>> expected = newArrayList(newArrayList(1,2,3,4,5,6), newArrayList(8), newArrayList(20,21), newArrayList(30), newArrayList(40), newArrayList(45));
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
        assertEquals(actual, expected);
    }
}
