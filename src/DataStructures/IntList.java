package DataStructures;

public class IntList {
    private int[] elements;
    private int num_accessible;

    public IntList() {
        this (8);
    }

    public IntList(int n) {
        elements = new int[n];
        num_accessible = 0;
    }

    public void insert(int index, int item) {
        for (int i = num_accessible - 2; i >= index; i--) {
            elements[i+1] = elements[i];
        }
        elements[index] = item;

        num_accessible++;
    }

    public void remove(int index) {
        for (int i = index; i < num_accessible-1; i++) {
            elements[i] = elements[i+1];
        }

        num_accessible--;
    }

    public int size() {
        return num_accessible;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append("[");
        for (int i = 0; i < num_accessible; i++) {
            s = s.append(elements[i]);
            if (i != num_accessible - 1) {
                s = s.append(", ");
            }
        }
        s.append("]");

        return s.toString();
    }
}

class ListRunner {
    public static void main(String[] $) {
        IntList list = new IntList(5);

        for (int i = 0; i < 5; i++) {
            list.insert(i, i+1);
            System.out.println(list);
        }

        System.out.println();

        for (int i = 0; i < 5; i++) {
            list.remove(list.size()-1);
            System.out.println(list);
        }
    }
}
