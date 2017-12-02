package Lab10;

@SuppressWarnings("ALL")
public class TempTester {
    public static void main (String[] args) {
        System.out.println(new Temperature(98.164555, 'C'));
        System.out.println(new Temperature(0, 'C').getTempFaren());
        System.out.println(new Temperature(-40, 'C').getTempFaren());
        System.out.println(new Temperature(100, 'C').getTempFaren());
        Temperature temp1 = new Temperature(220, 'F');
        Temperature temp2 = new Temperature(100, 'C');

        System.out.println(temp1.compareTo(temp2));
    }
}
