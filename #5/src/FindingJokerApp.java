/**
 * @author 박지원
 * @학번 2021114335
 * @프로그램 Joker를 찾아라
 * FindingJokerApp.java
 * @date 2022-05-08
 * @copyright © KNU CSE student 박지원
 */
public class FindingJokerApp {
	public static void main(String[] args) {
		new GameDealer(new Player("Computer"),new Player("Human")).run();
	}
}
