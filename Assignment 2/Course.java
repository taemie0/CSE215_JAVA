import java.util.ArrayList;;

public class Course {
	public String name, timing;
	public int section;
	public Teacher teacher;
	public Assistant assistant;
	public ArrayList<Student> studentList = new ArrayList<Student>();

	public Course(String name, int section, String timing, Teacher teacher, Assistant assistant) {
		this.name = name;
		this.section = section;
		this.timing = timing;
		this.teacher = teacher;
		teacher.assignedCourseList.add(this);
		this.assistant = assistant;
		assistant.assignedCourseList.add(this);
	}

	public String courseInitial() {
		return name + "." + section;
	}

	public void getInfo() {
		System.out.println(name + " " + section + " " + timing + " " + teacher.name + " " + assistant.name);
	}

	public void viewStudentList() {
		System.out.println("List of Student:");
		if (studentList.size() == 0) {
			System.out.println("No students to show.");
		} else {
			for (int i = 0; i < studentList.size(); i++) {
				System.out.println((i + 1) + " " + studentList.get(i).geDetailedtInfo());
			}
		}
	}
}
