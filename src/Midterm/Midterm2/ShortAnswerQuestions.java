package Midterm.Midterm2;

import java.util.Arrays;

public class ShortAnswerQuestions {

    public static void main(String[] args) {
        final int[] even_length = {1, 2, 3, 4};
        final int[] odd_length = {1, 2, 3, 4, 5};

        System.out.println("[Test 1: Reverse an array]");
        System.out.println(Arrays.toString(even_length) + " -> " + Arrays.toString(reverse(even_length)));
        System.out.println(Arrays.toString(odd_length) + " -> " + Arrays.toString(reverse(odd_length)));

        final int[][] numbers = {{1, 3, 5, 7, 9},
                                 {2, 4, 6, 8, 10, 12, 14}};

        System.out.println("\n[Test 2: Merge two arrays]");
        System.out.println(Arrays.toString(merge_alternate_pattern(numbers[0], numbers[1])));
        System.out.println(Arrays.toString(merge_alternate_pattern(numbers[1], numbers[0])));

        System.out.println("\n[Test 3: Mystery return value]");
        int x, y, z;
        x = 30;
        y = 70;
        z = 20;
        z = mystery(x, z, y);
        System.out.println(x + " " +  y + " " + z);
        x = mystery(z, z, x);
        System.out.println(x + " " +  y + " " + z);
        y = mystery(y, y, z);
        System.out.println(x + " " +  y + " " + z);
    }

    /**
     * Question 2 in Midterm 2. Find the result of x, y, and z.
     *
     * @param x An integer.
     * @param z An integer.
     * @param y An integer.
     *
     * @return 2 * y + z
     */
    private static int mystery(int z, int x, int y) {
        x=y+x;
        y=x-z++;
        System.out.println(y + " " + z);
        return x;
    }

    void q1() {
        int[] my_array = {5, 16, 28, 38, 42};
        my_array[2]++;

    }

    /**
     * Question 3 in Midterm 2. This method reverses an array passed as the argument.
     *
     * @param nums Array to be reversed.
     * @return Copy (deep clone) of the reversed array.
     */
    private static int[] reverse(int[] nums) {
        for (int i = 0; i < nums.length/2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }

        int[] reversed = new int[nums.length];
        System.arraycopy(nums, 0, reversed, 0, nums.length);

        return reversed;
    }

    /**
     * Question 4 in Midterm 2. This method merges two arrays in an alternating pattern.
     *
     * Pattern:
     * a -> {1, 2, 3, 4, 5};
     * b -> {6, 7, 8, 9 10, 12, 12};
     * Return value = {1, 6, 2, 7, 3, 8, 4, 9, 5, 10, 12, 12};
     *
     * @param a The array to be copied to the even indices of the result.
     * @param b The array to be copied to the odd indices of the result.
     * @return Longer Array of length = a.length + b.length, with a body of the pattern.
     */
    private static int[] merge_alternate_pattern(int[] a, int[] b) {
        int[] merged = new int[a.length + b.length];

        for (int i = 0; i < Math.min(a.length, b.length); i++) {
            merged[i*2] = a[i];
            merged[i*2+1] = b[i];
        }

        if (a.length != b.length) {
            int[] longer = a.length > b.length ? a : b;
            int[] shorter = a.length < b.length ? a : b;

            System.arraycopy(longer, shorter.length, merged, shorter.length * 2, longer.length - shorter.length);
        }

        return merged;
    }
}
