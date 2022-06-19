/**
 * @author 박지원
 * @학번 2021114335
 * @프로그램 Joker를 찾아라
 * GameDealer.java
 * @date 2022-05-08
 * @copyright © KNU CSE student 박지원
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GameDealer {
	ArrayList<Card> cards;
	Player[] player;
	Scanner scan;
	
	public GameDealer(Player player, Player player2) {
		scan = new Scanner(System.in);
		cards = new ArrayList<>();
		this.player = new Player[2];
		this.player[0] = player;
		this.player[1] = player2;
		String[] suit = {"♣", "♠", "◆", "♥"};
		String[] number = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
		
		System.out.println("<< 카드 생성 >>");
		for(String s:suit) {
			for(String n:number)
				cards.add(new Card(s,n));
			System.out.println();
		}
		cards.add(new Card("🃟","Joker"));
		System.out.println();
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}

	public void deal() {
		for(int i=0;i<27;i++)
			player[0].addCard(cards.remove(0));
		for(int i=0;i<26;i++)
			player[1].addCard(cards.remove(0));
	}
	
	public void run() {
		shuffle();
		System.out.println("\n<< 처음 딜러가 나누어 준 카드 >>");
		deal();
		player[0].printCards();
		player[1].printCards();
		player[0].openCard();
		player[1].openCard();
		System.out.printf("\n<< 1 단계 >>\n\n일치하는 숫자를 가진 카드 공개(2 장씩 허용)\n");
		player[0].printCards();
		player[1].printCards();
		
		for(int i=2;;i++) {
			System.out.println("다음 단계 게임 진행을 위해 Enter키를 누르세요!");
			scan.nextLine();
			System.out.printf("\n<< %d 단계 >>\n\n",i);
			System.out.println("상대방의 카드를 선택하세요 (Random)");
			System.out.println("============================");
			Card pick0 = player[0].pickCard(player[1]);
			Card pick1 =player[1].pickCard(player[0]);
			System.out.println("============================");
			player[0].addCard(pick0);
			player[1].addCard(pick1);
			player[0].printCards();
			player[1].printCards();
			System.out.printf("일치하는 숫자를 가진 카드 공개(2 장씩 허용)\n");
			for(Player p:player)
				p.openCard();
			player[0].printCards();
			player[1].printCards();
			if(player[0].getCardCount()==0||player[1].getCardCount()==0)
				break;			
		}
		System.out.printf("경기 종료: %s가 Joker를 가지고 있음",player[0].getCardCount()==0?player[1].getName():player[0].getName());
	}
}
