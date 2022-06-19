/**
 * @version 1.0
 * @author 박지원
 * @학번 2021114335
 * @date 2022-04-05
 * @copyright © KNU CSE student 박지원
 */
import java.util.Scanner;

public class EmployeeEx {
	private Scanner scan;
	private Staff[] staff;
	private Engineer[] engineer;
	
	public EmployeeEx() {
		initStaff();
		initEngineer();
		scan= new Scanner(System.in);
	}
	
	public void initStaff() {
		staff = new Staff[3];
		for(int i=0;i<staff.length;i++) {
			staff[i] = new Staff();
		}
		staff[0].setName("John","Smith");
		staff[0].setAge(25);
		staff[0].setPosition("Newcomer");
		staff[0].setSalary(300);
		staff[1].setName("Marry","Anne");
		staff[1].setAge(45);
		staff[1].setPosition("Executive");
		staff[1].setSalary(600);
		staff[2].setName("Sue","Jones");
		staff[2].setAge(38);
		staff[2].setPosition("Office manager");
		staff[2].setSalary(450);
	}
	
	public Engineer[] initEngineer() {
		engineer = new Engineer[3];
		for(int i=0;i<engineer.length;i++) {
			engineer[i] = new Engineer();
		}
		engineer[0].setName("Bob","Lewis");
		engineer[0].setAge(28);
		engineer[0].setPosition("Junior Engineer");
		engineer[0].setSalary(350);
		engineer[0].setOverworkingDay(17);
		engineer[1].setName("Lisa","Barnes");
		engineer[1].setAge(37);
		engineer[1].setPosition("Senior Engineer");
		engineer[1].setSalary(580);
		engineer[1].setOverworkingDay(20);
		engineer[2].setName("Michael","Kevin");
		engineer[2].setAge(46);
		engineer[2].setPosition("SW manager");
		engineer[2].setSalary(650);
		engineer[2].setOverworkingDay(20);
		return engineer;
	}
	
	public int menu() {
		System.out.print("========================================================\r\n"
				+ "1. Display all employees' information (Staff, Engineer)\r\n"
				+ "2. Display all staffs' information\r\n"
				+ "3. Display all engineers' information\r\n"
				+ "4. Display all employees' name, salary, annual salary\r\n"
				+ "5. Display all employees' name, position\r\n"
				+ "6. Display statistics of annual salary\r\n"
				+ "0. Quit\r\n"
				+ "========================================================\r\n"
				+ "-> ");
		return scan.nextInt();
	}
	
	public void printStaff() {
		System.out.println("[Staff]");
		System.out.printf("%15s%5s%17s%11s%17s\n","Name","Age","Position","Salary","Annual Salary");
		System.out.println("--------------------------------------------------------------------");
		for(int i=0;i<staff.length;i++) {
			staff[i].printEmployee();
		}
	}
	
	public void printEngineer() {
		System.out.println("[Engineer]");
		System.out.printf("%15s%5s%17s%17s%11s%17s\n","Name","Age","Position","Overworking Pay","Salary","Annual Salary");
		System.out.println("-----------------------------------------------------------------------------------");
		for(int i=0;i<engineer.length;i++) {
			engineer[i].printEmployee();
		}
	}
	
	public void printSalary() {
		System.out.println("[Staff]");
		System.out.printf("%15s%11s%17s\n","Name","Salary","Yearly Salary");
		System.out.println("----------------------------------------------------");
		for(int i=0;i<staff.length;i++) {
			System.out.printf("%15s%9d%15d\n",staff[i].getName(),staff[i].getSalary(),staff[i].getAnnualSalary());
		}
		System.out.println();
		System.out.println("[Engineer]");
		System.out.printf("%15s%11s%17s\n","Name","Salary","Yearly Salary");
		System.out.println("----------------------------------------------------");
		for(int i=0;i<engineer.length;i++) {
			System.out.printf("%15s%9d%15d\n",engineer[i].getName(),engineer[i].getSalary(),engineer[i].getAnnualSalary());
		}
	}
	
	public void printPosition() {
		System.out.println("[Staff]");
		System.out.printf("%15s%21s\n","Name","Position");
		System.out.println("----------------------------------------------------");
		for(int i=0;i<staff.length;i++) {
			System.out.printf("%15s%21s\n",staff[i].getName(),staff[i].getPosition());
		}
		System.out.println();
		System.out.println("[Engineer]");
		System.out.printf("%15s%21s\n","Name","Position");
		System.out.println("----------------------------------------------------");
		for(int i=0;i<engineer.length;i++) {
			System.out.printf("%15s%21s\n",engineer[i].getName(),engineer[i].getPosition());
		}
	}
	
	public void printStatistics() {
		int arr[] = new int[10];
		for(int i=0;i<staff.length;i++) {
			arr[staff[i].getAnnualSalary()/1000]++;
		}
		for(int i=0;i<engineer.length;i++) {
			arr[engineer[i].getAnnualSalary()/1000]++;
		}
		for(int i=0;i<10;i++) {
			System.out.printf("[%04d]: ",i*1000);
			for(int j=0;j<arr[i];j++) {
				System.out.print("#");
			}
			System.out.println();
		}
	}
	
	public void run() {
		while(true) {
			switch(menu()) {
			case 1:
				printStaff();
				printEngineer();
				break;
			case 2:
				printStaff();
				break;
			case 3:
				printEngineer();
				break;
			case 4:
				printSalary();
				break;
			case 5:
				printPosition();
				break;
			case 6:
				printStatistics();
				break;
			case 0:
				System.out.println("Bye!");
				System.exit(0);
				break;
			default:
				System.out.println("Wrong input. Try again");
			}
		}
	}
	
	public static void main(String[] args) {
		EmployeeEx app = new EmployeeEx();
		app.run();
	}
}
