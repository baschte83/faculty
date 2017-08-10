package exceptions;

/**
 * Organization: University of applied sciences munich, faculty 07<br>
 * Project: practical course software development 2 Prof. Dr. Hammerschall, summer term 2017<br>
 * Study group: IF4A<br>
 * Date: 09. April 2017<br>
 * Purpose: solution to lab 01: FacultyException.java<br>
 * @author Sebastian Baumann, Korbinaian Karl, Seyed Ehsan Moslehi
 * @version 0.9
 */
public class FacultyException extends Exception {

    /**
     * Constructs a new FacultyException.
     */
    FacultyException() {
        super();
    }

    /**
     * Constructs a new FacultyException with the specified detail message.
     *
     * @param message the detail message.
     */
    FacultyException(String message) {
        super(message);
    }

    /**
     * Constructs a new FacultyException with the specified cause and a detail message.
     * @param cause the cause.
     */
    FacultyException(Throwable cause) {
        super(cause);
    }

    /**
     *  Constructs a new FacultyException with the specified detail message and cause.
     * @param message the detail message.
     * @param cause the cause.
     */
    FacultyException(String message, Throwable cause) {
        super(message, cause);
    }
}

