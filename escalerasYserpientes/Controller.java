package escalerasYserpientes;

import java.util.Random;



public class Controller {

	private int faceDice;
	private boolean playerInit = false;
	private int humanPosition;
	private int turn;
	private int diceNumber;
	private GUI viewGame;
	private Player player3;
	private Player player2;
	static int[]  board={0,0,0,0,53,0,0,0,0,0									

						,0,0,0,35,0,0,0,0,0,0									
				
						,0,0,0,0,0,0,0,0,0,0									
				
						,0,0,0,0,0,0,0,-18,0,0									
				
						,0,0,0,0,0,0,0,0,0,0									
				
						,-41,0,19,0,0,0,0,0,0,0									
				
						,0,0,0,19,0,0,0,0,0,0									
				
						,0,0,0,0,0,-22,0,0,0,0									
				
						,0,0,0,0,0,0,0,0,0,0									
				
						,-18,0,0,0,0,0,-36,0,0,0};
	
	public Controller() {
		this.diceNumber = 0;
		this.turn = 1;
		this.humanPosition = 0;
		
		this.player2 = new Player(2, this); 
		this.player3 = new Player(3, this);

	}
	
	
	public int getNumberDice() {
		Random aleatorio = new Random();
		diceNumber = aleatorio.nextInt(6) + 1;
		return diceNumber;
	}
	
	public boolean getPlayerInit(){
		return playerInit;
	}

	private void initPlayers() {
		// TODO Auto-generated method stub
		if(!playerInit){
		  player3.THREAD.start();
		  player2.THREAD.start();
		  playerInit = true;
		}else{

		}
	}

	

	public Player getPlayer3() {
		return player3;
	}
	public Player getPlayer2() {
		return player2;
	}
	public synchronized int turns(int jugador) {

		try {
			while(jugador != turn){
				wait();
			}
			int numberToMove = this.getNumberDice();
			this.turn++;
			if(this.turn > 3) {
				turn = 1 ;
			}
			return numberToMove;
			
			}
		 catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {	
//			try {
//				Thread.currentThread().sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			notifyAll();			
		}
		return 0;
	} 
	   

	public int getFaceDice(){
		return faceDice;
	}
		

	public int determinedGame(Player player) {
		if(player.getPosition() >= board.length-1 ) {
			player.setPosition(board.length-1);
			System.out.println("Ha ganado el jugador: " + player.getTurn());
			return player.getTurn();
		}
		return -1;
	}

	
	
	public int moveHumanPlayer() {
		faceDice = this.turns(1);
		this.humanPosition =  humanPosition + faceDice + board[humanPosition];
		this.initPlayers();
		
		return humanPosition;
	}
	
	public int getHumanPosition() {
	
		return humanPosition;
	}
	
			
}
