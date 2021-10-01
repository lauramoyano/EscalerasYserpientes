package escalerasYserpientes;

import java.util.Random;
// TODO: Auto-generated Javadoc
/**
 * The Class Dado. Esta clase simula un dado y permite ver el valor de su cara
 * visible.
 */
public class Dice {

	/** The cara visible. El valor (1 a 6) obtenido por el usuario en ese dado */
	private int caraVisible;
	private boolean ocupado;

	public Dice() {
		this.ocupado = false;
	}
	/**
	 * Gets the cara visible. Determina el valor de la cara visible.
	 *
	 * @return the cara visible. Un valor entre (1 - 6)
	 */
	public int getCardNumber() {
		Random aleatorio = new Random();
		caraVisible = aleatorio.nextInt(6) + 1;
		return caraVisible;
	}


}
