/**
 * @author 박지원
 * @학번 2021114335
 * @프로그램 main() 함수가 있는 클래스
 * ReservationApp.java
 * @date 2022-04-23
 * @copyright © KNU CSE student 박지원
 */

import java.util.Scanner;

public class ReservationApp {
	private Scanner scan;
	private ReservationSystem reservation[];
	private String systemName[];
	
	public ReservationApp() {
		scan= new Scanner(System.in);
		reservation = new ReservationSystem[2];
		reservation[0]=new AirlineSystem(scan);
		reservation[1]=new BusSystem(scan);
		systemName = new String[2];
		systemName[0]="항공사 예약 시스템";
		systemName[1]="버스 예약 시스템";
	}
	
	public String menu() {
		System.out.print("----------------------------------------------\r\n"
				+ "  K-Startup의 통합 예약 시스템을 방문해 주셔서 감사합니다.\r\n"
				+ "      1. 항공사 예약 시스템\r\n"
				+ "      2. 버스 예약 시스템\r\n"
				+ "      0. 통합 예약 시스템 종료\r\n"
				+ "----------------------------------------------\r\n"
				+ " 메뉴를 선택해주세요: ");
		return scan.next();
	}
	
	public void run() {
		while(true) {
			String input = menu();
			int i=input.charAt(0)-'0';
			if(input.length()!=1||(i<0||i>9))
				i=-1;
			switch(i) {
			case 1: case 2:
				reservation[i-1].run(systemName[i-1]);
				break;
			case 0:
				System.out.println("K-Startup 통합 예약 시스템을 종료합니다.");
				return;
			default:
				System.out.println("잘못된 메뉴 선택입니다. 숫자를 다시 입력해주세요 (0~2)");
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReservationApp app = new ReservationApp();
		app.run();
	}

}
