/**
 * VarRange 변수의 사용범위 계산
 * 
 * @version 1.0
 * @author 박지원
 * @학번 2021114335
 * @date 2022-03-27
 * @copyright © KNU CSE student 박지원
 */
public class VarRange {
	/**
	 * main() 메소드
	 * totalCount를 short int long 타입으로 선언해서 최대로 표현할 수 있는 시간을 출력하는 함수를 호출
	 */
	public static void main(String[] args) {
		measureShort();
		measureInt();
		measureLong();
	}
	
	/**
	 * measureShort() 메소드
	 * totalCount를 short로 선언, short의 최대값으로 초기화
	 * 그 totalCount로 표현할 수 있는 최대 시간을 출력
	 */
	public static void measureShort() {
		short totalCount = Short.MAX_VALUE;
		print("short",totalCount);
	}
	
	/**
	 * measureInt() 메소드
	 * totalCount를 int로 선언, int의 최대값으로 초기화
	 * 그 totalCount로 표현할 수 있는 최대 시간을 출력
	 */
	public static void measureInt() {
		int totalCount = Integer.MAX_VALUE;
		print("int",totalCount);
	}
	
	/**
	 * measureLong() 메소드
	 * totalCount를 long으로 선언, long의 최대값으로 초기화
	 * 그 totalCount로 표현할 수 있는 최대 시간을 출력
	 */
	public static void measureLong() {
		long totalCount = Long.MAX_VALUE;
		print("long",totalCount);
	}
	
	/**
	 * print() 메소드
	 * 어떤 타입의 변수를 사용했고, 그 변수에 들어있는 값이 어떤 것인지 출력
	 * 그 변수로 표현가능한 년 일 시간 출력
	 */
	public static void print(String type,long a) {
		System.out.println(type+" max:"+a);
		System.out.println(type+" 변수 사용: "+getYear(a)+"년 "+getDay(a)+"일 "+getTime(a)+"시간\n");
	}
	
	/**
	 * getYear(),getDay(),getTime 메소드
	 * 인자로 받은 값이 나타내는 년,월,일을 리턴
	 */
	public static long getYear(long a) {
		return a/(60*60*24*365);
	}
	
	public static long getDay(long a) {
		return (a/(60*60*24))%365;
	}
	
	public static long getTime(long a) {
		return (a/(60*60))%24;
	}
}
