package escalerasYserpientes;


import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI extends JFrame {
	
		private Board board;
		private JButton rollDice, exit, reStart;
		private JLabel dice;
		private Listener listener;

		public GUI(){ 
			initGUI();

			this.setUndecorated(true);
			this.setTitle("Escaleras & Serpientes");
			this.setSize(new Dimension (600, 600));
			this.setResizable(false);
			this.setLocationRelativeTo(null);
			this.setVisible(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

		private void initGUI() {
			// TODO Auto-generated method stub
			this.getContentPane().setLayout(new GridBagLayout());
			GridBagConstraints constraints = new GridBagConstraints();
			listener = new Listener();
		
			reStart = new JButton("Reiniciar");
			reStart.addActionListener(listener);
			constraints.gridx = 0;
			constraints.gridy = 3;
			constraints.gridwidth = 1;
			constraints.gridheight = 1;
			constraints.fill = GridBagConstraints.HORIZONTAL;
			this.add(reStart, constraints);
			
			rollDice = new JButton("Tirar");
			rollDice.addActionListener(listener);
			constraints.gridx = 3;
			constraints.gridy = 2;
			constraints.gridwidth = 1;
			constraints.gridheight = 1;
			constraints.fill = GridBagConstraints.HORIZONTAL;
			this.add(rollDice, constraints);
			
			exit = new JButton("Salir");
			exit.addActionListener(listener);
			constraints.gridx = 1;
			constraints.gridy = 3;
			constraints.gridwidth = 1;
			constraints.gridheight = 1;
			constraints.fill = GridBagConstraints.HORIZONTAL;
			this.add(exit, constraints);
			
			
			this.board = new Board();
			board.updatePlayers();
			System.out.println("player 1:"+board.getLogic().getPlayer1().getPosition()+ "\n");
			System.out.println("player 2:"+board.getLogic().getPlayer2().getPosition()+ "\n");
			System.out.println("player 3:"+board.getLogic().getPlayer3().getPosition()+ "\n");
			System.out.println("turno "+board.getLogic().getTurn()+ "\n");

			constraints.gridx = 0; 
			constraints.gridy = 0;
			constraints.gridwidth = 3;
			constraints.gridheight = 3;
//			constraints.fill = GridBagConstraints.HORIZONTAL;
			add(board, constraints);
			

		}

		private class Listener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()== rollDice) {
					board.getLogic().setPause(false);
					System.out.println(board.getLogic().setPause(false)+"\n");

					//board.getLogic().initHuman();
					//board.getLogic().useDice();
					board.updatePlayers(); 
					//board.getLogic().getPlayer3().setPosition(20);

					System.out.println("player 1:"+board.getLogic().getPlayer1().getPosition()+ "\n");
					System.out.println("player 2:"+board.getLogic().getPlayer2().getPosition()+ "\n");
					System.out.println("player 3:"+board.getLogic().getPlayer3().getPosition()+ "\n");
					System.out.println("turno "+board.getLogic().getTurn()+ "\n");


					//board.getLogic().movePlayer(board.getLogic().getPlayer3());
					
					
				}
				if(e.getSource()== reStart) {
					board.clearBoard();
				}
				if(e.getSource()==exit) {
					System.exit(0);
				}
			}
			//public void playerStart() {
			//	if(board.getLogic().getTurn()  == 3) {
			//		board.getLogic().movePlayer(board.getLogic().getPlayer3());
			//	}
			//}
			
			
		}
}
