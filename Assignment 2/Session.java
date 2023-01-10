import java.util.Scanner;

class Session {
	private static Session session = null;
	private static User userList[] = new User[7];
	private static Course courseList[] = new Course[6];
	public Scanner inputScanner = new Scanner(System.in);

	private Session() {
		createDatabase();
	}

	private static void createDatabase() {
		userList[0] = new Student("student_a@northsouth.edu", "password", "S1", "A", 3.4);
		userList[1] = new Student("student_b@northsouth.edu", "password", "S2", "B", 3.6);
		userList[2] = new Student("student_c@northsouth.edu", "password", "S3", "C", 3.2);
		userList[3] = new Teacher("teacher_a@northsouth.edu", "password", "T1", "A");
		userList[4] = new Teacher("teacher_b@northsouth.edu", "password", "T2", "B");
		userList[5] = new Assistant("assistant_a@northsouth.edu", "password", "A1", "A");
		userList[6] = new Assistant("assistant_b@northsouth.edu", "password", "A2", "B");

		courseList[0] = new Course("Course A", 1, "A", (Teacher) userList[3], (Assistant) userList[5]);
		courseList[1] = new Course("Course A", 2, "A", (Teacher) userList[4], (Assistant) userList[5]);
		courseList[2] = new Course("Course A", 3, "B", (Teacher) userList[3], (Assistant) userList[6]);
		courseList[3] = new Course("Course B", 1, "A", (Teacher) userList[3], (Assistant) userList[5]);
		courseList[4] = new Course("Course C", 1, "B", (Teacher) userList[4], (Assistant) userList[5]);
		courseList[5] = new Course("Course C", 2, "C", (Teacher) userList[3], (Assistant) userList[6]);
	}

	public static Session getSession() {
		if (session == null)
			session = new Session();
		return session;
	}

	public Course[] getCourseList() {
		return courseList;
	}

	public User[] getUserList() {
		return userList;
	}

}
