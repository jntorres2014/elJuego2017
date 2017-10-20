package Rescate;


/**
 * Clase donde los elementos tienen la particularidad de moverse dentro del escenario
 * @author Maxi Jones
 *
 */
public class Movible extends Elemento{
	private int direccion=23;
	private int velocidad=23;
	
	
	/**
	 * Constructor de clase 
	 * @param posicionX
	 * @param posicionY
	 * @param escenario
	 */
	public Movible(int posicionX, int posicionY, Escenario escenario) {
		super(posicionX, posicionY, escenario);
	}



	@Override
	public void jugar(){
		//no hace nada
	}
	
	
	
	/**
	 * metodo para poder avanzar dentro del escenario dandole una direccion	
	 */
	public void avanzar() {
		this.getPosicion().setX((int) (this.getPosicion().getX()+ Math.cos(Math.toRadians(this.direccion))*this.velocidad));
		this.getPosicion().setY((int) (this.getPosicion().getY()+ Math.sin(Math.toRadians(this.direccion))*this.velocidad));
	}
	
	
	/**
	 * cambia la direccion con respecto al angulo actual
	 * @param angulo 
	 */
	public void girar(int angulo){
		int dirNueva = this.getDireccion()+angulo;
		while (dirNueva >= 360){
			dirNueva = dirNueva - 360;
		}
		this.setDireccion(dirNueva);
	}
	
	
	
	/**
	 * Se ejecuta el metodo si un elemento choca contra un robot
	 */
	public void cocharContraRobot(Robot robot){}
	
	
	/**
	 * Se ejecuta el metodo si un elemento choca contra un bonus
	 */
	public void chocoContraBonus(Bonus bonus) {}
	
	
	/**
	 * Se ejecuta el metodo si un elemento choca contra una municion
	 */
	public void chocoContraMunicion(Municion municion) {}
	
	
	
	/**
	 * muestra la direccion que tiene un obj movible
	 * @return direccion del movible
	 */
	public int getDireccion() {
		return direccion;
	}
	
	
	/**
	 * setea la direccion del obj movible
	 * @param direccion
	 */
	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}
	
	
	/**
	 * retorna la velocidad del obj movible
	 * @return velocidad del movible
	 */
	public int getVelocidad() {
		return velocidad;
	}
	
	
	
	/**
	 * setea la velocidad del obj movible
	 * @param velocidad
	 */
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}



	@Override
	public void chocarContra(Elemento elemento) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void chocarContraBonus(Bonus bonus) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void chocarContraRobot(Robot robot) {		
	}

		
	

}
