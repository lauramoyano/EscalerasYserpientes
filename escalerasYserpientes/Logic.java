package escalerasYserpientes;

import java.util.Scanner;

public class Logic {

	boolean human = false;
	boolean continueGame;
	private Player player1, player2, player3;
	private int turn;
	private Dice dice;
	private boolean pausado;
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
	
		public Logic() {
		pausado=true;
		continueGame = false;

		this.dice = new Dice();
		this.turn = 1;
		
		this.player1 = new Player(1, this.dice, false, this );
		player1.THREAD.start();
		this.player2 = new Player(2, this.dice, false, this );
		player2.THREAD.start();
		this.player3 = new Player(3, this.dice, true, this );
		player3.THREAD.start();

		
	}

	public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public Player getPlayer3() {
		return player3;
	}

	public void test(){
		for(int i=0; i<12; i++){
			movePlayer(player1);
			movePlayer(player2);
		} 
	}

	public void initHuman(){
		if(!human){
			player3.THREAD.start();
			human = true;
		}
		else{

		}
	}
	/*
	public synchronized void movePlayer(Player playerToMove) {

		try {
			while(playerToMove.getTurn() != turn){
				//Thread.currentThread().
				wait();
			}
			System.out.print("soy un print");

			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			notifyAll();
		}
	}*/
	

	public synchronized void movePlayer(Player playerToMove) {

		try {
			while(playerToMove.getTurn() != turn){
				//Thread.currentThread().
				System.out.print("soy un print");
				//turn++;
				wait();
			}
			
			
			
			int numberToMove = this.dice.getCardNumber(); 

			//despertarlo por aqui
			System.out.print(pausado);

			if(!pausado) {
				playerToMove.changePosition(numberToMove);
				pausado=false;


			}

			if(this.determinedGame(playerToMove) != -1) {
				wait();
			}

			playerToMove.changePosition(board[playerToMove.getPosition()]);
			this.turn++;


			if(this.turn > 3) {
				turn = 1 ;
			}
				
				
			}
		 catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {	
			notifyAll();			
		}

	} 
	
	public int getTurn() {
		return turn;
	}
	
	public boolean setPause(boolean value) {
		pausado=value;
		return value;
	}
	public void cosaQuehaceCosas() {
		int numberToMove = this.dice.getCardNumber();
		turn++;
		//playerToMove.changePosition(numberToMove);
	}

	public void continueGamePlayers(){
		continueGame = true;
	}      
		
	public void useDice(){
		System.out.println("Tirar el dado Y/N");
		//Scanner reading = new Scanner(System.in);
		//String answer = reading.next();
		//if(answer.equalsIgnoreCase("y")){}
			
 
		System.out.print("Pasé por el IF \n");
		int numberToMove = this.dice.getCardNumber();
		System.out.print(numberToMove + "\n");
		player3.changePosition(numberToMove);
		this.turn++; 
		
	}

	public int determinedGame(Player player) {
		if(player.getPosition() >= board.length-1 ) {
			player.setPosition(board.length-1);
			System.out.println("Ha ganado el jugador: " + player.getTurn());
			return player.getTurn();
		}
		return -1;
	}
			
}
