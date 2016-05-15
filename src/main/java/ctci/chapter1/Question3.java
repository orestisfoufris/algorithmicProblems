package ctci.chapter1;

import java.util.Arrays;

/**
 * Given two strings write a method to decide if one is
 * permutation of the other.
 */
public class Question3 {

    private static boolean isPerm(String first, String second) {

        if (first.length() != second.length()) {
            return false;
        }

        String firstArr[] = first.split("");
        String secondArr[] = second.split("");

        Arrays.sort(firstArr);
        Arrays.sort(secondArr);

        return Arrays.equals(firstArr, secondArr);
    }

    public static void main(String[] args) {
        String first = "abcdef";
        String second = "fabcde";

        String first2 = "bbbbbb";
        String second2 = "aaaaaa";

        System.out.println(isPerm(first, second)); // true
        System.out.println(isPerm(first2, second2)); // false
    }
}
