import java.text.DecimalFormat;

public class Transcript {

	private int studentID;
	private CourseGrade[] grades;

	public Transcript(int id) {
		studentID = id;
		grades = new CourseGrade[100];
	}
	// Please implement the following methods following the description in the assignment.
public boolean addCourseGrade(CourseGrade grade) {
    //look for empty spot then create a deep copy to modify the array.
    for (int i = 0; i < grades.length; i++) {
        if (grades[i] == null) {
            // deep copy array
            CourseGrade copy = new CourseGrade(grade.getSemester(), grade.getCourseNumber(), grade.getLetterGrade());
            grades[i] = copy;
            return true;
        }
    }
    return false;
}
public CourseGrade[] getCourseGrades(String sem) {
	// find length of class list (n)
    int count = 0;
    for (int i = 0; i < grades.length; i++) {
        if (grades[i] != null && grades[i].getSemester().equals(sem)) {
            count++;
        }
    }
    //create an array of n length
    CourseGrade[] matchingGrades = new CourseGrade[count];
    //loop to preform a deep copy of the changes
    int newIndex = 0;
    for (int i = 0; i < grades.length; i++) {
        if (grades[i] != null && grades[i].getSemester().equals(sem)) {
            CourseGrade copy = new CourseGrade(grades[i].getSemester(), grades[i].getCourseNumber(), grades[i].getLetterGrade());
            matchingGrades[newIndex] = copy;
            newIndex++;
        }
    }
    return matchingGrades;
}
public double getGPA() {
    double totalPoints = 0.0;
    int totalCredits = 0;
    for (int i = 0; i < grades.length; i++) {
        if (grades[i] != null) {
            char letter = grades[i].getLetterGrade();
            if (letter != 'I') {
                totalCredits += 3;
                if (letter == 'A') totalPoints += (4 * 3);
                else if (letter == 'B') totalPoints += (3 * 3);
                else if (letter == 'C') totalPoints += (2 * 3);
                else if (letter == 'D') totalPoints += (1 * 3);
                else if (letter == 'E') totalPoints += (0 * 3);
            }
        }
    }
    if (totalCredits == 0) {
        return 0.0;
    }
    return totalPoints / totalCredits; 
}
public String toString() {
    DecimalFormat df = new DecimalFormat("0.0#");
    String result = "SID " + studentID + " GPA=" + df.format(getGPA()) + "\n";
    for (int i = 0; i < grades.length; i++) {
        if (grades[i] != null) {
            result += grades[i].getSemester() + " " + grades[i].getCourseNumber() + " " + grades[i].getLetterGrade() + "\n";
        }
    }
    return result;
}
	
	////////////////////////////////////////////////////////////////////////
	////////////////////   Don't change anything below  ////////////////////
	////////////////////////////////////////////////////////////////////////

	public static void main(String[] args) {

		System.out.println("Let's create a transcript for Jason, whose ID is 123456.");
		CourseGrade courseGrade1 = new CourseGrade("2020F", "CS331", 'I');
		CourseGrade courseGrade2 = new CourseGrade("2020F", "CS330", 'B');
		CourseGrade courseGrade3 = new CourseGrade("2020F", "MATH151", 'A');
		CourseGrade courseGrade4 = new CourseGrade("2021S", "CS425", 'I');
		CourseGrade courseGrade5 = new CourseGrade("2021S", "CS331", 'D');
		CourseGrade courseGrade6 = new CourseGrade("2021S", "MATH152", 'B');

		Transcript jason = new Transcript(123456);
		jason.addCourseGrade(courseGrade1);
		jason.addCourseGrade(courseGrade2);
		jason.addCourseGrade(courseGrade3);
		jason.addCourseGrade(courseGrade4);
		jason.addCourseGrade(courseGrade5);
		jason.addCourseGrade(courseGrade6);

		System.out.println(jason);
		System.out.println("********************************************************");
		System.out.println("Let's look at Jason's grades in 2021S.");

		Transcript jason_2021S = new Transcript(123456);
		for (CourseGrade cg : jason.getCourseGrades("2021S")) {
			jason_2021S.addCourseGrade(cg);
		}
		System.out.println(jason_2021S);

		System.out.println("********************************************************");

		System.out.println("Let's test whether deep copy is used in the getCourseGrade method.");
		System.out.println("If deep copy is NOT used, the following code will change all Jason's grade to A.");

		for (CourseGrade cg : jason.getCourseGrades("2020F")) {
			cg.setLetterGrade('A');
		}
		
		for (CourseGrade cg : jason.getCourseGrades("2021S")) {
			cg.setLetterGrade('A');
		}

		System.out.println(jason);

		System.out.println("********************************************************");

		System.out.println("Next, let's add more course grades to Jason's transcript.");
		CourseGrade courseGrade13 = new CourseGrade("2021F", "CS425", 'E');
		CourseGrade courseGrade14 = new CourseGrade("2021F", "HUM390", 'A');
		CourseGrade courseGrade15 = new CourseGrade("2021F", "MATH251", 'B');
		CourseGrade courseGrade16 = new CourseGrade("2021F", "PSYC303", 'A');
		CourseGrade courseGrade17 = new CourseGrade("2021F", "CS430", 'C');

		jason.addCourseGrade(courseGrade13);
		jason.addCourseGrade(courseGrade14);
		jason.addCourseGrade(courseGrade15);
		jason.addCourseGrade(courseGrade16);
		jason.addCourseGrade(courseGrade17);

		System.out.println(jason);

		System.out.println("********************************************************");

		System.out.println("In the end, let's create a transcript for Jamie who hasn't completed any course.");
		CourseGrade courseGrade7 = new CourseGrade("2020F", "CS331", 'I');
		CourseGrade courseGrade8 = new CourseGrade("2020F", "CS330", 'I');
		CourseGrade courseGrade9 = new CourseGrade("2020F", "MATH151", 'I');
		CourseGrade courseGrade10 = new CourseGrade("2021S", "CS425", 'I');
		CourseGrade courseGrade11 = new CourseGrade("2021S", "CS331", 'I');
		CourseGrade courseGrade12 = new CourseGrade("2021S", "MATH152", 'I');

		Transcript jamie = new Transcript(654321);
		jamie.addCourseGrade(courseGrade7);
		jamie.addCourseGrade(courseGrade8);
		jamie.addCourseGrade(courseGrade9);
		jamie.addCourseGrade(courseGrade10);
		jamie.addCourseGrade(courseGrade11);
		jamie.addCourseGrade(courseGrade12);

		System.out.println(jamie);
	}

}
