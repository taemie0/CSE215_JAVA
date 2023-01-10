import java.util.ArrayList;
import java.util.Scanner;

public class Student extends User {
	private double cgpa;
	public ArrayList<Course> enrolledCourseList = new ArrayList<Course>();
	public static Scanner input = new Scanner(System.in);
	public static int key;

	public Student(String email, String password, String id, String name, double cgpa) {
		super(email, password, id, name);
		this.cgpa = cgpa;
	}

	public boolean check(Course c) {
		for (int i = 0; i < enrolledCourseList.size(); i++) {
			if ((c.name).equals(enrolledCourseList.get(i).name)) {
				System.out.println("Already added this course.");
				return false;
			}
			if ((c.timing).equals(enrolledCourseList.get(i).timing)) {
				System.out.println("Conflicting Timing.");
				return false;
			}
		}
		return true;
	}

	@Override
	public void handleActions() {
		Session session = Session.getSession();
		Course courseList[] = session.getCourseList();

		while (true) {
			System.out.println("1: Add Course 2: View Courses 3:Logout");
			System.out.print(">");
			key = input.nextInt();
			if (key == 1) {
				while (true) {
					CourseManagement.viewCourse();
					System.out.println("Press 0 to go Back");
					System.out.print("Index of the Course to be added: >");
					key = input.nextInt();
					if (key == 0) {
						break;
					} else if (key < 0 || key > courseList.length) {
						System.out.println("Invalid key");
					} else {
						if (check(courseList[key - 1])) {
							System.out.println("You have been enrolled in “" + courseList[key - 1].courseInitial()
									+ "” Successfully!");
							CourseManagement.addCourse(this, courseList[key - 1]);
						}else {
							System.out.println("Adding course unsuccessful.");
						}
					}
				}
			} else if (key == 2) {
				while (true) {
					CourseManagement.viewCourse(this);
					if (enrolledCourseList.size() == 0) {
						System.out.println("1: Back");
						System.out.print(">");
						key = input.nextInt();
						break;
					}

					System.out.println("1:Remove Course 2: Back");
					System.out.print(">");
					key = input.nextInt();

					if (key == 1) {
						System.out.print("Index of the Course to be removed: >");
						key = input.nextInt();
						if (key > enrolledCourseList.size() || key <= 0) {
							System.out.println("Invalid key!");
						} else {
							System.out.println("You have dropped “" + enrolledCourseList.get(key - 1).courseInitial()
									+ "” Successfully!");
							CourseManagement.removeCourse(this, enrolledCourseList.get(key - 1));
						}
					} else if (key == 2) {
						break;
					} else {
						System.out.println("Invalid key! Try again.");
					}
				}
			} else if (key == 3) {
				System.out.println("Successfully logged out.");
				break;
			} else {
				System.out.println("Invalid Key.Try Again!");
			}
		}

	}

	public void viewEnrolledCourseList() {
		if (enrolledCourseList.size() > 0) {
			for (int i = 0; i < enrolledCourseList.size(); i++) {
				System.out.print((i + 1) + ". ");
				(enrolledCourseList.get(i)).getInfo();
			}
		} else {
			System.out.println("No courses to show.");
		}
	}

	public String geDetailedtInfo() {
		return name + " " + id + " " + email + " " + cgpa;
	}

	public String getInfo() {
		return name + " " + id;
	}

}
