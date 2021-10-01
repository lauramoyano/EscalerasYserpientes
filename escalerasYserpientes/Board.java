package escalerasYserpientes;


import javax.swing.JLabel;
import javax.swing.JPanel;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;



import javax.swing.ImageIcon;


public class Board extends JPanel {
	

	private ImageIcon player1;
	private ImageIcon player2; 
	private ImageIcon player3;
	private Logic logic;
	private Image image;
	private JLabel[] panelHolder = new JLabel[100];

	
	public Board() {
		this.setLayout(new GridLayout(10, 10));
		this.image = new ImageIcon( getClass().getResource( "/images/serpientes_y_escaleras.jpg") ).getImage();
		this.logic = new Logic();
		this.player1 = new ImageIcon("src/images/"+ logic.getPlayer1().getTurn() +".png");
		this.player2 = new ImageIcon("src/images/"+ logic.getPlayer2().getTurn() +".png"); 
		this.player3 = new ImageIcon("src/images/"+ logic.getPlayer3().getTurn() +".png");
		
		
		
		for(int m = 0; m < 100; m++) {
				panelHolder[m] = new JLabel();
				add(panelHolder[m]); 
			 
		}
		this.ja();
		
	}
	
	public Logic getLogic(){
		return logic;
	}

	public void ja() {
		logic.movePlayer(logic.getPlayer1());
		logic.movePlayer(logic.getPlayer2());
		logic.movePlayer(logic.getPlayer3());

	}
	 
	public JLabel[] getPanelHolder() {
		return panelHolder;
	}

	public Dimension getPreferredSize() { 
      if (image != null) {
         return new Dimension(image.getWidth(this), image.getHeight(this));
      }
      return super.getPreferredSize(); // default
   }
	 
	protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (image != null) {
         g.drawImage(image, 0, 0, null); 
      }
   }
  
   public int indexConverter (int playerPosition){
	  double x =playerPosition%10;
	  double y = playerPosition/10;
	  y = Math.floor(y);
	  boolean condition = (y%2) == 1;
	  y=-(y*10)+90;
	  if(condition){
		 x=9-x; 
	  }
	  
	  int result = (int) Math.floor(x+y);
	  return result;
   }

	public void updatePlayers(){
		for(int m = 0; m < 100; m++) {
			remove(panelHolder[m]);
			
		}
		for(int m = 0; m < 100; m++) {
			panelHolder[m] = new JLabel();
			add(panelHolder[m] );
		}
		this.panelHolder[this.indexConverter(logic.getPlayer1().getPosition())].setIcon(player1);
		this.panelHolder[this.indexConverter(logic.getPlayer2().getPosition())].setIcon(player2);
		this.panelHolder[this.indexConverter(logic.getPlayer3().getPosition())].setIcon(player3);
	  	
	}
	public void clearBoard() {
		
	}
	
	
}