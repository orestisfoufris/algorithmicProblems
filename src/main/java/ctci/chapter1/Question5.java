package ctci.chapter1;

/**
 * Implement a method to perform basic string compression using the counts of
 * repeated characters. If the "compressed" string would not become smaller than the original,
 * string, your method should return the original string. You can assume the string contains
 * only upper and lower case letters (a-z).
 */
public class Question5 {

    private static String encode(String input) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < input.length() - 1; ++i) {
            int count = 1;
            char c = input.charAt(i);
            while (input.charAt(i) == input.charAt(i + 1)) {
                count++;
                if (i < input.length() - 2) {
                    i++;
                } else {
                    break;
                }
            }
            stringBuilder.append(c).append(count);
        }

        if (stringBuilder.length() >= input.length()) {
            return input;
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String input = "aabcccccaaa";
        System.out.println(encode(input)); // a2b1c5a3

        String input2 = "aaAbcccccaaa";
        System.out.println(encode(input2)); // a2A1b1c5a3

        String input3 = "abcdefg";
        System.out.println(encode(input3)); // abcdefg
    }
}
