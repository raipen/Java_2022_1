/**
 * @author 박지원
 * @학번 2021114335
 * @프로그램 항공사 예약 시스템 구현 클래스
 * AirlineSystem.java
 * @date 2022-04-23
 * @copyright © KNU CSE student 박지원
 */

import java.util.Scanner;

public class AirlineSystem extends ReservationSystem{
	public AirlineSystem(Scanner scan) {
		super(scan);
		this.makeSeats(4, 10);
	}

	@Override
	public void displaySeat(String systemTitle) {
		System.out.println("["+systemTitle+" 예약 현황] 예약 좌석: " + reserved+"/ 총 좌석: 40\n");
		printLine(0);
		printLine(1);
		System.out.println("-----------------------------------------------------------\r\n"
				+ "  앞                       통로                       뒤\r\n"
				+ "-----------------------------------------------------------");
		printLine(2);
		printLine(3);
	}
}
