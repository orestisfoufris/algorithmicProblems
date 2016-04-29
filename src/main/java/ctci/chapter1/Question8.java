package ctci.chapter1;

/**
 * Assume you have a method isSubstring which checks if one word
 * is a substring of another. Given two strings, s1 and s2, write
 * code to check if s2 is a rotation of s1 using only one call to
 * isSubstring.
 *
 */
public class Question8 {


    private static boolean isRotation(String original, String rotated) {
        if (original.length() != rotated.length() || original.isEmpty()) {
            return false;
        }

        String concatenated = original + original;

        return concatenated.contains(rotated);
    }

    public static void main(String[] args) {
        String original = "waterbottle";
        String rotated = "erbottlewat";

        String original2 = "penguin";
        String rotated2 = "guinpan";

        System.out.println(isRotation(original, rotated)); // true
        System.out.println(isRotation(original2, rotated2)); // false
    }
}
