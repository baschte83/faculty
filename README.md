# Faculty

### Assignment, class and language
This is the solution to the assignment **Faculty** of class **software developement 2,** written in Java with my two team members Korbinian Karl (@korbster) and Ehsan Moslehi (@eca852).

### Requirements
This assignment required handling lists of the java collection framework. We should also practice working with packages and code analysing tools, writing JUnit tests, learn how **test driven developement** works and taking first steps working with a version control system (in our case: working with Subversion). This program consists of 10 classes: interface **IFaculty,** class **Faculty,**, class **Professor,** class **Lecture,** a test class **FacultyTest** and several exception classes **FacultyException, ProfessorExistsException, ProfessorNotExistsException, LectureNotEmptyException** and **LectureNotExistsException**. The objective of this task was to write a tiny program to organize lectures, professors and faculties of a university and to reach complete path coverage with our JUnit tests. 

#### Interface IFaculty
This interface was given by the professor. We had to do no modifications to this class.

#### Class Faculty
Objects of this class can have any number of **professors** and organizes them in a list of the collection framework. This class implements the interface **IFaculty**. It represents a faculty of a university. It should be possible to create and delete professors, to determine, if any professors exist in the faculty, to create and assign lectures to a certain professor, to determine, if there are any lectures in the lecture list of a professor, to remove a certain lecture of the lecture list of a certain professor, to subscribe and unsubscribe a participant to or of a certain lecture of a certain professor and to get the number of suscriptions of a certain lecture of a certain professor.

#### Class Professor
Objects of this class can have any number of **lectures** and organizes them in a list of the collection framework.
 
#### Class Lecture
Students can subscribe or unsubscribe to any existing lecture object. In our program there is no class called **Student**, but we have to write JUnit tests and some of the tests behave like students and subscribe or unsibscribe to a certain lecture. It doesn't matter that there is no student in this program. What matters is the fact whether there are any subscriptions to a lecture or not.

#### Class FacultyTest
This class is our JUnit test class and checks our whole program. To write this class was one of my main tasks for this program.
