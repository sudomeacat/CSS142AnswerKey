package Lab7;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

@SuppressWarnings("ALL")
public class CharsIndex {
    /**
     * This methods maps each character with the index from the string.
     *
     * For part 3.2, I notice that 12 characters aren't present in the string, therefore their map values are 0.
     */
    public static void charsIndex(String str) {
        Map<Character, Integer> appearance = new HashMap<>();
        Vector<Character> key = new Vector<>();

        for (char i = 'a'; i <= 'z'; i++) {
            appearance.put(i, 0);
            key.add(i);
        }

        for (int i = 0; i < str.length(); i++) {
            if (Character.isAlphabetic(str.charAt(i)) && Character.isLowerCase(str.charAt(i))) {
                if (appearance.get(str.charAt(i)) == 0) {
                    appearance.put(str.charAt(i), i);
                }
            }
        }

        printMap(appearance, key);

    }

    /**
     * Output per instructions (Unused because of it's complexity).
     */
    public static void printMap (Map<Character, Integer> map, Vector<Character> key) {
        for (int i = 0; i < 10; i++) {
            System.out.printf("%-3s", key.get(i));
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.printf("===");
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.printf("%-3s", map.get(key.get(i)));
        }
        System.out.println();
        System.out.println();

        for (int i = 10; i < 20; i++) {
            System.out.printf("%-3s", key.get(i));
        }
        System.out.println();
        for (int i = 10; i < 20; i++) {
            System.out.printf("===");
        }
        System.out.println();
        for (int i = 10; i < 20; i++) {
            System.out.printf("%-3s", map.get(key.get(i)));
        }
        System.out.println();
        System.out.println();

        for (int i = 20; i < key.size(); i++) {
            System.out.printf("%-3s", key.get(i));
        }
        System.out.println();
        for (int i = 20; i < key.size(); i++) {
            System.out.printf("===");
        }
        System.out.println();
        for (int i = 20; i < key.size(); i++) {
            System.out.printf("%-3s", map.get(key.get(i)));
        }
    }
}
