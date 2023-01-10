import java.util.Scanner;

public class Assignment_1 {
	static String[][] studentInfo = { { "2201", "Tesha Akter" }, { "2202", "Sazid Hasan" },
			{ "2203", "Meharun Nesa" } };
	static String[][] teacherInfo = { { "011", "SVA" }, { "012", "RJP" }, { "021", "THR" } };
	static String[][] courseList = { { "CSE173", "1", "RA-09:40AM-11:10AM", "RJP" },
			{ "CSE173", "2", "MW-11:20AM-12:50PM", "SVA" }, { "CSE215", "1", "ST-09:40AM-11:10AM", "SVA" },
			{ "MAT120", "1", "MW-11:20AM-12:50PM", "THR" } };
	static int[][] studentsCourse = new int[3][3]; // Course taken by student
	static int[][] seatInCourse = new int[4][2]; // available seat in course
	static int[][] studentInCourse = new int[4][2]; // Students in a course
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		boolean f = true;
		while (f) {

			System.out.println("1.Login as Student\n2.Login as Teacher\n3.Exit ");
			System.out.println("Enter any key:");
			switch (input.nextInt()) {
			case 1:
				studentWindow();
				break;
			case 2:
				teacherWindow();
				break;
			case 3:
				f = false;
				break;
			default:
				System.out.println("Invalid key!");
			}
		}
		System.out.println("System exited Successfully!");
	}

	public static void studentWindow() {
		System.out.println("Enter your ID:");
		String userId = input.next();
		int serial = findSerial(userId);
		if (serial == -1) {
			System.out.println("User not found.");
		} else {
			boolean f = true;
			while (f) {
				options();
				System.out.println("Enter any key:");
				switch (input.nextInt()) {
				case 1:
					addCourse(serial);
					break;
				case 2:
					dropCourse(serial);
					break;
				case 3:
					viewEnrolledCourses(serial);
					break;
				case 4:
					f = false;
					break;
				default:
					System.out.println("Invalid Key!");
				}
			}
		}
		System.out.println("Exited Succesfully!");
		System.out.println();
	}

	public static void teacherWindow() {
		System.out.println("Enter your ID:");
		String userId = input.next();

		String initial = findTeacherInitial(userId);
		if (initial.equals("-1")) {
			System.out.println("User not found.");
		} else {
			boolean f = true;
			while (f) {
				options1();
				System.out.println("Enter any key:");
				switch (input.nextInt()) {
				case 1:
					assignedCourses(initial);
					break;
				case 2:
					viewStudentsInSection(initial);
					break;
				case 3:
					f = false;
					break;
				default:
					System.out.println("Invalid Key!");
				}
			}
		}
		System.out.println("Exited Succesfully!");
		System.out.println();
	}

	public static void viewCourseList() {
		System.out.println("Course\tSection\t  Timing\t\t Teacher");
		for (int i = 0; i < 50; i++)
			System.out.print("-");
		System.out.println();
		for (int i = 0; i < courseList.length; i++) {
			System.out.println(
					courseList[i][0] + "\t  " + courseList[i][1] + "\t" + courseList[i][2] + "\t  " + courseList[i][3]);
		}
		System.out.println();
	}

	public static void options() { // option menu for student
		System.out.println("1.Add course.\n2.Drop course.\n3.View selected courses.\n4.Exit.");
		System.out.println();
	}

	public static void options1() { // option menu for teacher
		System.out.println("1.Assigned Sections.\n2.View Students in a section.\n3.Exit.");
		System.out.println();
	}

	public static int findSerial(String id) { // finding array serial of student
		for (int i = 0; i < studentInfo.length; i++) {
			if (id.equals(studentInfo[i][0]))
				return i;
		}
		return -1;
	}

	public static String findTeacherInitial(String id) {
		for (int i = 0; i < teacherInfo.length; i++) {
			if (id.equals(teacherInfo[i][0]))
				return teacherInfo[i][1];
		}
		return "-1";
	}

	public static void addCourse(int serial) {
		viewCourseList();
		System.out.println("----Max course limit 3 ----");
		System.out.println("Enter course and section to Add: ");
		String course = input.next();
		String section = input.next();
		int courseIndex = CourseIndex(course, section);
		if (courseIndex == -1) {
			System.out.println("Invalid Course");
		} else {
			int emptySlot = -1;
			for (int i = 0; i < 3; i++) {
				if (studentsCourse[serial][i] == 0) {
					emptySlot = i;
					break;
				}
			}
			if (emptySlot == -1) {
				System.out.println("You can't add anymore courses.");
			} else if (checkTiming(courseList[courseIndex][2], serial)) {
				System.out.println("You can't add this course.");
			} else if (checkCourse(courseList[courseIndex][0], serial)) {
				System.out.println("You have already added this course.");
			} else {
				int x = checkAvailableSeat(courseIndex);
				if (x != -1) {
					studentsCourse[serial][emptySlot] = courseIndex + 1;
					seatInCourse[courseIndex][x] = 1;
					studentInCourse[courseIndex][x] = serial + 1;
					System.out.println("Course added successfully.");
				} else {
					System.out.println("The section is full.\nCan not add the course! ");
				}
			}
		}
		System.out.println();
	}

	public static int CourseIndex(String course, String section) { // searching course index with course name and
																	// section
		for (int i = 0; i < courseList.length; i++) {
			if (course.equals(courseList[i][0]) && section.equals(courseList[i][1]))
				return i;
		}
		return -1;
	}

	public static boolean checkTiming(String time, int serial) { // checking if time is clashing with another course
		for (int i = 0; i < 3; i++) {
			int x = studentsCourse[serial][i];
			if (x != 0) {
				if (time.equals(courseList[x - 1][2]))
					return true;
			}
		}
		return false;
	}

	public static int checkAvailableSeat(int courseIndex) { // checking available seat in a course
		for (int i = 0; i < 2; i++) {
			if (seatInCourse[courseIndex][i] == 0)
				return i;
		}
		return -1;
	}

	public static boolean checkCourse(String course, int serial) { // checking if same course is already taken
		for (int i = 0; i < 3; i++) {
			int x = studentsCourse[serial][i];
			if (x != 0) {
				if (course.equals(courseList[x - 1][0]))
					return true;
			}
		}
		return false;
	}

	public static void dropCourse(int serial) {
		viewEnrolledCourses(serial);
		System.out.println("Enter course and section to Drop:");
		String course = input.next();
		String section = input.next();
		int courseIndex = CourseIndex(course, section);
		if (courseIndex == -1) {
			System.out.println("Invalid Course");
		} else {
			for (int i = 0; i < 3; i++) {
				if (studentsCourse[serial][i] == courseIndex + 1) {
					int x = findStudentInCourse(courseIndex, serial);
					if (x == -1) {
						System.out.println("Course could not be dropped.");
						break;
					}
					studentsCourse[serial][i] = 0;
					seatInCourse[courseIndex][x] = 0;
					System.out.println("Course dropped successfully.");
					break;
				}
			}
		}
		System.out.println();
	}

	public static int findStudentInCourse(int courseIndex, int serial) { // finding the students occupied seat in course
		for (int i = 0; i < 2; i++) {
			if (studentInCourse[courseIndex][i] == serial + 1)
				return i;
		}
		return -1;
	}

	public static void viewEnrolledCourses(int serial) {
		System.out.println("Course\tSection\t  Timing\t\tTeacher");
		for (int i = 0; i < 50; i++)
			System.out.print("-");
		System.out.println();
		for (int i = 0; i < 3; i++) {
			int x = studentsCourse[serial][i];
			if (x != 0) {
				System.out.println(courseList[x - 1][0] + "\t  " + courseList[x - 1][1] + "\t" + courseList[x - 1][2]
						+ "\t" + courseList[x - 1][3]);
			}
		}
		System.out.println();
	}

	public static void assignedCourses(String initial) {
		System.out.println("Course\tSection\t  Timing");
		for (int i = 0; i < 50; i++)
			System.out.print("-");
		System.out.println();
		for (int i = 0; i < courseList.length; i++) {
			if (courseList[i][3].equals(initial)) {
				System.out.println(courseList[i][0] + "\t  " + courseList[i][1] + "\t" + courseList[i][2]);
			}
		}
		System.out.println();
	}

	public static void viewStudentsInSection(String initial) {
		assignedCourses(initial);
		System.out.println("Enter course and section: ");
		String course = input.next();
		String section = input.next();
		int courseIndex = CourseIndex(course, section);
		boolean f = true;
		if (courseIndex == -1) {
			System.out.println("Course not found.");
		} else if (courseList[courseIndex][3] != initial) {
			System.out.println("Course not found");
		} else {
			System.out.println("Student Name\t\tStudent ID");
			for (int i = 0; i < 50; i++)
				System.out.print("-");
			System.out.println();
			for (int i = 0; i < 2; i++) {
				if (seatInCourse[courseIndex][i] != 0) {
					int x = studentInCourse[courseIndex][i];
					System.out.println(studentInfo[x - 1][0] + "\t\t\t" + studentInfo[x - 1][1]);
					f = false;
				}
			}
			if (f)
				System.out.println("No Students in this section Yet.");
		}
		System.out.println();
	}
}
