package escalerasYserpientes;

public class Player implements Runnable{

	private int position ;
	private int turn;
	private Dice dice;
	private Logic logic;
	private boolean isHuman;
	public final Thread THREAD =new Thread(this);
	
	public Player(int turn, Dice dice, Boolean isHuman, Logic logic) {
		this.isHuman = isHuman;
		this.position = 0;
		this.turn =  turn;
		this.dice = dice;
		this.logic = logic;
	}
	
	public boolean isHuman() {
		return isHuman;
	}

	public void run() {
		
		logic.movePlayer(this);
		
	}
	
	public int getTurn() {
		return turn;
	}

	public void changePosition(int newPosition) {
		newPosition = this.getPosition()+newPosition;
		this.setPosition(newPosition);
	}


	public int getPosition() {
		return position;
	}


	public void setPosition(int position) {
		this.position = position;
	}


	
}
