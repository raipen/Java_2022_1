public interface YutInterface {
	/**
	 * 1회 윷을 던져서 나온 값을 리턴  
	 * 	1111: 모 : 5
	 * 	0000: 윷 : 4
	 * 	1000: 걸 : 3
	 * 	1100: 개 : 2
	 * 	1110: 도 : 1
	 */
	public abstract int castYut();
	
	/**
	 * 현재까지 누적 점수를 리턴 
	 * @return
	 */
	public abstract int getTotalScore();
	
	/**
	 * 두 사람의 전체 누적 점수를 비교 
	 * @param obj (Upcasting, downcasting 사용) 
	 * @return
	 * 		. player1 > player2, return 1 
	 * 		. player1 == player2, return 0
	 * 		. player1 < player2,  return -1 
	 * 	
	 */
	public abstract int compareTo(Object obj);
	
	/**
	 * 윷을 던져서 나온 값들의 통계값을 화면에 출력 
	 * - 각 점수별 나온 비율(%)
	 */
	public abstract void displayResult();
}
