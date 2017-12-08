package FinalPrep;

public class ClassExamples {

    public static void cake_maker() {
        System.out.println("hi");
    }

    public static int cake_maker(int n) {
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(loops_example(1));
        System.out.println(recursion_example(1));
    }

    public static int loops_example(float initial) {
        float count = initial;
        int i = 0;
        for (; count < 1_000_000; i++) {
            count += (1 + count/2);
        }
        return i;
    }

    public static int recursion_example(float initial) {
        if (initial > 1_000_000) {
            return 0;
        }
        return 1 + recursion_example((initial + (1 + initial/2)));
    }
}
