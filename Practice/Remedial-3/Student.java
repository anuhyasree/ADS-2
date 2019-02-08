class Student implements Comparable<Student> {
	Student() {

	}
	private String name;
	private int roll;
	private double marks;
	public Student(final String name, final double marks, final int roll) {
		this.roll = roll;
		this.name = name;
		this.marks = marks;
	}
	public String getName() {
		return this.name;
	}
	public int getRoll() {
		return this.roll;
	}
	public double getMarks() {
		return this.marks;
	}
	public String toString() {
		return this.roll + "," + this.name + "," + this.marks;	
	}
	public int compareTo(Student that) {
		if (this.marks > that.marks) {
			return 1;
		} else if (this.marks < that.marks) {
			return -1;			
			}
			else if (this.marks == that.marks) {
				if (this.name.compareTo(that.name) > 0) {
					return 1;
				}
				if (this.name.compareTo(that.name) < 0) {
					return -1;
				}
				if(this.name.compareTo(that.name) == 0)
				{if (this.roll > that.roll) {
 					return 1;
 				} else if (this.roll < that.roll) {
 					return -1;
 				}} 
			}
		
		return 0;
       }
}