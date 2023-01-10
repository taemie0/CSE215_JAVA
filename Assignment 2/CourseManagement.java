/*
Assignment-2 
CSE215.5(SVA)
Name:Meharun Nesa
*/
public class CourseManagement {
	private static User userList[];
	private static Course courseList[];
	private static Session session = null;

	public static void main(String[] args) {
		while (true) {

			Session session = Session.getSession();
			userList = session.getUserList();
			courseList = session.getCourseList();

			System.out.print("Email:");
			String email = session.inputScanner.next();
			System.out.print("Password:");
			String password = session.inputScanner.next();

			try {
				User user = login(email, password);
				user.handleActions();

			} catch (Exception e) {

				System.out.println(e.getMessage());
				// e.printStackTrace();
			}

		}
	}

	public static void addCourse(Student s, Course c) {
		if (c.studentList.size() >= 5) {
			System.out.println("No seats available!");
		} else {
			c.studentList.add(s);
			s.enrolledCourseList.add(c);
		}
	}

	public static void removeCourse(Student s, Course c) {
		if (c.studentList.size() == 0) {
			System.out.println("No students to remove.");
		} else {
			c.studentList.remove(s);
			s.enrolledCourseList.remove(c);
		}
	}

	public static void viewCourse(User user) {
		if (user instanceof Student) {
			((Student) user).viewEnrolledCourseList();
		} else if (user instanceof Teacher) {
			((Teacher) user).viewAssignedCourseList();
		} else {
			((Assistant) user).viewAssignedCourseList();
		}
	}

	public static void viewCourse() {
		for (int i = 0; i < courseList.length; i++) {
			System.out.print((i + 1) + ". ");
			(courseList[i]).getInfo();
		}
	}

	public static User login(String email, String password) throws Exception {
		for (int i = 0; i < userList.length; i++) {
			if ((userList[i].email).equals(email) && (userList[i].password).equals(password)) {
				return userList[i];
			}
		}
		throw new Exception("User not found");

		// place your login logic here
		// for wrong credential: throw new Exception("User not found");
		// call getMessage() on the exception instance to get the error message
	}

}
