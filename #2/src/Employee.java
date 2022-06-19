/**
 * @version 1.0
 * @author 박지원
 * @학번 2021114335
 * @date 2022-04-02
 * @copyright © KNU CSE student 박지원
 */
public class Employee {
   private int age;
   private String position;
   private String fullName;;
   private int salary;
   
   public void setAge(int age) {
      this.age = age;
   }
   
   public void setPosition(String position) {
      this.position = position;
   }
   
   public void setName(String firstname, String lastname) {
      this.fullName = firstname +" "+ lastname;
   }
   
   public void setSalary(int salary) {
      this.salary = salary;
   }
   
   public String getName() {
      return fullName;
   }
   
   public int getSalary() {
      return salary;
   }
   
   public String getPosition() {
      return position;
   }
   
   public int getAge() {
      return age;
   }
   
   public void printEmployeeInfo() {
      System.out.printf("%13s\t%-3d\t%24s\t%6d\n",getName(),getAge(),getPosition(),getSalary());
   }
}