import exceptions.LectureNotEmptyException;
import exceptions.LectureNotExistsException;
import exceptions.ProfessorExistsException;
import exceptions.ProfessorNotExistsException;
import org.junit.*;

import static org.junit.Assert.*;
/**
 * @author Sebastian Baumann, Korbinian Karl, Seyed Ehsan Moslehi
 */
public class FacultyTest {

    private Faculty hm1 = new Faculty();

    /* Erstellt alle Elemente, die benötigt werden bevor eine bestimmte
     * Testmethode ausgeführt werden kann.
     */
    @Before
    public void setUp() throws Exception, ProfessorExistsException, ProfessorNotExistsException {
        hm1.createProfessor("Thomas Meier");
        hm1.createLecture("Thomas Meier", "Netzwerke 1");
    }

    /**
     * @throws Exception if no other exception is thrown.
     * @throws ProfessorExistsException if a professor already exists.
     */
    @Test
    public void testCreateProfessor() throws Exception, ProfessorExistsException {
        hm1.createProfessor("Hans");
        assertTrue(hm1.existsProfessor("Hans"));
    }

    /**
     * @throws Exception if no other exception is thrown.
     * @throws ProfessorExistsException if a professor already exists.
     */
    @Test (expected = ProfessorExistsException.class)
    public void testDuplicateCreateProfessor() throws Exception, ProfessorExistsException {
        hm1.createProfessor("Hans");
        hm1.createProfessor("Hans");
    }

    /**
     * author: Korbinian Karl
     * @throws Exception if no other exception is thrown.
     * @throws ProfessorExistsException if a professor already exists.
     */
    @Test (expected = NullPointerException.class)
    public void testNullCreateProfessor() throws Exception, ProfessorExistsException {
        hm1.createProfessor(null);
    }

    /**
     * @throws ProfessorExistsException if a professor already exists.
     */
    @Test
    public void testExistsProfessor_isTrue() throws ProfessorExistsException {
        // Test1: True, falls ein bestimmter Professor existiert
        assertTrue(hm1.existsProfessor("Thomas Meier"));
    }

    /**
     * @throws ProfessorExistsException if a professor already exists.
     */
    @Test
    public void testExistsProfessor_isFalse() throws ProfessorExistsException{
        // Test2: False, falls ein bestimmter Professor nicht existiert
        assertFalse(hm1.existsProfessor("Max Muster"));
    }

    /**
     * @throws ProfessorExistsException if a professor already exists.
     * @throws ProfessorNotExistsException if a professor doesn't exist.
     * @throws LectureNotEmptyException if a lecture is not empty.
     * @throws LectureNotExistsException if a lecture doesn't exist.
     */
    @Test
    public void testDeleteProfessor_hasNoLectures_isSuccessful() throws ProfessorExistsException, ProfessorNotExistsException, LectureNotEmptyException, LectureNotExistsException {
        // Test1: Kann gelöscht werden, da er existiert und keine Lecture hält
        hm1.deleteLecture("Thomas Meier", "Netzwerke 1");
        hm1.deleteProfessor("Thomas Meier");
        assertFalse(hm1.existsProfessor("Thomas Meier"));
    }

    /**
     * @throws ProfessorNotExistsException if a professor doesn't exist.
     * @throws LectureNotEmptyException if a lecture is not empty.
     * @throws ProfessorExistsException if a professor already exists.
     */
    @Test
    public void testDeleteProfessor_isSuccessful() throws ProfessorNotExistsException, LectureNotEmptyException, ProfessorExistsException {
        // Test2: Kann gelöscht werden, da er existiert und eine Lecture hält, in der aber niemand eingeschrieben ist
        hm1.createProfessor("Korbinian Karl");
        hm1.deleteProfessor("Thomas Meier");
        assertFalse(hm1.existsProfessor("Thomas Meier"));
    }

    /**
     * @throws ProfessorNotExistsException if a professor doesn't exist.
     * @throws LectureNotEmptyException if a lecture is not empty.
     */
    @Test(expected = ProfessorNotExistsException.class)
    public void testDeleteProfessor_throwsProfessorNotExistsException() throws ProfessorNotExistsException, LectureNotEmptyException {
        //Exception, da Professor nicht existiert (-> ProfessorNotExistsException)
        hm1.deleteProfessor("Max Muster");
    }

    /**
     * @throws LectureNotEmptyException if a lecture is not empty.
     * @throws ProfessorNotExistsException if a professor doesn't exist.
     * @throws LectureNotExistsException if a lecture doesn't exist.
     * @throws ProfessorExistsException if a professor already exists.
     */
    @Test(expected = LectureNotEmptyException.class)
    public void testDeleteProfessor_throwsLectureNotEmptyExceptionr() throws ProfessorNotExistsException, LectureNotEmptyException, LectureNotExistsException, ProfessorExistsException {
        // Test4: Exception, da Professor zwar existiert, aber noch jemand in eine seiner Lectures eingeschrieben ist (-> LectureNotEmptyException)
        hm1.subscribe("Thomas Meier", "Netzwerke 1");
        hm1.deleteProfessor("Thomas Meier");
    }

    /**
     * @throws ProfessorNotExistsException if a professor doesn't exist.
     * @throws ProfessorExistsException if a professor already exists.
     */
    @Test
    public void testCreateLecture_isSuccessful() throws ProfessorNotExistsException, ProfessorExistsException {
        // Test1: Erfolgreiches erzeugen der Lecture, da Professor existiert
        assertTrue(hm1.existsLecture("Thomas Meier", "Netzwerke 1"));
    }

    /**
     * @throws ProfessorNotExistsException if a professor doesn't exist.
     */
    @Test(expected = ProfessorNotExistsException.class)
    public void testCreateLecture_throwsProfessorNotExistsException() throws ProfessorNotExistsException {
        // Test2: Exception, da Professor nicht existiert (->ProfessorNotExistsException)
        hm1.createLecture("Max Muster", "Netzwerke 1");
    }

    /**
     * @throws ProfessorExistsException if a professor already exists.
     * @throws ProfessorNotExistsException if a professor doesn't exist.
     */
    @Test
    public void testExistsLecture_isTrue() throws ProfessorExistsException, ProfessorNotExistsException {
        // Test1: True, da Professor existiert UND Lecture existiert
        assertTrue(hm1.existsLecture("Thomas Meier", "Netzwerke 1"));
    }

    /**
     * author: Sebastian Baumann
     * @throws ProfessorExistsException if a professor already exists.
     * @throws ProfessorNotExistsException if a professor doesn't exist.
     */
    @Test
    public void testExistsLecture_noLecture_isFalse() throws ProfessorExistsException, ProfessorNotExistsException {
        // Test2: False, da Professor existiert ABER Lecture nicht existiert
        assertFalse(hm1.existsLecture("Thomas Meier", "Netzwerke 2"));
    }

    /**
     * @throws ProfessorNotExistsException if a professor doesn't exist.
     */
    @Test(expected = ProfessorNotExistsException.class)
    public void testExistsLecture_isFalse() throws ProfessorNotExistsException {
        // Test3: Exception, da Professor nicht existiert (-> ProfessorNotExistsException)
        hm1.existsLecture("Max Muster", "Netzwerke 1");
    }

    /**
     * @throws ProfessorNotExistsException if a professor doesn't exist.
     * @throws ProfessorExistsException if a professor already exists.
     * @throws LectureNotExistsException if a lecture doesn't exist.
     * @throws LectureNotEmptyException if a lecture is not empty.
     */
    @Test
    public void testDeleteLecture_isSuccessful() throws ProfessorNotExistsException, ProfessorExistsException, LectureNotExistsException, LectureNotEmptyException {
        // Test1: Löscht das erste Vorkommen der Lecture eines Professors, da Professor UND Lecture existieren und Lecture leer ist (niemand hat sich eingeschrieben)
        hm1.deleteLecture("Thomas Meier", "Netzwerke 1");
        assertFalse(hm1.existsLecture("Thomas Meier", "Netzwerke 1"));
    }

    /**
     * @throws ProfessorNotExistsException if a professor doesn't exist.
     * @throws LectureNotEmptyException if a lecture is not empty.
     * @throws LectureNotExistsException if a lecture doesn't exist.
     */
    @Test(expected = ProfessorNotExistsException.class)
    public void testDeleteLecture_throwsProfessorNotExistsException() throws ProfessorNotExistsException, LectureNotEmptyException, LectureNotExistsException {
        // Test2: Exception, da Professor nicht existiert (-> ProfessorNotExistsException)
        hm1.deleteLecture("Max Muster", "Netzwerke 1");
    }

    /**
     * @throws ProfessorNotExistsException if a professor doesn't exist.
     * @throws LectureNotEmptyException if a lecture is not empty.
     * @throws LectureNotExistsException if a lecture doesn't exist.
     * @throws ProfessorExistsException if a professor already exists.
     */
    @Test(expected = LectureNotExistsException.class)
    public void testDeleteLecture_throwsLectureNotExistsException() throws ProfessorNotExistsException, LectureNotEmptyException, LectureNotExistsException, ProfessorExistsException {
        // Test3: Exception, da Professor existiert ABER Lecture nicht existiert (-> LectureNotExistsException)
        hm1.deleteLecture("Thomas Meier", "Netzwerke 2");
    }

    /**
     * @throws ProfessorNotExistsException if a professor doesn't exist.
     * @throws LectureNotExistsException if a lecture doesn't exist.
     * @throws ProfessorExistsException if a professor already exists.
     * @throws LectureNotEmptyException if a lecture is not empty.
     */
    @Test(expected = LectureNotEmptyException.class)
    public void testDeleteLecture_throwsLectureNotEmptyException() throws ProfessorNotExistsException, LectureNotExistsException, ProfessorExistsException, LectureNotEmptyException {
        // Test4: Exception, da Professor existiert, Lecture existiert ABER Lecture NICHT LEER (-> LectureNotEmptyException)
        hm1.subscribe("Thomas Meier", "Netzwerke 1");
        hm1.deleteLecture("Thomas Meier", "Netzwerke 1");
    }

    /**
     * @throws ProfessorExistsException if a professor already exists.
     * @throws ProfessorNotExistsException if a professor doesn't exist.
     * @throws LectureNotExistsException if a lecture doesn't exist.
     */
    @Test
    public void testSubscribe_isSuccessful() throws ProfessorExistsException, ProfessorNotExistsException, LectureNotExistsException {
        // Test1: Participant wird eingeschrieben, da Professor existiert UND Lecture existiert
        hm1.subscribe("Thomas Meier", "Netzwerke 1");
        assertEquals(hm1.subscriptions("Thomas Meier", "Netzwerke 1"), 1);
    }

    /**
     * @throws ProfessorNotExistsException if a professor doesn't exist.
     * @throws LectureNotExistsException if a lecture doesn't exist.
     */
    @Test(expected = ProfessorNotExistsException.class)
    public void testSubscribe_throwsProfessorNotExistsException() throws ProfessorNotExistsException, LectureNotExistsException {
        // Test2: Exception, da Professor nicht existiert (-> ProfessorNotExistsException)
        hm1.subscribe("Max Muster", "Netzwerke 1");
    }

    /**
     * @throws ProfessorExistsException if a professor already exists.
     * @throws ProfessorNotExistsException if a professor doesn't exist.
     * @throws LectureNotExistsException if a lecture doesn't exist.
     */
    @Test(expected = LectureNotExistsException.class)
    public void testSubscribe_throwsLectureNotExistsException() throws ProfessorExistsException, ProfessorNotExistsException, LectureNotExistsException {
        // Test3: Exception, da Professor existiert ABER Lecture nicht existiert (-> LectureNotExistsException)
        hm1.subscribe("Thomas Meier", "Netzwerke 2");
    }

    /**
     * @throws ProfessorNotExistsException if a professor doesn't exist.
     * @throws ProfessorExistsException if a professor already exists.
     * @throws LectureNotExistsException if a lecture doesn't exist.
     */
    @Test
    public void testUnsubscribe_isSuccessful() throws ProfessorNotExistsException, ProfessorExistsException, LectureNotExistsException {
        // Test1: Participant wird ausgetragen, da Professor existiert und Lecture existiert und Lecture nicht leer ist
        hm1.subscribe("Thomas Meier", "Netzwerke 1");
        hm1.unsubscribe("Thomas Meier", "Netzwerke 1");
        assertEquals(hm1.subscriptions("Thomas Meier", "Netzwerke 1"), 0);
    }

    /**
     * @throws ProfessorNotExistsException if a professor doesn't exist.
     * @throws LectureNotExistsException if a lecture doesn't exist.
     * @throws ProfessorExistsException if a professor already exists.
     */
    @Test
    public void testUnsubscribe_nothingHappens() throws ProfessorNotExistsException, LectureNotExistsException, ProfessorExistsException {
        // Test2: Participant wird nicht ausgetragen (nichts passiert), da Professor existiert und Lecture existiert aber Lecture leer ist
        int subs = hm1.subscriptions("Thomas Meier", "Netzwerke 1");
        hm1.unsubscribe("Thomas Meier", "Netzwerke 1");
        assertEquals(hm1.subscriptions("Thomas Meier", "Netzwerke 1"), subs);
    }

    /**
     * @throws ProfessorNotExistsException if a professor doesn't exist.
     * @throws LectureNotExistsException if a lecture doesn't exist.
     */
    @Test(expected = ProfessorNotExistsException.class)
    public void testUnsubscribe_throwsProfessorNotExistsException() throws ProfessorNotExistsException, LectureNotExistsException {
        // Test3: Exception, da Professor nicht existiert (-> ProfessorNotExistsException)
        hm1.unsubscribe("Max Muster", "Netzwerke 1");
    }

    /**
     * @throws ProfessorNotExistsException if a professor doesn't exist.
     * @throws LectureNotExistsException if a lecture doesn't exist.
     * @throws ProfessorExistsException if a professor already exists.
     */
    @Test(expected = LectureNotExistsException.class)
    public void testUnsubscribe_throwsLectureNotExistsException() throws ProfessorNotExistsException, LectureNotExistsException, ProfessorExistsException {
        // Test4: Exception, da Professor existiert, aber Lecture nicht existiert (-> LectureNotExistsException)
        hm1.unsubscribe("Thomas Meier", "Netzwerke 2");
    }

    /**
     *
     * @throws ProfessorNotExistsException if a professor doesn't exist.
     * @throws LectureNotExistsException if a lecture doesn't exist.
     */
    @Test
    public void testSubscriptions_isSuccessful() throws ProfessorNotExistsException, LectureNotExistsException {
        // Test1: Zeigt an, wie viele Participants eingeschrieben, da Professor existiert und Lecture existiert
        for (int i = 0; i < 10; i++) {
            hm1.subscribe("Thomas Meier", "Netzwerke 1");
        }
        assertEquals(hm1.subscriptions("Thomas Meier", "Netzwerke 1"), 10);
    }

    /**
     *
     * @throws ProfessorNotExistsException if a professor doesn't exist.
     * @throws LectureNotExistsException if a lecture doesn't exist.
     */
    @Test(expected = ProfessorNotExistsException.class)
    public void testSubscriptions_throwsProfessorNotExistsException() throws ProfessorNotExistsException, LectureNotExistsException {
        // Test2: Exception, wenn Professor nicht existiert (-> ProfessorNotExistsException)
        hm1.subscriptions("Max Muster", "Netzwerke 1");
    }

    /**
     *
     * @throws ProfessorNotExistsException if a professor doesn't exist.
     * @throws LectureNotExistsException if a lecture doesn't exist.
     * @throws ProfessorExistsException if a professor already exists.
     */
    @Test(expected = LectureNotExistsException.class)
    public void testSubscriptions_throwsLectureNotExistsException() throws ProfessorNotExistsException, LectureNotExistsException, ProfessorExistsException {
        // Test3: Exception, wenn Professor existiert und Lecture nicht existiert (-> LectureNotExistsException)
        hm1.subscriptions("Thomas Meier", "Netzwerke 2");
    }
}
