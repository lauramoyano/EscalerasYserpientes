package escalerasYserpientes;

public class Player implements Runnable{

	private int position ;
	private int turn;
	private Controller logic;
	public final Thread THREAD =new Thread(this);
	
	public Player(int turn, Controller logic) {
	
		this.position = 0;
		this.turn =  turn;
		this.logic = logic;
	}
	

	public void run() {

		while(logic.turns(this.getTurn()) != 0) {
			int numToMove = logic.turns(this.getTurn());
			this.changePosition(numToMove); 
			
			this.changePosition(Controller.board[this.getPosition()]);

			try {
				this.THREAD.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if(this.getPosition() == 99) {
				return;
			}
		}

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
