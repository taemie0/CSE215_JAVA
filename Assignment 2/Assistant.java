import java.util.ArrayList;
import java.util.Scanner;

public class Assistant extends User {
	public ArrayList<Course> assignedCourseList = new ArrayList<Course>();
	public static Scanner input = new Scanner(System.in);
	public static int key, key1;

	public Assistant(String email, String password, String id, String name) {
		super(email, password, id, name);

	}

	@Override
	public void handleActions() {
		while (true) {
			System.out.println("1: View Courses 2: Logout");
			System.out.print(">");
			key = input.nextInt();
			if (key == 1) {

				while (true) {
					if (assignedCourseList.size() == 0) {
						System.out.println("No courses to show.");
					}
					CourseManagement.viewCourse(this);
					System.out.print(">");
					key = input.nextInt();
					if ((assignedCourseList.size() + 1) == key) {
						break;
					} else if (key > assignedCourseList.size() || key < 1) {
						System.out.println("Invalid Action!");
					} else {
						while (true) {
							assignedCourseList.get(key - 1).viewStudentList();
							System.out.println("1:Back");
							System.out.print(">");
							key1 = input.nextInt();
							if (key1 == 1) {
								break;
							} else {
								System.out.println("Invalid key!");
							}
						}
					}
				}
			} else if (key == 2) {
				System.out.println("Successfully logged out.");
				break;
			} else {
				System.out.println("Invalid Key.Try Again!");
			}

		}

	}

	public void viewAssignedCourseList() {

		for (int i = 0; i < assignedCourseList.size(); i++) {
			System.out.print((i + 1) + ":" + (assignedCourseList.get(i)).courseInitial() + " ");
		}
		System.out.println((assignedCourseList.size() + 1) + ":Back");
	}

}
