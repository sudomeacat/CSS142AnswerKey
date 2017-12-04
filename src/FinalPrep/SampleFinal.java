package FinalPrep;

import java.util.Arrays;

public class SampleFinal {
    public static void main (String[] args) {
        paradox_count(1f);

        double[] test_array = {1.1, 2.4, -3.0, 5.6};
        System.out.println(Arrays.toString(calc_relative(test_array)));

        Card a = new Card("2", "Spade");
        Card b = new Card("3", "Club");
        Card c = new Card("K", "Diamond");

        System.out.println(a);
        System.out.println(b.value());
        System.out.println(c.value());
    }

    public static void paradox_count(float value) {
        int count = 0;

        while (value > 0.0001) {
            value /= 2f;
            count++;
        }

        System.out.println("count = " + count);
    }

    public static double[] calc_relative(double[] original) {
        double minumum = Double.MAX_VALUE;

        for (double iter:original) {
            minumum = iter < minumum ? iter : minumum;
        }

        for (int i = 0; i < original.length; i++) {
            original[i] -= minumum;
        }

        return original;
    }

    public static class Card {
        private String name;
        private String suit;

        public Card(String name, String suit) {
            this.name = name;
            this.suit = suit;
        }

        public String getName() {
            return name;
        }

        public String getSuit() {
            return suit;
        }

        public int value() {
            if (name.charAt(0) == 65) {
                return 1;
            }
            else if (name.charAt(0) == 74) {
                return 11;
            }
            else if (name.charAt(0) == 81) {
                return 12;
            }
            else if (name.charAt(0) == 75) {
                return 13;
            }
            else {
                return Integer.parseInt(name);
            }
        }

        @Override
        public String toString() {
            return name + " " + suit;
        }
    }
}
