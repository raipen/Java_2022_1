/*
 * VarRange 변수의 사용범위 계산
 * 
 * @version 1.0
 * @author 박지원
 * @학번 2021114335
 * @date 2022-03-27
 * @copyright © KNU CSE student 박지원
 */
import java.util.Scanner;

public class LottoGeneration {
	/*Lotto 번호별 빈도수를 담을 변수*/
	public static int frequency[] = new int[46];
	
	/*로또 수행 회수를 1~5 사이로 입력받아 그 회수만큼 로또 번호를 생성하고 번호 빈도수를 출력 */
	public static void main(String[] args) {
		System.out.print("Lotto 수행 회수를 입력하세요(1~5):");
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		while(a<1||a>5) {
			System.out.println("1에서 5사이의 숫자를 다시 입력하세요.\n");
			System.out.print("Lotto 수행 회수를 입력하세요(1~5):");
			a = scan.nextInt();
		}
		for(int i=0;i<a;i++) {
			int[] lotto = createLotto();
			addFrequency(lotto);
			printLotto(i,lotto);
		}
		printFrequency();
		scan.close();
    }
	
	/* 로또 번호 배열을 인자로 받아 빈도수에 추가 */
	public static void addFrequency(int[] lotto) {
		for(int i: lotto)
			frequency[i]++;
	}
	
	/* 빈도수 출력 */
	public static void printFrequency() {
		System.out.println("Lotto 번호별 빈도수");
		for(int i=1;i<46;i++)
			if(frequency[i]!=0)
				System.out.printf("%2d: %s\n",i,"*".repeat(frequency[i]));
	}
	
	/* 로또 번호 생성 */
	public static int[] createLotto() {
		int[] lotto= new int[6];
		for(int i = 0;i<6;i++) {
			int r;
			do {
				r = (int) (Math.random() *45 +1);
			}while(isContain(lotto,r));
			lotto[i] = r;
		}
		return lotto;
	}
	
	/* 이미 배열에 존재하는 값인지 확인 */
	public static boolean isContain(int[] lotto,int n) {
		for(int i: lotto)
			if(i==n) 
				return true;
		return false;
	}
	
	/* 로또 배열 출력 */
	public static void printLotto(int n,int[] lotto) {
		System.out.print("Lotto ["+n+"]: ");
		for(int i: lotto)
			System.out.printf("%2d ",i);
		System.out.print("\n");
	}
}