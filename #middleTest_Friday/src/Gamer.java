public class Gamer implements RollingDiceInterface {
	private String name;
	private int[] dice = new int[2];
	public Gamer(String name) {
		this.name = name;
	}
	@Override
	public void roll() {
		dice[0] =(int) (Math.random() *14 +1);
		dice[1] =(int) (Math.random() *14 +1);
	}

	@Override
	public int[] getFaceNumbers() {
		return dice;
	}

	@Override
	public int getDiceSum() {
		return dice[0]+dice[1];
	}

	@Override
	public int compareTo(Object obj) {
		int player1 = this.getDiceSum();
		int player2 = ((Gamer) obj).getDiceSum();
		return player1>player2?1:(player1==player2?0:-1);
	}
	
	public String toString() {
		return name+"("+String.format("%2d", dice[0])+
				","+String.format("%2d", dice[1])+")= "+
				String.format("%2d", getDiceSum());
	}
}
