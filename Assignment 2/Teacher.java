import java.util.ArrayList;
import java.util.Scanner;

public class Teacher extends User{
	public  ArrayList<Course> assignedCourseList = new ArrayList<Course>();
	public static Scanner input = new Scanner(System.in);
	public static int key, key1;

	public Teacher(String email, String password, String id, String name) {
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
					CourseManagement.viewCourse(this);
					System.out.print(">");
					key = input.nextInt();
					if ((assignedCourseList.size() + 1) == key) {
						break;
					} else if(key>assignedCourseList.size() || key<1) {
						System.out.println("Invalid Action!");
					}
					else {
						while (true) {
							int totalStudent=(assignedCourseList.get(key - 1)).studentList.size();
							assignedCourseList.get(key - 1).viewStudentList();
							
							System.out.println("1: Remove Student 2:Back");
							System.out.print(">");
							key1 = input.nextInt();
							if (key1 == 2) {
								break;
							}else {
								System.out.print("Index of Student to be removed:>");
								key1 = input.nextInt();
								if(key1>totalStudent || key1<totalStudent || totalStudent==0) {
									System.out.println("Invalid Action.");
								} else {
								Student s=(assignedCourseList.get(key - 1)).studentList.get(key1 - 1);
								Course c=assignedCourseList.get(key - 1);
								System.out.println("Student“"+s.getInfo()+"”Removed From Your Course-"+c.courseInitial()+" Successfully!");
								CourseManagement.removeCourse(s,c);
								}
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
