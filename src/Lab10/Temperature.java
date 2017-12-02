package Lab10;

@SuppressWarnings("ALL")
public class Temperature implements Comparable {
    private double temp;
    private char scale;

    Temperature() {
        this(0, 'C');
    }

    Temperature(double temp, char scale) {
        this.temp = temp;
        if (scale != 'C' && scale != 'F') {
            throw new IllegalArgumentException("Scale can only be (C)elsius or (F)ahrenheit");
        }
        this.scale = scale;
    }

    public double getTempCelcius() {
        return this.scale == 'C' ? temp : 5 * (temp -32)/9;
    }

    public double getTempFaren() {
        return this.scale == 'F' ? temp : 9 * (temp/5) + 32;
    }

    public void setScale(char scale) {
        this.scale = scale;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public void setAll(char scale, double temp) {
        this.scale = scale;
        this.temp = temp;
    }

    @Override
    public int compareTo(Object compare_value) {
        if (!(compare_value instanceof Temperature)) {
            throw new IllegalArgumentException("Cannot compare " + compare_value.getClass() + " to " + getClass());
        }

        double this_temp_c = getTempCelcius();
        double compare_temp_c = ((Temperature)compare_value).getTempCelcius();
        return Double.compare(this_temp_c, compare_temp_c);
    }

    @Override
    public String toString() {
        return String.format("%.1f %c", temp, scale);
    }
}
