import java.util.Scanner;

public class RollingDiceApp {
	private Scanner scan;
	private Gamer alice;
	private Gamer bob;
	private int[] sumFrequency=new int[29];
	private int[][] numberFrequency=new int[15][15];
	
	public void printSumFrequency() {
		System.out.println("\n[두 주사위 합의 빈도수]\n--------------------------------------------------------------------------------");
		for(int i=2;i<29;i++)
			System.out.printf("%2d ", i);
		System.out.println("\n--------------------------------------------------------------------------------");
		for(int i=2;i<29;i++)
			System.out.printf("%2d ", sumFrequency[i]);
		System.out.println("\n--------------------------------------------------------------------------------");
	}
	
	public void printNumberFrequency() {
		System.out.print("[두 주사위 합의 빈도수]\n   ");
		for(int j=1;j<15;j++)
			System.out.printf("%2d ", j);
		for(int i=1;i<15;i++) {
			System.out.printf("\n%2d ", i);
			for(int j=1;j<15;j++)
				System.out.printf("%2d ", numberFrequency[i][j]);
		}
		System.out.println("\n--------------------------------------------");
	}
	
	public RollingDiceApp(){
		scan = new Scanner(System.in);
		alice = new Gamer("Alice");
		bob = new Gamer("Bob");
	}
	
	public void doRoll(Gamer gamer) {
		gamer.roll();
		sumFrequency[gamer.getDiceSum()]++;
		numberFrequency[gamer.getFaceNumbers()[0]][gamer.getFaceNumbers()[1]]++;
	}
	
	public void run() {
		System.out.print("주사위를 던질 회수를 입력하세요: ");
		int cnt = scan.nextInt();
		System.out.println("---------------------------------");
		while(cnt--!=0) {
			doRoll(alice);
			doRoll(bob);
			switch(alice.compareTo(bob)) {
			case 1:
				System.out.println(alice.toString() + "  >\t" + bob.toString()+" : Alice Win");
				break;
			case 0:
				System.out.println(alice.toString() + "  =\t" + bob.toString()+" : Even game");
				break;
			case -1:
				System.out.println(alice.toString() + "  <\t" + bob.toString()+" : Bob Win");
				break;
			}
		}
		printSumFrequency();
		printNumberFrequency();
	}
	
	public static void main(String[] args) {
		RollingDiceApp app = new RollingDiceApp();
		app.run();
	}
}
