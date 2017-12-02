package Lab7;

@SuppressWarnings("ALL")
public class LargestString {
    private static String lexLargest (String phrase) {
        String[] tokens = phrase.split("[ ]");
        String last_word = "";

        for (String str : tokens) {
            if (str.compareTo(last_word) > 0) {
                last_word = str;
            }
        }

        return last_word;
    }

    private static String largestBy (String phrase) {
        String[] tokens = phrase.split("[ ]");
        String largest_word = "";

        for (String str : tokens) {
            if (str.length() > largest_word.length()) {
                largest_word = str;
            }
        }

        return largest_word;
    }

    public static String largestByAction(String input, int action) {
        switch (action) {
            case 1:
                return lexLargest(input);
            case 2:
                return largestBy(input);
        }
        return "";
    }
}
