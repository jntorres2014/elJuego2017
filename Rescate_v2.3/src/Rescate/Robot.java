package Rescate;

import java.util.ArrayList;

public class Robot extends Movible implements RadarListener{
	private int nivelEscudo;
	private int nivelEnergia;
	private boolean llevaPersona = false;
	private int cantidadMunicion;
	private int cantidadBomba;
	private Radar radar; 
	private Config config = new Config();
	private Municion municion;
	
	private Escenario escenario;	
	

	/**
	 * Constructor de clase
	 * @param posicionX
	 * @param posicionY
	 * @param escenario
	 */
	public Robot(int posicionX, int posicionY, Escenario escenario){
		super(posicionX, posicionY, escenario);
		this.radar = new Radar(this);
		this.radar.addRadarListener(this);
		this.municion = new Municion(posicionX, posicionY, escenario);
	}
	
	
	/**
	 * cada robot escanea en su turno
	 */
	@Override
	public void jugar() {
		if (this.getNivelEnergia()>=0){	
//			girar(10);
			super.avanzar();
			this.getRadar().escanear(this);			
		}
		else{
			this.destruir();
		}
	}
	
	
	/**
	 * realiza un desplazamiento hacia la direccion ya establecida
	 */
	@Override
	public void avanzar() {
		if(!(this.getNivelEnergia()<=0)){
			super.avanzar();			
			this.setNivelEnergia(this.getNivelEnergia()-1);
		}
	}
	
	/**
	 * Se ejecuta si el robot choca contra la pared
	 * 
	*/
	@Override
	public void chocarContraPared() {
		super.girar(160);
	}

	

	/**
	 * decrementa el escudo de un robot si choca contra una municion
	*/
	@Override
	public void chocoContraMunicion(Municion municion) {
		this.setNivelEscudo(this.getNivelEscudo()- municion.getDaño());
		System.out.println("DAÑO RECIBIDO: , "+this.getNivelEscudo());
	}
	
	@Override
	public void chocarContraBonus(Bonus bonus) {
		bonus.destruir();
	}
	
	public void chocarContraRefugio(Refugio refugio){
		refugio.salvarPersona();
		girar(180);		
		this.llevaPersona=false;
	}
	
	
	public void chocarContraZonaRescate(ZonaRescate zonaRescate){
		zonaRescate.rescatarPersona();
		this.llevaPersona= true;
		girar(180);
	}
	
	public void chocarContraBomba(Bomba bomba){
		this.setNivelEscudo(this.getNivelEscudo()-15); //TODO 15 ES EL DAÑO DE LA BOMBA, PONERLO CMO SET EN EL config
		
	}
	
	/**
	 * devuelve el radar que pertence a el robot
	 * @return radar del robot
	 */
	public Radar getRadar() {
		return radar;
	}


	/**
	 * setea un radar para un robot
	 * @param radar
	 */
	public void setRadar(Radar radar) {
		this.radar = radar;
	}


	
	/**
	 *  Procedimiento que responde a disparar municion
	 */
	public void dispararMunicion(){
		if (this.cantidadMunicion > 0){
		//	Municion municion =  new Municion(this);
		//	this.getEscenario().addElemento(municion);
			this.cantidadMunicion--;
			
		}
		
	}
	
	
	/**
	 * Procedimiento que responde a lanzar bomba
	 */
	public void lanzarBomba(){
		if (this.cantidadBomba > 0){
			this.cantidadBomba--;
		}
	}
	
	
	/**
	 * Procedimiento que responde cuando se carga a una persona para rescatar
	 */
		public void cargarPersona(){
		this.llevaPersona = true;
	}
	
		
	/**
	 * retorna si el robot esta vivo, si su nivel de escudo es 0 se lo destruye
	 */				
	public boolean estaVivo() {
		 return super.estaVivo();
	}


	/**
	 * Muestra el nivel de escudo del robot
	 * @return nivel de escudo del robot
	 */
	public int getNivelEscudo() {
		return nivelEscudo;
	}
	
	
	/**
	 * Este metodo se ejecuta cuando el elemento choca contra otro elemento.
	 * En el mismo se efectua la accion correspondiendo dependiendo del elemento
	 * contra el que se choco.
	 * @param elemento Elemento contra el que esta chocando
	 */
	@Override
	public void chocarContra(Elemento elemento) {	
		elemento.chocarContraRobot(this); //robot		
	}
	
	
	



	/**
	 * Setea el nivel de escudo del robot
	 * @param nivelEscudo
	 */
	public void setNivelEscudo(int nivelEscudo) {
		this.nivelEscudo = nivelEscudo;
	}
	
	
	/**
	 * se decrementa el nivel de escudo del robot en una cantidad dada
	 * @param daño
	 */
	public void romperEscudo(int daño){
		this.setNivelEscudo(this.getNivelEscudo()-daño);
	}
	
	
	
	/**
	 * incrementa el escudo del robot con una cantidad dada
	 * @param escudo
	 */
	public void recargarEscudo(int escudo){
		this.setNivelEscudo(this.getNivelEscudo()+escudo);
	}
	
	
	
	
	/**
	 * muestra el nivel de energia del robot
	 * @return
	 */
	public int getNivelEnergia() {
		return nivelEnergia;
	}
	
	/**
	 * Setea el nivel de energia del robot
	 * @param nivelEnergia
	 */
	public void setNivelEnergia(int nivelEnergia) {
		this.nivelEnergia = nivelEnergia;
	}
	
	
	
	/**
	 * recarga la energia del robot con una cantidad dada
	 * @param energia
	 */
	public void recargarEnergia(int energia){
		this.setNivelEnergia(this.getNivelEnergia()+energia);
	}
	
	
	/**
	 * muestra la cantidad de municiones que posse el robot
	 * @return
	 */
	public int getCantidadMunicion() {
		return cantidadMunicion;
	}
	
	
	/**
	 * Setea la cantidad de municiones que tiene el robot
	 * @param cantidadMunicion
	 */
	public void setCantidadMunicion(int cantidadMunicion) {
		this.cantidadMunicion = cantidadMunicion;
	}
	
	
	/**
	 * Muestra la cantidad de bombas que tiene el robot
	 * @return
	 */
	public int getCantidadBomba() {
		return cantidadBomba;
	}
	
	
	/**
	 * Setea la cantidad de bombas que tiene el robot
	 * @param cantidadBomba
	 */
	public void setCantidadBomba(int cantidadBomba) {
		this.cantidadBomba = cantidadBomba;
	}
	//TODO inplementar chocar contra BOMBA
	
	/**
	 * muestr el escenario del robot
	 */
	public Escenario getEscenario() {
		return escenario;
	}


	/**
	 * setea el escenario para el robot
	 */
	public void setEscenario(Escenario escenario) {
		this.escenario = escenario;
	}

	
	/**
	 * devulve el estado de el robot si lleva una persona o no
	 * @return true o false
	 */
	public boolean isLlevaPersona() {
		return llevaPersona;
	}

	
	/**
	 * setea el estado del robot si lleva una persona o no
	 * @param llevaPersona
	 */
	public void setLlevaPersona(boolean llevaPersona) {
		this.llevaPersona = llevaPersona;
	}


	/**
	* Metodo para realizar acciones cuando el radar detecta elementos
	*/
	@Override
	public void elementosVistos(ArrayList<Elemento> elementosVistos) {
		/**
		 * Avanza el tanque si aun posee combustible
		*/
		this.girar(10);
		avanzar();
	}


	public Municion getMunicion() {
		return municion;
	}


	public void setMunicion(Municion municion) {
		this.municion = municion;
	}

}
