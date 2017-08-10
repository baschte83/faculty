import exceptions.LectureNotEmptyException;
import exceptions.LectureNotExistsException;
import exceptions.ProfessorExistsException;
import exceptions.ProfessorNotExistsException;
import members.Professor;

import java.util.ArrayList;
import java.util.List;

/**
 * Organization: University of applied sciences munich, faculty 07<br>
 * Project: practical course software development 2 Prof. Dr. Hammerschall, summer term 2017<br>
 * Study group: IF4A<br>
 * Date: 09. April 2017<br>
 * Purpose: solution to lab 01: Faculty.java<br>
 * @author Sebastian Baumann, Korbinaian Karl, Seyed Ehsan Moslehi
 * @version 0.9
 */

public class Faculty implements IFaculty {

    private List<Professor> profList = new ArrayList<>();

    /**
     * Creates a professor with the specified name as a new member of the
     * faculty.
     *
     * @param name of the professor to be created.
     * @throws ProfessorExistsException if another professor with the same name already exists in the
     *                                  faculty.
     */
    @Override
    public void createProfessor(String name) throws ProfessorExistsException {
        if (existsProfessor(name)) {
            throw new ProfessorExistsException("Professor exists!");
        }
        profList.add(new Professor(name));
    }

    /**
     * Checks, if the professor with the specified name exists in the faculty.
     *
     * @param name of the professor to check.
     * @return true, if the professor exists, otherwise false.
     */
    @Override
    public boolean existsProfessor(String name) {
        for (Professor professor : profList) {
            if (name.equals(professor.getProfName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Removes the professor with the specified name from the faculty.
     *
     * @param name of the professor to be removed.
     * @throws ProfessorNotExistsException if the professor does not exist in the faculty.
     * @throws LectureNotEmptyException    if someone is still assigned to one of his or her lectures.
     */
    @Override
    public void deleteProfessor(String name) throws ProfessorNotExistsException, LectureNotEmptyException {
        if (!existsProfessor(name)) {
            throw new ProfessorNotExistsException("Professor not exists!");
        }
        Professor prof = findProfessor(name);
        if (prof.getSubscriptionsSum() == 0 || prof.getLectureList().size() == 0) {
            profList.remove(prof);
        }
    }


    /**
     * Creates a new lecture with the specified name and assigns it to the
     * specified professor.
     *
     * @param professor to whom the new lecture will be assigned.
     * @param lecture   to be created and assigned.
     * @throws ProfessorNotExistsException if the professor does not exist in the faculty.
     */
    @Override
    public void createLecture(String professor, String lecture) throws ProfessorNotExistsException {
        if (!existsProfessor(professor)) {
            throw new ProfessorNotExistsException("Professor not exists!");
        }
        findProfessor(professor).addLecture(lecture);
    }

    /**
     * Checks if the lecture with the specified name exists in the lecture list
     * of the specified professor.
     *
     * @param professor responsible for the lecture.
     * @param lecture   to be checked.
     * @return true if the lecture exists, otherwise false
     * @throws ProfessorNotExistsException if the professor does not exist in the faculty.
     */
    @Override
    public boolean existsLecture(String professor, String lecture) throws ProfessorNotExistsException {
        if (!existsProfessor(professor)) {
            throw new ProfessorNotExistsException("Professor not exists!");
        }
        return findProfessor(professor).existsLecture(lecture);
    }

    /**
     * Removes the first lecture with the specified name from the lecture list
     * of the specified professor.
     *
     * @param professor from whom the lecture is to be removed
     * @param lecture   to be removed.
     * @throws ProfessorNotExistsException if the professor does not exist in the faculty.
     * @throws LectureNotExistsException   if the lecture does not exist.
     * @throws LectureNotEmptyException    if there are still students assigned to the lecture.
     */
    @Override
    public void deleteLecture(String professor, String lecture) throws ProfessorNotExistsException, LectureNotExistsException, LectureNotEmptyException {

        if (!existsProfessor(professor)) {
            throw new ProfessorNotExistsException("Professor not exists!");
        }
        findProfessor(professor).deleteLecture(lecture);
    }

    /**
     * Subscribes an arbitrary participant to the specified lecture. The number
     * of possible participants is unlimited.
     *
     * @param professor responsible for the lecture.
     * @param lecture   the participant wants to subscribe.
     * @throws ProfessorNotExistsException if the professor does not exist in the faculty.
     * @throws LectureNotExistsException   if the lecture does not exist.
     */
    @Override
    public void subscribe(String professor, String lecture) throws ProfessorNotExistsException, LectureNotExistsException {
        if (!existsProfessor(professor)) {
            throw new ProfessorNotExistsException("Professor not exists!");
        }
        findProfessor(professor).subscribe(lecture);
    }

    /**
     * Removes an arbitrary participant from the specified lecture. If there are
     * no participants left, nothing happens.
     *
     * @param professor responsible for the lecture.
     * @param lecture   the participant wants to unsubscribe from.
     * @throws ProfessorNotExistsException if the professor does not exist in the faculty.
     * @throws LectureNotExistsException   if the lecture does not exist.
     */
    @Override
    public void unsubscribe(String professor, String lecture) throws ProfessorNotExistsException, LectureNotExistsException {
        if (!existsProfessor(professor)) {
            throw new ProfessorNotExistsException("Professor not exists!");
        }
        findProfessor(professor).unsubscribe(lecture);
    }

    /**
     * Returns the current number of subscriptions to the specified lecture.
     *
     * @param professor responsible for the lecture.
     * @param lecture   with the requested subscriptions.
     * @return number of current subscriptions to the lecture.
     * @throws ProfessorNotExistsException if the professor does not exist in the faculty.
     * @throws LectureNotExistsException   if the lecture does not exist.
     */
    @Override
    public int subscriptions(String professor, String lecture) throws ProfessorNotExistsException, LectureNotExistsException {
        if (!existsProfessor(professor)) {
            throw new ProfessorNotExistsException("Professor not exists!");
        }
        return findProfessor(professor).subscriptions(lecture);
    }

    /**
     * Method finds a specific professor object in the list of professors of this faculty object.
     *
     * @param professor - is the professor which schould be found as a professor object.
     * @return the found professor as an professor object or null.
     */
    private Professor findProfessor(String professor) {
        Professor prof = null;
        for (Professor p : profList) {
            if (p.equals(new Professor(professor))) {
                prof = p;
            }
        }
        return prof;
    }
}