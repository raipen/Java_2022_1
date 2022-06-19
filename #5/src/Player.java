/**
 * @author 박지원
 * @학번 2021114335
 * @프로그램 Joker를 찾아라
 * Player.java
 * @date 2022-05-08
 * @copyright © KNU CSE student 박지원
 */
import java.util.ArrayList;

public class Player {
	private ArrayList<Card> privateCards;
	private ArrayList<Card> publicCards;
	private String name;
	
	public Player(String string) {
		name = string;
		privateCards = new ArrayList<>();
		publicCards = new ArrayList<>();
	}
	
	public String getName() {
		return name;
	}
	
	public int getCardCount() {
		return privateCards.size();
	}
	
	public void addCard(Card c) {
		privateCards.add(c);
	}
	
	public Card removeCard(int a) {
		return privateCards.remove(a);
	}
	
	public Card pickCard(Player p) {
		int rand = (int) (Math.random() * p.getCardCount());
		Card c =p.removeCard(rand);
		System.out.printf("%8s 선택:[%2d]%s\n",name,rand,c);
		return c;
	}
	
	public void openCard() {
		for(int i=0;i<privateCards.size();i++) {
			for(int j=i+1;j<privateCards.size();j++) {
				if(privateCards.get(i).getNum().equals(privateCards.get(j).getNum())) {
					publicCards.add(privateCards.remove(i));
					publicCards.add(privateCards.remove(j-1));
					i--;
					break;
				}
			}		
		}
	}
	public void printPublicCards() {
		System.out.printf("공개한 카드: %d 장\n",publicCards.size());
		for(int i=0;i<publicCards.size();i++) {
			System.out.printf("%s", publicCards.get(i)+(i%10==9?"\n":""));
		}
	}
	public void printPrivateCards() {
		System.out.printf("\n\n가지고 있는 카드: %d 장\n",privateCards.size());
		for(int i=0;i<privateCards.size();i++) {
			System.out.printf("[%2d]%s", i,privateCards.get(i)+(i%10==9?"\n":""));
		}
	}
	
	public void printCards() {
		System.out.printf("[%s]\n", name);
		printPublicCards();
		printPrivateCards();
		System.out.println("\n--------------------------------------------------------------------------------");
	}
}
