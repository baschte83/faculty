package exceptions;

/**
 * Organization: University of applied sciences munich, faculty 07<br>
 * Project: practical course software development 2 Prof. Dr. Hammerschall, summer term 2017<br>
 * Study group: IF4A<br>
 * Date: 09. April 2017<br>
 * Purpose: solution to lab 01: LectureNotExistsException.java<br>
 * @author Sebastian Baumann, Korbinaian Karl, Seyed Ehsan Moslehi
 * @version 0.9
 */

public class LectureNotExistsException extends FacultyException {

    /**
     * Constructs a new LectureNotExistsException.
     */
    public LectureNotExistsException() {
        super();
    }

    /**
     * Constructs a new LectureNotExistsException with the specified detail message.
     *
     * @param message the detail message.
     */
    public LectureNotExistsException(String message) {
        super(message);
    }

    /**
     * Constructs a new LectureNotExistsException with the specified cause and a detail message.
     * @param cause the cause.
     */
    public LectureNotExistsException(Throwable cause) {
        super(cause);
    }

    /**
     *  Constructs a new LectureNotExistsException with the specified detail message and cause.
     * @param message the detail message.
     * @param cause the cause.
     */
    public LectureNotExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
