public class YutPlayer implements YutInterface{
	private String name;
	private int score;
	private int[] yut;
	private int yutSum;
	private static String[] yutName = {"도","개","걸","윳","모"};
	private int[] yutCount;
	private int castCount;
	
	public YutPlayer(String name) {
		this.score = 0;
		this.name = name;
		this.yut = new int[4];
		this.yutCount = new int[5];
		this.castCount = 0;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public int castYut() {
		yutSum = 0;
		for(int i=0;i<4;i++) {
			yut[i] = (int) (Math.random() *2);
			yutSum += yut[i]==0?1:0;
		}
		if(yutSum==0) yutSum = 5;
		score+= yutSum;
		yutCount[yutSum-1]++;
		castCount++;
		return yutSum;
	}

	@Override
	public int getTotalScore() {
		return this.score;
	}

	@Override
	public int compareTo(Object obj) {
		int player1 = this.getTotalScore();
		int player2 = ((YutPlayer) obj).getTotalScore();
		return player1>player2?1:(player1==player2?0:-1);
	}

	@Override
	public void displayResult() {
		System.out.print("-------------------------------------------------\n"
				+ "     도      개      걸      윷      모      단위(%)\n"
				+ "-------------------------------------------------\n"
				+ getName()+"  ");
		for(int i=0;i<5;i++) {
			System.out.printf("%2.1f   ",(double)yutCount[i]/(double)castCount*100);
		}
		System.out.print("\n");
	}
	
	public String toString() {
		String result = this.name+" [";
		int cur = yutSum;
		for(int i=0;i<3;i++)
			result += yut[i]+" ";
		result +=yut[3]+"] "+yutName[cur-1]+" ("+cur+"점/총 "+String.format("%2d",this.score)+"점)";
		return result;
	}

}
