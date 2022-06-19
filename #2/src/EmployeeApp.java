/**
 * @version 1.0
 * @author 박지원
 * @학번 2021114335
 * @date 2022-04-02
 * @copyright © KNU CSE student 박지원
 */
import java.util.Scanner;

public class EmployeeApp {
	public static Scanner scan = new Scanner(System.in);
	
	public static Employee[] initEmployee() {
		Employee employee[] = new Employee[5];
		for(int i=0;i<employee.length;i++) {
			employee[i] = new Employee();
		}
		employee[0].setAge(28);
		employee[0].setName("John", "Smith");
		employee[0].setPosition("Senior Software Engineer");
		employee[0].setSalary(300);
		employee[1].setName("Kim","Young");
		employee[1].setAge(24);
		employee[1].setPosition("Junior Software Engineer");
		employee[1].setSalary(250);
		employee[2].setName("Lisa", "Barnes");
		employee[2].setAge(37);
		employee[2].setPosition("Team Leader");
		employee[2].setSalary(580);
		employee[3].setName("Michael", "Kevin");
		employee[3].setAge(46);
		employee[3].setPosition("Project Manager");
		employee[3].setSalary(650);
		employee[4].setName("Mary", "Anne");
		employee[4].setAge(35);
		employee[4].setPosition("Senior Software Engineer");
		employee[4].setSalary(350);
		return employee;
	}
	
	public static int menu() {
		System.out.print("================================\r\n"
				+ "Employee Management System\r\n"
				+ "================================\r\n"
				+ "1. Display Employees' Information\r\n"
				+ "2. Chagne Employee's Position\r\n"
				+ "3. Change Employee's Salary\r\n"
				+ "0. Quit\r\n"
				+ "================================\r\n"
				+ "-> ");
		return scan.nextInt();
	}
	
	public static void main(String[] args) {
		Employee employee[] = initEmployee();
		while(true) {
			switch(menu()) {
			case 1:
				System.out.printf("    \t");
				System.out.printf("%13s\t%-3s\t%24s\t %6s\n","Name","Age","Position","Salary");
				System.out.println("-----------------------------------------------------------------------");
				for(int i=0;i<employee.length;i++) {
					System.out.printf("[%2d]\t",i+1);
					employee[i].printEmployeeInfo();
				}
				System.out.println("-----------------------------------------------------------------------");
				break;
			case 2:
				for(int i=0;i<employee.length;i++) {
					System.out.printf("[%2d]\t",i+1);
					System.out.printf("%13s\t%28s\n",employee[i].getName(),employee[i].getPosition());
				}
				System.out.print("Input index(1~5) and new position: ");
				int a = scan.nextInt();
				String b = scan.nextLine();
				while(a<1||a>5) {
					System.out.println("Wrong index. Type again.");
					System.out.print("Input index(1~5) and new position: ");
					a = scan.nextInt();
					b = scan.nextLine();
				}
				employee[a-1].setPosition(b);
				System.out.println("-----------------------------------------------------");
				System.out.printf("[%2d]\t",a);
				System.out.printf("%13s\t%28s\n",employee[a-1].getName(),employee[a-1].getPosition());
				System.out.println("-----------------------------------------------------");
				break;
			case 3:
				for(int i=0;i<employee.length;i++) {
					System.out.printf("[%2d]\t",i+1);
					System.out.printf("%13s\t%28d\n",employee[i].getName(),employee[i].getSalary());
				}
				System.out.print("Input index and new salary: ");
				int a1 = scan.nextInt();
				int b1 = scan.nextInt();
				while(a1<1||a1>5) {
					System.out.println("Wrong index. Type again.");
					System.out.print("Input index and new salary: ");
					a1 = scan.nextInt();
					b1 = scan.nextInt();
				}
				employee[a1-1].setSalary(b1);
				System.out.println("-----------------------------------------------------");
				System.out.printf("[%2d]\t",a1);
				System.out.printf("%13s\t%28s\n",employee[a1-1].getName(),employee[a1-1].getSalary());
				System.out.println("-----------------------------------------------------");
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

}
