
// TODO: Auto-generated Javadoc
/**
 * The Class Employee.
 */
public class Employee {
	
	/** The fname. */
	private String fname;
	
	/** The lname. */
	private String lname;
	
	/** The ssn. */
	private String SSN;
	
	/** The age. */
	private int age;
	
	/** The pronouns. */
	private String pronouns;
	
	/** The salary. */
	private double salary;
	
	/** The years. */
	private int years;
	
	/** The dept. */
	private String dept;
	
	/** The emp ID. */
	private int empID;
	
	public final static int oneHund = 100;
	public final static double oneHundred = 100.00;


/**
 * Instantiates a new employee.
 *
 * @param fname the fname
 * @param lname the lname
 * @param SSN the ssn
 * @param age the age
 * @param pronouns the pronouns
 * @param salary the salary
 * @param years the years
 * @param dept the dept
 * @param empID the emp ID
 */
public Employee (String fname, String lname, String SSN, int age, String pronouns,  double salary, int years, String dept, int empID) {
	this.fname = fname;
	this.lname = lname;
	this.SSN = SSN;
	this.age = age;
	this.pronouns = pronouns;
	this.salary = salary;
	this.years = years;
	this.dept = dept;
	this.empID = empID;
}


/**
 * Gets the fname.
 *
 * @return the fname
 */
public String getFname() {
	return fname;
}


/**
 * Sets the fname.
 *
 * @param fname the new fname
 */
public void setFname(String fname) {
	this.fname = fname;
}


/**
 * Gets the lname.
 *
 * @return the lname
 */
public String getLname() {
	return lname;
}


/**
 * Sets the lname.
 *
 * @param lname the new lname
 */
public void setLname(String lname) {
	this.lname = lname;
}


/**
 * Gets the age.
 *
 * @return the age
 */
public int getAge() {
	return age;
}


/**
 * Sets the age.
 *
 * @param age the new age
 */
public void setAge(int age) {
	this.age = age;
}


/**
 * Gets the pronouns.
 *
 * @return the pronouns
 */
public String getPronouns() {
	return pronouns;
}


/**
 * Sets the pronouns.
 *
 * @param pronouns the new pronouns
 */
public void setPronouns(String pronouns) {
	this.pronouns = pronouns;
}


/**
 * Gets the dept.
 *
 * @return the dept
 */
public String getDept() {
	return dept;
}


/**
 * Sets the dept.
 *
 * @param dept the new dept
 */
public void setDept(String dept) {
	this.dept = dept;
}


/**
 * Gets the salary.
 *
 * @return the salary
 */
public double getSalary() {
	return salary;
}


/**
 * Sets the salary.
 *
 * @param salary the new salary
 */
public void setSalary(double salary) {
	this.salary = salary;
}


/**
 * Gets the years.
 *
 * @return the years
 */
public int getYears() {
	return years;
}


/**
 * Sets the years.
 *
 * @param years the new years
 */
public void setYears(int years) {
	this.years = years;
}


/**
 * Gets the ssn.
 *
 * @return the ssn
 */
public String getSSN() {
	return SSN;
}


/**
 * Sets the ssn.
 *
 * @param sSN the new ssn
 */
public void setSSN(String sSN) {
	SSN = sSN;
}



/**
 * Gets the emp ID.
 *
 * @return the emp ID
 */
public int getEmpID() {
	return empID;
}


/**
 * Sets the emp ID.
 *
 * @param empID the new emp ID
 */
public void setEmpID(int empID) {
	this.empID = empID;
}


/**
 * Returns the salary as a fixed point string (with two decimal places).
 * This eliminates the problems where large floating point numbers get
 * converted to scientific notation when writing to a file, to the console, or
 * as part of a string to be displayed in the view. Updated the toString() method
 * to call this to get the Salary.
 *
 * @return the fixed point salary
 */
public String getFixedPointSalary() {
	return String.format(String.format("%.2f",((long) (salary*oneHund)/oneHundred)));
}


/**
 * To string.
 *
 * @return the string
 */
public String toString( ) {
		String str = String.format("%-8s\t","Name:")+fname+" "+lname;
		str += (!pronouns.isEmpty()) ? " ("+pronouns+")\n" : "\n";
		str = str +    String.format("%-8s\t", "SSN")+String.format("%-16s\t",SSN );
		str = str +    String.format("%-16s\t","Employee ID:")+empID+"\n";
		str = str +    String.format("%-8s\t","Age:")+String.format("%-16d\t\t", age)+String.format("%-20s\t","Years Exp:")+years+"\n";
		if(dept.equals("Finance")) {
			str = str +    String.format("%-8s\t","Dept:")+String.format("%-16s\t\t",dept);
		} else {
			str = str +    String.format("%-8s\t","Dept:")+String.format("%-16s\t",dept);		
		}
		str = str +    String.format("%-20s\t\t","Salary:")+ getFixedPointSalary();
		return(str);
}


}
