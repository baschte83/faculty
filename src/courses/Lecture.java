package courses;

/**
 * Organization: University of applied sciences munich, faculty 07<br>
 * Project: practical course software development 2 Prof. Dr. Hammerschall, summer term 2017<br>
 * Study group: IF4A<br>
 * Date: 09. April 2017<br>
 * Purpose: solution to lab 01: Lecture.java<br>
 * @author Sebastian Baumann, Korbinaian Karl, Seyed Ehsan Moslehi
 * @version 0.9
 */

public class Lecture {

    /**
     * Private object-variable that stores the name of this lecture as a string.
     */
    private final String name;

    /**
     * Private object-variable that stores the number of subscriptions to this specific lecture as as an integer.
     */
    private int subscriptions = 0;

    /**
     * Constructor of a lecture object.
     * @param name - is the name of a lecture object as a string.
     */
    public Lecture(String name) {
        this.name = name;
    }

    /**
     * Gets the name of this lecture object.
     * @return the name of this lecture as a string.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the number of subscriptions of this lecture object.
     * @return the number of subscriptions as an integer.
     */
    public int getSubscriptions() {
        return subscriptions;
    }

    /**
     * Method to increase the number of subscriptions of this lecture object.
     */
    public void subscribe() {
        this.subscriptions++;
    }

    /**
     * Method to decrease the number of subscriptions of this lecture object.
     * Method checks wether the number of subscriptions of this lecture is
     * larger than zero or not. If so, the number of subscriptions can be
     * decreased. If not so, nothing happens and the number of subscriptions
     * stays zero.
     */
    public void unsubscribe() {
        if (this.subscriptions > 0) {
            this.subscriptions--;
        }
    }
}