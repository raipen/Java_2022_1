public interface RollingDiceInterface {
	/**
	* 2개의 랜덤 숫자 생성 (1 ~ 주사위의 최대 숫자 14)
	*/
	public abstract void roll();
	/**
	* 2개 주사위의 값을 배열로 리턴
	* @return
	*/
	public abstract int[] getFaceNumbers();
	/**
	* 2개 주사위 값의 합을 리턴
	* @return
	* */
	public abstract int getDiceSum();
	/**
	* 자신의 2개 주사위의 합과 다른 선수의 주사위의 합을 비교
	* - Upcasting, downcasting 사용
	* @param Object
	* @return
	* . player1 > player2, return 1
	* . player1 == player2, return 0
	* . player1 < player2, return -1
	*/
	public abstract int compareTo(Object obj);
}