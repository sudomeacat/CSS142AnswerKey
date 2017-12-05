package FinalPrep;

public class TestCollections {
    public static void main(String... args) {
        Vector<Integer> test_vector = new Vector<>();
        for (int i = 5; i < 10; i++) {
            test_vector.push_back(i);
        }

        System.out.println(test_vector.size());
        System.out.println(test_vector.toString());

        for (int i = 5; i < 10; i++) {
            test_vector.insert(i, 1);
        }

        System.out.println(test_vector.size());
        System.out.println(test_vector.toString());

        for (int i = 0; i < 5; i++) {
            Integer res = test_vector.remove(2);
            System.out.print(res + " ");
        }
        System.out.println();

        System.out.println(test_vector.size());
        System.out.println(test_vector.toString());

        test_vector.clear();
        System.out.println(test_vector.size());
        System.out.println(test_vector.toString());
    }
}
