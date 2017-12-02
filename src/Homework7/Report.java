package Homework7;

@SuppressWarnings("ALL")
public class Report {
    private Race race;

    /**
     * Default constructor that initializes this object and it's fields
     */
    public Report() {
        race = new Race();
    }

    /**
     * Returns the average (arithmetic mean) of the times from the Race object. This method uses floating point
     * arithmetic.
     *
     * @return the average of the three times in the Race object as a float.
     */
    public float get_average_time() {
        return (race.getTime1() + race.getTime2() + race.getTime3())/3f;
    }

    /**
     * Returns the numeric range (difference of max and min) of the race times. This method uses floating point
     * arithmetic.
     *
     * @return Floating point value of the range of times.
     */
    public float get_range() {
        return race.getTime3() - race.getTime1();
    }

    /**
     * Returns the race instance.
     *
     * @return the race instance.
     */
    public Race getRace() {
        return race;
    }
}
