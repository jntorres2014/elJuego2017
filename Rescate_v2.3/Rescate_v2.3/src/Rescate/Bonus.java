package Rescate;


//TODO [CORRECCION] Falta documentacion 
public class Bonus extends Elemento{

	private int tiempoDeVida;
	
	
	
	
	public Bonus(int posicionX, int posicionY, Escenario escenario) {
		super(posicionX, posicionY, escenario);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public void chocarContraMunicion(Municion municion) {}
	
	
	
	/**
	 * Consulta el estado de un bonus
	 */
	@Override
	public boolean estaVivo() {
		return super.estaVivo();
	}
	
	
	/**
	 * juega el bonus hasta que termine a su tiempo de vida 
	 */
	@Override
	public void jugar() {
		this.setTiempoDeVida(this.getTiempoDeVida()-1);
		this.estaVivo();
	}
	
	
	/**
	 * retorna la llamada al elemento contra el que choco
	 */
	@Override
	public void chocarContra(Elemento elemento) {
		elemento.chocarContraBonus();
		this.destruir();
	}	
	

	
	public void chocarContraRobot(Robot robot){}   //se redefine en las subclases de bonus
	
	
	/**
	 * retorna el tiempo de vida del bonus
	 * 
	 * @return Tiempo de vida seteado
	 */
	public int getTiempoDeVida() {
		return tiempoDeVida;
	}
	
	
	/**
	 * Setea el tiempo de vida del bonus
	 * 
	 */
	public void setTiempoDeVida(int tiempoDeVida) {
		this.tiempoDeVida = tiempoDeVida;
	}


	@Override
	public void chocarContraBonus(Bonus bonus) {
		// TODO Auto-generated method stub
		
	}
	
}
