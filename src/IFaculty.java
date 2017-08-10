import exceptions.LectureNotEmptyException;
import exceptions.LectureNotExistsException;
import exceptions.ProfessorExistsException;
import exceptions.ProfessorNotExistsException;

/**
 * Interface for faculty class. Defines required behaviour of a faculty. 
 * @author U. Hammerschall
 */
public interface IFaculty {

    /**
     * Creates a professor with the specified name as a new member of the
     * faculty.
     *
     * @param name
     *            of the professor to be created.
     * @throws ProfessorExistsException
     *             if another professor with the same name already exists in the
     *             faculty.
     */
    void createProfessor(String name)
            throws ProfessorExistsException;

    /**
     * Checks, if the professor with the specified name exists in the faculty.
     *
     * @param name
     *            of the professor to check.
     * @return true, if the professor exists, otherwise false.
     */
    boolean existsProfessor(String name);

    /**
     * Removes the professor with the specified name from the faculty.
     *
     * @param name
     *            of the professor to be removed.
     * @throws ProfessorNotExistsException
     *             if the professor does not exist in the faculty.
     * @throws LectureNotEmptyException
     *             if someone is still assigned to one of his or her lectures.
     */
    void deleteProfessor(String name)
            throws ProfessorNotExistsException, LectureNotEmptyException;

    /**
     * Creates a new lecture with the specified name and assigns it to the
     * specified professor.
     *
     * @param professor
     *            to whom the new lecture will be assigned.
     * @param lecture
     *            to be created and assigned.
     * @throws ProfessorNotExistsException
     *             if the professor does not exist in the faculty.
     */
    void createLecture(String professor, String lecture)
            throws ProfessorNotExistsException;

    /**
     * Checks if the lecture with the specified name exists in the lecture list
     * of the specified professor.
     *
     * @param professor
     *            responsible for the lecture.
     * @param lecture
     *            to be checked.
     * @return true if the lecture exists, otherwise false
     * @throws ProfessorNotExistsException
     *             if the professor does not exist in the faculty.
     */
    boolean existsLecture(String professor, String lecture)
            throws ProfessorNotExistsException;

    /**
     * Removes the first lecture with the specified name from the lecture list
     * of the specified professor.
     *
     * @param professor
     *            from whom the lecture is to be removed
     * @param lecture
     *            to be removed.
     * @throws ProfessorNotExistsException
     *             if the professor does not exist in the faculty.
     * @throws LectureNotExistsException
     *             if the lecture does not exist.
     * @throws LectureNotEmptyException
     *             if there are still students assigned to the lecture.
     */
    void deleteLecture(String professor, String lecture)
            throws ProfessorNotExistsException,
            LectureNotExistsException,
            LectureNotEmptyException;

    /**
     * Subscribes an arbitrary participant to the specified lecture. The number
     * of possible participants is unlimited.
     *
     * @param professor
     *            responsible for the lecture.
     * @param lecture
     *            the participant wants to subscribe.
     * @throws ProfessorNotExistsException
     *             if the professor does not exist in the faculty.
     * @throws LectureNotExistsException
     *             if the lecture does not exist.
     */
    void subscribe(String professor, String lecture)
            throws ProfessorNotExistsException, LectureNotExistsException;

    /**
     * Removes an arbitrary participant from the specified lecture. If there are
     * no participants left, nothing happens.
     *
     * @param professor
     *            responsible for the lecture.
     * @param lecture
     *            the participant wants to unsubscribe from.
     * @throws ProfessorNotExistsException
     *             if the professor does not exist in the faculty.
     * @throws LectureNotExistsException
     *             if the lecture does not exist.
     */
    void unsubscribe(String professor, String lecture)
            throws ProfessorNotExistsException, LectureNotExistsException;

    /**
     * Returns the current number of subscriptions to the specified lecture.
     *
     * @param professor
     *            responsible for the lecture.
     * @param lecture
     *            with the requested subscriptions.
     * @return number of current subscriptions to the lecture.
     * @throws ProfessorNotExistsException
     *             if the professor does not exist in the faculty.
     * @throws LectureNotExistsException
     *             if the lecture does not exist.
     */
    int subscriptions(String professor, String lecture)
            throws ProfessorNotExistsException, LectureNotExistsException;

}