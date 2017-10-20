package Rescate;


public class BonusEscudo extends Bonus{
	
	private int escudo = 5;
	
	public BonusEscudo(int posicionX, int posicionY, Escenario escenario) {
		super(posicionX, posicionY, escenario);
		// TODO Auto-generated constructor stub
	}

	/**
	 * repara el escudo del robot
	 * @param robot
	 */
	public void recargarEscudo(Robot robot){
		robot.recargarEscudo(getEscudo());
	}

	/**
	 * recarga el escudo del robot recibido por parametro
	 */
	@Override
	public void chocarContraRobot(Robot robot) { //TODO agregar por si es un satelite
		this.recargarEscudo(robot);
	}
	
	
	/**
	 * recarga el escudo del dueño de la municion
	 */
	@Override
	public void chocarContraMunicion(Municion municion) {
		this.chocarContraRobot(municion.getRobot());
	}
	
	/**
	 * al chocar contra un elemento este se destruye
	 */
	@Override
	public void chocarContra(Elemento elemento) {
		this.destruir();
	}
	

	public int getEscudo() {
		return escudo;
	}


	public void setEscudo(int escudo) {
		this.escudo = escudo;
	}

}
