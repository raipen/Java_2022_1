public class YutPlayerApp {
	private YutPlayer player1;
	private YutPlayer player2;
	
	public YutPlayerApp() {
		player1 = new YutPlayer("흥부");
		player2 = new YutPlayer("놀부");
	}
	
	public void run() {
		for(int i=0,cur=0;player1.getTotalScore()<20&&player2.getTotalScore()<20;) {
			switch(i%2) {
			case 0:
				cur = player1.castYut();
				System.out.println(player1.toString()+"--->");
				break;
			case 1:
				cur = player2.castYut();
				System.out.println("                                <---"+player2.toString());
				break;
			}
			if(cur<4) i++;
		}
		System.out.printf("\n%s: %2d, %s: %2d ==> %s 승리\n",
				player1.getName(),player1.getTotalScore(),
				player2.getName(),player2.getTotalScore(),
				player1.compareTo(player2)==1?player1.getName():player2.getName());
		player1.displayResult();
		player2.displayResult();
		System.out.println("-------------------------------------------------");
	}

	public static void main(String[] args) {
		YutPlayerApp app = new YutPlayerApp();
		app.run();
	}

}
