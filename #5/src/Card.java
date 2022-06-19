/**
 * @author 박지원
 * @학번 2021114335
 * @프로그램 Joker를 찾아라
 * Card.java
 * @date 2022-05-08
 * @copyright © KNU CSE student 박지원
 */
public class Card {
	private String suit;
	private String numString;
	public Card(String suit,String numString){
		this.suit = suit;
		this.numString = numString;
		System.out.print(this);
	}
	
	public String getNum() {
		return numString;
	}
	
	@Override
	public String toString() {
		return String.format("(%s%5s)",this.suit,this.numString);
	}
}
