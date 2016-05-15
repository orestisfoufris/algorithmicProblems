package ctci.chapter1;

/**
 * Implement an algorithm to determine if a string
 * has all unique characters. What if you cannot use additional
 * data structures?
 */
public class Question1 {

    private static boolean isUnique(String input) {
        boolean isUnique = true;
        for (int i = 0; i < input.length(); ++i) {
            for (int j = i + 1; j < input.length(); ++j) {
                if (input.charAt(i) == input.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }
        }

        return isUnique;
    }

    public static void main(String[] args) {
        String input = "abcdefga";
        String input2 = "abcdef";
        String input3 = "aaaaaaaaa";
        String input4 = "";

        System.out.println(isUnique(input)); // false
        System.out.println(isUnique(input2)); // true
        System.out.println(isUnique(input3)); // false
        System.out.println(isUnique(input4)); // true
    }
}
