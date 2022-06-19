/**
 * @author 박지원
 * @학번 2021114335
 * @프로그램 ReservationInterface를 구현한 클래스
 * ReservationSystem.java
 * @date 2022-04-23
 * @copyright © KNU CSE student 박지원
 */

import java.util.Scanner;

public abstract class ReservationSystem implements ReservationInterface{
	private int seat[][];
	private char maxRow;
	private Scanner scan;
	protected int reserved;
	
	public ReservationSystem() {}
	public ReservationSystem(Scanner scan) {
		reserved = 0;
		this.scan = scan;
	}
	
	@Override
	public void makeSeats(int row, int col) {
		this.maxRow=(char)((int)'A'+row-1);
		this.seat =new int[row][col+1]; 
	}
	
	private int calRow(String seatName) {
		return maxRow - seatName.charAt(seatName.length()-1);
	}
	
	private int calcol(String seatName) {
		int sum = 0;
		for(int i=0;i<seatName.length()-1;i++) {
			if(seatName.charAt(i)<'0'||seatName.charAt(i)>'9')
				throw new ArithmeticException();
			sum = sum*10 + seatName.charAt(i)-'0';
			if(i>1)
				throw new RuntimeException();
		}
		if(sum==0)
			throw new ArrayIndexOutOfBoundsException();
		return sum;
	}	
	
	@Override
	public int reserveSeat(String seatName) {
		try {
			int row = calRow(seatName);
			int col = calcol(seatName);
			if(seat[row][col]==0) {
				seat[row][col]=1;
				reserved++;
				System.out.println("[예약 성공] "+seatName);
				return 0;
			}else {
				System.out.println("[예약 실패] "+seatName+": 이미 예약된 좌석입니다.");
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(seatName+": 좌석의 범위를 넘은 잘못된 좌석 이름입니다.");
			System.out.println("[예약 실패]: 잘못된 좌석 이름입니다");
			return -1;
		}catch(ArithmeticException e) {
			System.out.println(seatName+": 숫자가 아닌 잘못된 좌석 이름입니다.");
			System.out.println("[예약 실패]: 잘못된 좌석 이름입니다");
		}catch(RuntimeException e) {
			System.out.println("[예약 실패]: 잘못된 좌석 이름입니다");
		}
		return -1;
	}

	@Override
	public int cancelSeat(String seatName) {
		try {
			int row = calRow(seatName);
			int col = calcol(seatName);
			if(seat[row][col]==1) {
				seat[row][col]=0;
				reserved--;
				System.out.println("[예약 취소 성공] "+seatName);
				return 0;
			}else {
				System.out.println("[예약 취소 실패] "+seatName+": 예약되지 않은 좌석입니다.");
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(seatName+": 좌석의 범위를 넘은 잘못된 좌석 이름입니다.");
			System.out.println("[예약 취소 실패]: 잘못된 좌석 이름입니다");
			return -1;
		}catch(ArithmeticException e) {
			System.out.println(seatName+": 숫자가 아닌 잘못된 좌석 이름입니다.");
			System.out.println("[예약 취소 실패]: 잘못된 좌석 이름입니다");
		}catch(RuntimeException e) {
			System.out.println("[예약 취소 실패]: 잘못된 좌석 이름입니다");
		}
		return -1;
	}
	
	public String menu(String systemTitle) {
		System.out.print("-------------------------\r\n"
				+ " "+systemTitle+"\r\n"
				+ " 1. 좌석 예약\r\n"
				+ " 2. 예약 취소\r\n"
				+ " 3. 예약 현황 조회\r\n"
				+ " 4. 메인 메뉴로 돌아가기\r\n"
				+ "-------------------------\r\n"
				+ " 번호를 선택해주세요: ");
		return scan.next();
	}
	
	public void run(String systemTitle) {
		while(true) {
			String input = menu(systemTitle);
			int i=input.charAt(0)-'0';
			if(input.length()!=1||(i<0||i>9))
				i=-1;
			switch(i) {
			case 1:
				System.out.print("예약할 좌석 이름을 입력하세요: ");
				if(reserveSeat(scan.next())==0) 
					displaySeat(systemTitle);
				break;	
			case 2:
				System.out.print("취소할 좌석 이름을 입력하세요: ");
				if(cancelSeat(scan.next())==0) 
					displaySeat(systemTitle);
				break;
			case 3:
				displaySeat(systemTitle);
				break;
			case 4:
				System.out.println(systemTitle + "을 종료하고 메인 메뉴로 돌아갑니다.");
				return;
			default:
				System.out.println("잘못된 메뉴 선택입니다. 숫자를 다시 입력해주세요 (1~4)");
			}
		}
	}
	
	public void printLine(int j) {
		for(int i=1;i<11;i++) {
			System.out.printf("[%2d%c] ",i,maxRow -j);
		}
		System.out.print("\n");
		for(int i=1;i<11;i++) {
			System.out.printf("   %c  ",seat[j][i]==1?'x':'o');
		}
		System.out.print("\n");
	}
	
	public abstract void displaySeat(String systemTitle);
	
}
