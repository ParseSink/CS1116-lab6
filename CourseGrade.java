
public class CourseGrade {

	private String semester;
	private String courseNumber;
	private char letterGrade;

	public CourseGrade(String sem, String cor, char let) {
		setSemester(sem);
		setCourseNumber(cor);
		setLetterGrade(let);
	}

	public String getSemester() {
		return semester;
	}

	public String getCourseNumber() {
		return courseNumber;
	}

	public char getLetterGrade() {
		return letterGrade;
	}

	public void setSemester(String sem) {
		semester = sem;
	}

	public void setCourseNumber(String cor) {
		courseNumber = cor;
	}

	public void setLetterGrade(char let) {
		letterGrade = let;
	}
}
