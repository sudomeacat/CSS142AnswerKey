package FinalPrep;

/**
 * Hybrid generic class of VSTD::__1::vector and java.util.ArrayList (formerly java.util.Vector),
 * although does not support concurrent operations.
 *
 * @param <Tp> User can choose to insert one type of element.
 */
public class Vector<Tp> {
    private Object[] elements;
    private int r_bound;

    /**
     * Default constructor for Vector. The element array is initialized to a capacity of 8.
     * This is a strict constant time (O(1)) operation.
     */
    public Vector() {
        elements = new Object[8];
        r_bound = 0;
    }

    /**
     * Interface method to push (add) an item to the back of a Vector.
     * This is a linear time (O(N)) operation.
     *
     * @param item element to be added.
     */
    public void push_back(Tp item) {
        insert(item, r_bound);
    }

    /**
     * Interface method to insert an item to a desired location.
     * This is a linear time (O(1)) operation.
     *
     * @param item Item to be added
     * @param index index to add the element.
     */
    public void insert(Tp item, int index) {
        if (item == null) {
            throw new IllegalArgumentException("item pointer set to null");
        }
        if (index < 0 || index > r_bound) {
            throw new IndexOutOfBoundsException();
        }

        if (r_bound + 1 == elements.length) {
            resize_upward();
        }
        System.arraycopy(elements, index, elements, index+1, r_bound - index);
        elements[index] = item;
        r_bound++;
    }

    /**
     * Interface method to delete an item from a desired index. This method returns
     * the deleted element.
     * This is a linear time operation (O(N)).
     *
     * @param index index of element to delete.
     * @return Element to be removed from the array.
     */
    @SuppressWarnings("unchecked")
    public Tp remove(int index) {
        if (index < 0 || index > r_bound) {
            throw new IndexOutOfBoundsException();
        }

        Tp item;
        item = (Tp) elements[index];
        System.arraycopy(elements, index+1, elements, index, r_bound - index);
        r_bound--;
        return item;
    }

    /**
     * Resize the Vector to be 150% the size of the original.
     * This is a strict linear time (O(N)) operation.
     */
    private void resize_upward() {
        Object[] temp = elements;
        elements = new Object[elements.length + elements.length/2];
        System.arraycopy(temp, 0, elements, 0, r_bound);
    }

    /**
     * Clears the vector.
     */
    public void clear() {
        r_bound = 0;
    }

    /**
     * Gets the size (number of accessible elements) of the Vector.
     * This is a constant time (O(1)) operation.
     *
     * @return the number of accessible elements in the Vector
     */
    public int size() {
        return r_bound;
    }

    /**
     * Returns a string version of the accessible section of the
     * Vector, following the style of java.utilArrays.toString().
     *
     * @return String version of the array.
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append("[");
        for (int i = 0; i < r_bound; i++) {
            s = s.append(elements[i]);
            if (i != r_bound - 1) {
                s = s.append(", ");
            }
        }
        s.append("]");

        return s.toString();
    }
}
