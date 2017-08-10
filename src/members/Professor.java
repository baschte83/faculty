package members;

import courses.Lecture;
import exceptions.LectureNotEmptyException;
import exceptions.LectureNotExistsException;

import java.util.ArrayList;
import java.util.List;

/**
 * Organization: University of applied sciences munich, faculty 07<br>
 * Project: practical course software development 2 Prof. Dr. Hammerschall, summer term 2017<br>
 * Study group: IF4A<br>
 * Date: 09. April 2017<br>
 * Purpose: solution to lab 01: Professor.java<br>
 * @author Sebastian Baumann, Korbinaian Karl, Seyed Ehsan Moslehi
 * @version 0.9
 */

public class Professor {

    /**
     * Constant to use in the method hashCode.
     */
    private static final int MAGIC_NUM = 31;

    /**
     * final variable stores the name of a professor.
     */
    private final String profName;

    /**
     * variable stores the lectures a specific professor has.
     */
    private List<Lecture> lectureList = new ArrayList<>();

    /**
     * Constructor of a Professor object.
     *
     * @param name - is the name of this professor object as a string.
     */
    public Professor(String name) {
        this.profName = name;
    }

    /**
     * Gets the list of lectures of this professor object.
     * Method returns the list of lectures of this professor object as
     * a list object of collection class. If this professor has no lectures
     * in his list of lectures, an empty list will be returned.
     *
     * @return the list of lectures of this professor object as a list object.
     */
    public List<Lecture> getLectureList() {
        return lectureList;
    }

    /**
     * Gets the name of this professor object.
     * Method returns the name of this professor object as
     * a string.
     *
     * @return the name of this professor object as a string.
     */
    public String getProfName() {
        return this.profName;
    }

    /**
     * Checks if the lecture with the specified name exists in the lecture list
     * of this professor.
     *
     * @param lecture - is the name of the searched lecture as a string.
     * @return true if the specified lecture was found, otherwise false.
     */
    public boolean existsLecture(String lecture) {
        if (this.lectureList.size() > 0) {
            for (Lecture l : this.lectureList) {
                if (lecture.equals(l.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Method adds a lecture with the specified name to the lecture list of this professor object.
     *
     * @param lecture - is the name of the new lecture as a string.
     */
    public void addLecture(String lecture) {
        this.lectureList.add(new Lecture(lecture));
    }

    /**
     * Removes the specified lecture from the lecture list of this professor object.
     *
     * @param lecture - is the name of the lecture to remove as a string.
     * @throws LectureNotExistsException if the specified lecture is not exists in the lecture list of this professor object.
     * @throws LectureNotEmptyException if the specified lecture in the lecture list of this professor object is not empty.
     */
    public void deleteLecture(String lecture) throws LectureNotExistsException, LectureNotEmptyException {
        if (!existsLecture(lecture)) {
            throw new LectureNotExistsException("Lecture not exists!");
        }
        if (subscriptions(lecture) != 0) {
            throw new LectureNotEmptyException("Lecture is not empty!");
        }
        getLectureList().remove(getLectureList().indexOf(findLecture(lecture)));
    }

    /**
     * Method finds a specific lecture of this professor object.
     *
     * @param lecture - is the specific lecture object which should be found.
     * @return a found lecture as a lecture object or null.
     */
    private Lecture findLecture(String lecture) {
        Lecture lec = null;
        for (Lecture l : getLectureList()) {
            if (lecture.equals(l.getName())) {
                lec = l;
            }
        }
        return lec;
    }

    /**
     * Method returns the number of subscriptions of the specified lecture.
     *
     * @param lecture - is the name of the lecture as a string.
     * @return the number of subscriptions of the specified lecture.
     * @throws LectureNotExistsException if the specified lecture not exists in the lecture list of this professor object.
     */
    public int subscriptions(String lecture) throws LectureNotExistsException {
        if (!existsLecture(lecture)) {
            throw new LectureNotExistsException("Lecture not exists!");
        }
        return findLecture(lecture).getSubscriptions();
    }

    /**
     * Method increases the number of subscriptions of the specified lecture by one.
     *
     * @param lecture - is the name of the specified lecture.
     * @throws LectureNotExistsException if the specified lecture not exists in the lecture list of this professor object.
     */
    public void subscribe(String lecture) throws LectureNotExistsException {
        if (!existsLecture(lecture)) {
            throw new LectureNotExistsException("Lecture not exists!");
        }
        findLecture(lecture).subscribe();
    }

    /**
     * Method decreases the number of subscriptions of the specified lecture by one.
     *
     * @param lecture - is the name of the specified lecture.
     * @throws LectureNotExistsException if the specified lecture not exists in the lecture list of this professor object.
     */
    public void unsubscribe(String lecture) throws LectureNotExistsException {
        if (!existsLecture(lecture)) {
            throw new LectureNotExistsException("Lecture not exists!");
        }
        findLecture(lecture).unsubscribe();
    }

    /**
     * Method sums up all subscriptions of every lecture from lecture list of this professor object.
     *
     * Private assistance method.
     * @return sum of all subscriptions of every lecture as an integer value.
     * @throws LectureNotEmptyException if the specified lecture of the lecture list of this professor object is not empty.
     */
    public int getSubscriptionsSum() throws LectureNotEmptyException {
        int subs = 0;
        for (Lecture l : getLectureList()) {
            subs += l.getSubscriptions();
        }
        if (subs != 0) {
            throw new LectureNotEmptyException("Lecture is not empty!");
        }
        return subs;
    }

    /**
     * Equals() method obj compares two professor objects.
     *
     * @param obj - is an object, which will be compared with this object.
     * @return true if both objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Professor professor = (Professor) obj;

        return getProfName().equals(professor.getProfName());
    }

    /**
     * Generated hashcode method.
     *
     * @return hashcode of this professor object as an integer value.
     */
    @Override
    public int hashCode() {
        int result = profName.hashCode();
        result = MAGIC_NUM * result + lectureList.hashCode();
        return result;
    }
}
