package Rescate;


public class BonusBateria extends Bonus{
	
	private int energia ;
	
	
	public BonusBateria(int posicionX, int posicionY, Escenario escenario) {
		super(posicionX, posicionY, escenario);
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	/**
	 * recarga la energia del dueño de la municion
	 */
	@Override
	public void chocarContraMunicion(Municion municion) {
		this.chocarContraRobot(municion.getRobot());
	}
	
	
	/**
	 * recarga la energia del robot
	 */
	@Override
	public void chocarContraRobot(Robot robot) {
		this.recargarEnergia(robot);
	}
	
	
	/**
	 * al chocar contra un elemento este se destruye
	 */
	@Override
	public void chocarContra(Elemento elemento) {
		this.destruir();
	}
    
	
	/**
	 * recarga la energia del robot
	 * @param robot
	 */
	public void recargarEnergia(Robot robot){
		robot.recargarEnergia(getEnergia());
	}
	 
	/**
	 * obtiene la energia del bonus
	 * @return
	 */
	public int getEnergia() {
		return energia;
	}

	/**
	 * setea la energia que otorga el bonus
	 * @param energia
	 */
	public void setEnergia(int energia) {
		this.energia = energia;
	}

	
	

}
