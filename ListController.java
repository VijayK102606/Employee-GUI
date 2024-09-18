import java.io.BufferedReader;


import java.io.BufferedWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import myfileio.MyFileIO;

// TODO: Auto-generated Javadoc
/**
 * The Class ListController.
 */
public class ListController {
	
	/** The employees. */
	private ArrayList<Employee> employees;

	/** The Constant DEBUG. */
	private static final boolean DEBUG = true;
	
	/** The emp ID. */
	private static int empID; 		

	public final static int x1 = 0;
	public final static int x2 = 3;
	public final static int x3 = 4;
	public final static int x4 = 6;
	public final static int x5 = 7;
	public final static int x6 = 11;
	public final static int ssnLength = 11;
	public final static int minAge = 16;
	public final static int maxAge = 70;
	public final static int minSalary = 31200;
	public final static int maxSalary = 1000000000;
			
	/**
	 * Instantiates a new list controller.
	 */
	public ListController () {
		empID = 0;
		employees = new ArrayList<Employee>();
		initEmployees();
	}

	
	/**
	 * Adds the employee.
	 * 
	 * takes in paramaters from text field and checks for errors showed in slides. addes the employee
	 * if there are no errors.
	 * 
	 *
	 * @param fname the fname
	 * @param lname the lname
	 * @param SSN the ssn
	 * @param age the age
	 * @param pronouns the pronouns
	 * @param salary the salary
	 * @param years the years
	 * @param dept the dept
	 * @return the string
	 */
	String addEmployee(String fname, String lname, String SSN, String age, String pronouns, String salary, String years, String dept) {	
		if(lname.equals("") || fname.equals("") || SSN.equals("") || salary.equals("") || years.equals("") || age.equals("")) {
    		return "Make sure that all fields are populated";
    	} else if(ssnAlert(SSN) == false) {
    		return "Incorrect SSN Format";
    	} else if(dupSSNAlert(SSN) == false) {
    		return "Duplicate SSN";
    	} else if(ageAlert(age, years) == false) {
    		return "Invalid age";
    	} else if(salaryAlert(salary) == false) {
    		return "Invalid Salary";
    	} 
		try {
			int year = Integer.parseInt(years);
			double sal = Double.parseDouble(salary);
			int empAge = Integer.parseInt(age);
		} catch(Exception e) {
			System.out.println("error");
			return "invalid";
		}
		
		int year = Integer.parseInt(years);
		double sal = Double.parseDouble(salary);
		int empAge = Integer.parseInt(age);

		empID++;
		employees.add(new Employee(fname, lname, SSN, empAge, pronouns, sal, year, dept, empID));
		
		return "";
	}


		/**
    	 * Ssn alert.
    	 * 
    	 * checks for alerts with ssn if there are any returns false which goes to generate message.
    	 *
    	 * @param ssn the ssn
    	 * @return true, if successful
    	 */
    	public boolean ssnAlert(String ssn) {  	
    		try {
	    		int conv = Integer.parseInt(ssn.substring(x1,x2));
	    		int conv2 = Integer.parseInt(ssn.substring(x3,x4));
	    		int conv3 = Integer.parseInt(ssn.substring(x5,x6));
	    	} catch(Exception e) {
	    		return false;
	    	}  		

    		if(ssn.length() != ssnLength || ssn.charAt(x2) != '-' || ssn.charAt(x4) != '-') {
    			System.out.println(ssn);
	    		return false;
	    	}
	  
	    	return true;
	    }
    	
    	/**
	     * Dup SSN alert.
	     *
	     * checks if the SSN is a duplicate and returns false if it is or true
	     * if it is not.
	     * 
	     * @param ssn the ssn
	     * @return true, if successful
	     */
	    private boolean dupSSNAlert(String ssn) {
    		for(int i = 0; i < employees.size(); i++) {
	    		if(ssn.equals(employees.get(i).getSSN())) {
	    			System.out.println(employees.get(i).getSSN());
	    			return false;
	    		}
	    	}
    		return true;
    	}
	    
	    /**
    	 * Age alert.
    	 * 
    	 * checks for alerts with age if there are any returns false which goes to generate message.
    	 *
    	 * @param age the age
    	 * @return true, if successful
    	 */
    	public boolean ageAlert(String age, String years) {
	    		try {
	    			int empAge = Integer.parseInt(age);
	    		} catch(Exception e) {
	    			return false;
	    		}
	    		if(Integer.parseInt(age) < minAge) {
	    			return false;
	    		} else if(Integer.parseInt(age) - Integer.parseInt(years) < minAge) {
	    			System.out.println("Employees age and years of experience are not compatible");
	    		} else if(Integer.parseInt(age) > maxAge) {
	    			System.out.println("employee is too old, may not be meeting the age requirement");
	    		}
	    	return true;
	    }
	    
	    /**
    	 * Salary alert.
    	 * 
    	 * checks for alerts with salary if there are any returns false which goes to generate message.
    	 *
    	 * @param salary the salary
    	 * @return true, if successful
    	 */
    	public boolean salaryAlert(String salary) {
	    	try {
	    		Double sal = Double.parseDouble(salary);
	    	} catch(Exception e) {
	    		return false;
	    	}

	    	if(Double.parseDouble(salary) < minSalary || Double.parseDouble(salary) > maxSalary) {
	    		System.out.println("invalid salary");
	    		return false;
	    	}
	    return true;
	    }
	
	/**
	 * Gets the employee ID.
	 *
	 * @return the employee ID
	 */
	
	/**
	 * Reset static ID.
	 */
	protected static void resetStaticID() {
		empID = 0;
	}
	
	/**
	 * Sort by ID.
	 */
	public void sortByID() {
		Collections.sort(employees, new ByID());
	}
	
	/**
	 * The Class ByID.
	 * 
	 * uses compare employee to change order based on value of id
	 */
	private class ByID implements Comparator<Employee> {
		
		/**
		 * Compare.
		 *
		 * @param o1 the o 1
		 * @param o2 the o 2
		 * @return the int
		 */
		public int compare(Employee o1, Employee o2) {
			return Integer.compare(o1.getEmpID(), o2.getEmpID() );
		}
	}
	
	/**
	 * Sort by name.
	 */
	public void sortByName() {
		Collections.sort(employees, new ByName());
	}
	
	/**
	 * The Class ByName.
	 * 
	 * uses compare method to sort employee  based on first name and last name
	 */
	private class ByName implements Comparator<Employee> {
		
		/**
		 * Compare.
		 *
		 * @param o1 the o 1
		 * @param o2 the o 2
		 * @return the int
		 */
		@Override
		public int compare(Employee o1, Employee o2) {
			if(o1.getLname().equals(o2.getLname())) {
				return o1.getFname().compareTo(o2.getFname());
			} else {
				return o1.getLname().compareTo(o2.getLname());
			}
		}
	}

	/**
	 * Sort by salary.
	 */
	public void sortBySalary() {
		Collections.sort(employees, new BySalary());
	}
	
	/**
	 * The Class BySalary.
	 * 
	 * uses compare method to sort employees based on salary.
	 */
	private class BySalary implements Comparator<Employee> {
		
		/**
		 * Compare.
		 *
		 * @param o1 the o 1
		 * @param o2 the o 2
		 * @return the int
		 */
		public int compare(Employee o1, Employee o2) {
			return Double.compare(o1.getSalary(), o2.getSalary() );
		}
	}
	
	/**
	 * Gets the num employees.
	 *
	 * @return the num employees
	 */
	public int getNumEmployees() {
		return employees.size();
	}

	/**
	 * Gets the employee data str.
	 *
	 * @return the employee data str
	 */
	public String[] getEmployeeDataStr() {
		String[] employeeList = new String[employees.size()];
		
		if(employees.size() <= 0) {
			return null;
		}
		
		for(int i = 0; i < employees.size(); i++) {
				employeeList[i] = employees.get(i).toString();
		}
		
		return(employeeList);
		
	}
	
	/**
	 * Save employee DB.
	 * 
	 * saves the employee to database using certain format. writes that too the view.
	 */
	void saveEmployeeDB() {
		MyFileIO obj = new MyFileIO();
		File s = obj.getFileHandle("empDB.dat");
		BufferedWriter br = obj.openBufferedWriter(s);
		
		Collections.sort(employees, new ByID());

		try {
			for(int i = 0; i< employees.size(); i++) {
				String copy = employees.get(i).getFname() + "|,|" + employees.get(i).getLname() + "|,|"+ employees.get(i).getSSN() + 
								"|,|" + employees.get(i).getAge() + "|,|" + employees.get(i).getPronouns() + "|,|" + employees.get(i).getFixedPointSalary() + "|,|" 
								+ employees.get(i).getYears() + "|,|" + employees.get(i).getDept() + "|,|" + employees.get(i).getEmpID();
				br.write(copy);
				br.newLine();
			}
			obj.closeFile(br);
		} catch(Exception e) {
			System.out.println("error");
		}
	}
	
	/**
	 * Inits the employees.
	 * 
	 * initialized the employee array using split method to seperate based on format in save method.
	 */
	public void initEmployees() {
		MyFileIO obj = new MyFileIO();
		File s = obj.getFileHandle("empDB.dat");
		BufferedReader br = obj.openBufferedReader(s);
		
		if(obj.checkFileStatus(s, true) != 0) {
			return;
		}
		
		String line;
		try {
			while((line = br.readLine()) != null) {
				String [] tokens = line.split("\\|,\\|");
				addEmployee(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], tokens[5], tokens[6], tokens[7]);
			}
			obj.closeFile(br);
		} catch(Exception e) {
			System.out.println("error");
		}
	}	
}
 
