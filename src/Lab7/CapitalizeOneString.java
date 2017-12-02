package Lab7;

@SuppressWarnings("ALL")
public class CapitalizeOneString {
    public static void main(String[] args) {
        String str = "I really enjoy attending lab!";
        capitalizeFirstLetters(str);

        String test2 = nameInitials("Bertrand Arthur William Russell");
        System.out.println(test2);

        int count = letterCount("I am the very model of a modern major general", "m");
        System.out.println(count);

        String lex_largest = LargestString.largestByAction ("I am the very model of a modern major general", 1);
        System.out.println(lex_largest);

        String largest_word = LargestString.largestByAction("I am the very model of a modern major general", 2);
        System.out.println(largest_word);

        //str = "The quick brown fox jumps over the lazy dog.";
        str = "I love programming languages, especially Java.";
        CharsIndex.charsIndex(str);
    }

    public static void capitalizeFirstLetters(String str) {
        String[] tokens = str.split("[ ]");
        StringBuilder stringBuilder = new StringBuilder();
        for (String s: tokens) {
            stringBuilder.append(s.replace(s.charAt(0), Character.toUpperCase(s.charAt(0))));
            stringBuilder.append(' ');
        }
        System.out.println(stringBuilder.toString());
    }

    public static String nameInitials(String name) {
        String initials = "";

        String[] token = name.split("[ ]");

        StringBuilder builder = new StringBuilder(initials);
        for (String s: token) {
            builder.append(s.charAt(0));
            builder.append('.');
        }

        return builder.toString();
    }

    public static int letterCount(String phrase, String regex) {
        int counter = 0;

        for (int i = 0; i < phrase.length()-regex.length(); i++) {
            if (phrase.substring(i, i+regex.length()).equals(regex)) {
                counter++;
            }
        }
        return counter;
    }
}
