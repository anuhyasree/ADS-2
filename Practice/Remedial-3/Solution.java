import java.util.*;
class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		BinaryST<Student, Double> studentInput = new BinaryST();
		for (int i = 0; i < n; i++) {
			String[] tokens = scan.nextLine().split(",");
			studentInput.put(new Student(tokens[1], Double.parseDouble(tokens[2]),
                Integer.parseInt(tokens[0])),
                Double.parseDouble(tokens[2]));
		}
		int q = Integer.parseInt(scan.nextLine());
		Iterable<Student> studentList = studentInput.keys();

		for (int i = 0; i < q; i++) {
			double marks = Double.parseDouble(scan.nextLine());
			boolean check  = true;
			for (Student stud: studentList) {

			if (studentInput.get(stud) == marks) {
				check = false;
				// innerobj.add(s);
				// obj.add(innerobj);

				System.out.println(stud);
			}
		}
		if (check) {
			System.out.println("This marks are not awarded to any student");
		 }
	}
	}
}