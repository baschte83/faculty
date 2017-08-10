package exceptions;

/**
 * Organization: University of applied sciences munich, faculty 07<br>
 * Project: practical course software developement 2 Prof. Dr. Hammerschall, summer term 2017<br>
 * Study group: IF4A<br>
 * Date: 09. April 2017<br>
 * Purpose: solution to lab 01: LectureNotEmptyException.java<br>
 * @author Sebastian Baumann, Korbinaian Karl, Seyed Ehsan Moslehi
 * @version 0.9
 */

public class LectureNotEmptyException extends FacultyException {

    /**
     * Constructs a new LectureNotEmptyException.
     */
    public LectureNotEmptyException() {
        super();
    }

    /**
     * Constructs a new LectureNotEmptyException with the specified detail message.
     *
     * @param message the detail message.
     */
    public LectureNotEmptyException(String message) {
        super(message);
    }

    /**
     * Constructs a new LectureNotEmptyException with the specified cause and a detail message.
     * @param cause the cause.
     */
    public LectureNotEmptyException(Throwable cause) {
        super(cause);
    }

    /**
     *  Constructs a new LectureNotEmptyException with the specified detail message and cause.
     * @param message the detail message.
     * @param cause the cause.
     */
    public LectureNotEmptyException(String message, Throwable cause) {
        super(message, cause);
    }
}
