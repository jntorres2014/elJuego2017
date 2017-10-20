package Rescate;


/**
 *  
 * @author Maxi Jones
 * @version 2.2
 */
public class Bomba extends Movible{
	private int danio;
	public static final int expancion = 5;
	
	/**
	 * Constructor de la clase Bomba
	 * @param posicionX
	 * @param posicionY
	 * @param escenario
	 * @return {@link #danio}
	 */
	public Bomba(int posicionX, int posicionY, Escenario escenario) {
		super(posicionX, posicionY, escenario);
		this.setDanio(20);
	}


	/**
	 * Se ejecuta si la bomba choca contra la pared, si es asi, explota y muere
	 */
	public void chocarContraParded() {
		explotar(this);
		this.destruir();
	}
	  
	/**
	 * Se ejecuta si la bomba choca contra algun tanque, si es asi, muere
	*/
	@Override
	public void cocharContraRobot(Robot robot) {
		//TODO no se que puede ir aca
	}
	
	
	/**
	 * Se ejecuta si la bomba choca contra algun bonus
	*/
	@Override
	public void chocoContraBonus(Bonus bonus) {
	//	bonus.chocarContraBomba(this);
		explotar(this);
		this.destruir();
	}
	
	
	/**
	 * comportamiento que toma la bomba al chochar contra un elemento
	 */
	@Override
	public void chocarContra(Elemento elemento) {
		//TODO aca tampoco se que puede ir
	}
	/**
	 * comportamiento que toma la bomba al destruirse
	 *  @return devuleve un area de combertura mas grande
	 */
	public void explotar(Bomba bomba){
		bomba.getTamanio().setAlto(bomba.getTamanio().getAlto()+expancion);
		bomba.getTamanio().setAncho(bomba.getTamanio().getAncho()+expancion);
		
	}

	
	

	/**
	 * Devuelve el daño que provoca la bomba
	 * @return daño 
	 */
	public int getDanio() {
		return danio;
	}

	/**
	 * Setea la variable daño de la bomba
	 * @param daño
	 */
	public void setDanio(int danio) {
		this.danio = danio;
	}
	

}
