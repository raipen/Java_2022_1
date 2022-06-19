/**
 * @version 1.0
 * @author 박지원
 * @학번 2021114335
 * @date 2022-04-05
 * @copyright © KNU CSE student 박지원
 */
public class Staff extends Employee{
	public int getAnnualSalary() {
		return getSalary()*12;
	}
	public void printEmployee() {
		System.out.printf("%15s%5d%17s%11d%17d\n",
				getName(),getAge(),getPosition(),getSalary(),getAnnualSalary());
	}
}
