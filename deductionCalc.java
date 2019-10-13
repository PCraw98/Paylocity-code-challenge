import java.util.Scanner;
import java.text.DecimalFormat;

public class deductionCalc {
	final static double DEP_BASE = 500.0;
	final static double YEARLY_INCOME = (2000 * 26);
	final static double INCOME = 2000.0;
	static double empCost;
	static double depCost = 0;
	static DecimalFormat df = new DecimalFormat("####0.00");

	public static double employee(String empName) {
		empCost = 1000.0;
		if ((empName.charAt(0) == 'A') || (empName.charAt(0) == 'a')) {
			empCost = (empCost - (empCost * .1));
		}
		return empCost;
	}

	public static double dependents(String[] depsNames) {
		for (String name : depsNames) {
			if ((name.charAt(0) == 'A') || (name.charAt(0) == 'a')) {
				depCost += (DEP_BASE - (DEP_BASE * .1));
			} else {
				depCost += DEP_BASE;
			}
		}
		return depCost;
	}

    public static void main(String[] args) {
		double totalAnnualCost=0;
		Scanner sc = new Scanner(System.in);
        String nextName = "";
        System.out.println("Enter employee name,(only 1 name expected)");
        totalAnnualCost += employee(sc.nextLine());
		System.out.println("\nEnter dependents names (comma separated)");
		totalAnnualCost += dependents(sc.nextLine().split(","));
		double monthlyCost = totalAnnualCost/26;
		System.out.println("\nincome per month = $" + df.format(INCOME)  + "\nyearly deductions = $" + df.format(totalAnnualCost) + "\ndeductoin cost/month = $" + 
			df.format(monthlyCost) + "\nmonthly income after deductions = $" + df.format(INCOME - monthlyCost));
    }
}
