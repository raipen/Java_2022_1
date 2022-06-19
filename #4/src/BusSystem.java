/**
 * @author 박지원
 * @학번 2021114335
 * @프로그램 버스 예약 시스템 구현 클래스
 * BusSystem.java
 * @date 2022-04-23
 * @copyright © KNU CSE student 박지원
 */

import java.util.Scanner;

public class BusSystem extends ReservationSystem{
	public BusSystem(Scanner scan) {
		super(scan);
		this.makeSeats(3, 10);
	}

	@Override
	public void displaySeat(String systemTitle) {
		System.out.println("["+systemTitle+" 예약 현황] 예약 좌석: " + reserved+"/ 총 좌석: 30\n");
		printLine(0);
		System.out.println("-----------------------------------------------------------\r\n"
				+ "  앞                       통로                       뒤\r\n"
				+ "-----------------------------------------------------------");
		printLine(1);
		printLine(2);	
	}
}
