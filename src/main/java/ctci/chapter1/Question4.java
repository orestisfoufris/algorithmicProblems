package ctci.chapter1;

/**
 * Write a method to replace all spaces in a string with %20. You might assume that
 * the string has sufficient space at the end of string to hold the additional
 * characters, and that you are given the "true" length of the string.
 *
 * EXAMPLE:
 * Input: "Mr John Smith    ", 13
 * Output: "Mr%20John%20Smith"
 */
public class Question4 {

    private static String replaceSpaces(String input) {
        return input.trim().replace(" ", "%20");
    }

    public static void main(String[] args) {
        String input = "Mr John Smith    ";
        System.out.println(replaceSpaces(input)); // Mr%20John%20Smith
    }
}
