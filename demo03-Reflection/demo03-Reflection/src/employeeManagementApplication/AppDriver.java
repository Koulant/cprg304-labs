/**
 * Created on Jan 22, 2008
 *
 * Project: demo5-EmployeeInheritanceExerciseComplete
 */
package employeeManagementApplication;

import employeeDomain.Wage;

/**
 *	AppDriver.java
 *
 * @author dwatson
 * @version 1.0
 *
 * Class Description:  This class launches the application.
 */
public class AppDriver
{

	/**
	 * Method to launch application.
	 * @param args
	 */
	public static void main(String[] args)
	{
		OfficeManager om = new OfficeManager();
//		om.printEmployeeList();
		System.out.println("Average Salary = "+om.calculateAverageEmployeeSalary());
		
		System.out.println("\nWages Employee with the highest salary");
		System.out.println(om.highestSalaryOfWagesEmployees());
		//example of casting to the last object in the inheritance chain
		Wage we = (Wage)om.highestSalaryOfWagesEmployees();
		System.out.println("The wage employee "+we.getName()+" worked "+we.getHours()+" hours.");
		
		System.out.println("\nSalaried Employee with the lowest salary");
		System.out.println(om.lowestSalaryOfSalariedEmployees());
		
		om.percentageOfEachTypeOfEmployee();
	}

}
