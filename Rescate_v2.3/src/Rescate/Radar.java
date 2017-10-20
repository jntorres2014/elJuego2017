package Rescate;

import java.awt.Polygon;
import java.util.ArrayList;

import Grafica.JuegoListener;

public class Radar implements RadarListener, JuegoListener{
	private int anguloApertura=50;
	private int alcance=50;
	private int alcanceMaximo=100;
	private int direccion;
	private Robot robot;
	
	
	ArrayList<RadarListener> RadarListener = new ArrayList<RadarListener>();
	ArrayList<Elemento> elementosVistos= new ArrayList<Elemento>();
	
	
	/**
	 * 	crea un radar y se lo asigna a un robot
	 * @param satelite robot al que se le agrega el radar
	 */	
	public Radar(Satelite satelite){
//		this.satelite= satelite;
	}
	
	
	/**
	 * 	crea un radar y se lo asigna a un robot
	 * @param satelite robot al que se le agrega el radar
	 */	
	public Radar(Robot robot){
		this.robot = robot;
	}
	
	
	/**
	 * gira con respecto a un  angula dado
	 * @param angulo
	 */
	public void girar (int angulo){
		int dirNueva = this.getDireccion() + angulo;
		while (dirNueva >= 360){
			dirNueva = dirNueva - 360;
		}
		this.setDireccion(dirNueva);
	}
	
	
	/**
	 * Escanea para detectar  elementos dentro de su alcance e informar a los que
	 * lo escuchan
	 */
   public void escanear(Elemento elemento){
	   this.girar(10);
	   if(!elemento.getEscenario().verElementos(this).isEmpty()){      	//escanea los elementos distintos al dueño del radar		   		
		   		for(RadarListener listeners : this.RadarListener){					
					listeners.elementosVistos(elementosVistos);				
				}
			}
}

 
	
	
	/**
	 * Utiliza el poligono para detectar elementos en un angulo determinado por su distrancia
	 * @return area de cobertura que cubre el robot
	 */
	public Polygon getAreaCobertura() {

	   	Polygon areaCobertura = new Polygon();
	  
	   	
		int robotX= (int)robot.getPosicion().getX()+10; 
		int robotY= (int)robot.getPosicion().getY()+10;
		
		areaCobertura.addPoint(robotX, robotY);
		
		for (int i = (this.getDireccion())-(this.getAnguloApertura()/2);
				 i < (this.getDireccion())+(this.getAnguloApertura()/2); 
				 i++) {
			
			int x= (int) (robotX+ Math.cos(Math.toRadians(i))*this.getAlcance());
			int y= (int) (robotY+ Math.sin(Math.toRadians(i))*this.getAlcance());
		
			areaCobertura.addPoint(x, y);
		}		
		
		
		return areaCobertura; //devuelvo todo el poligono
	}
	
	
	
	
	/***
	 * agrega un elemento a su lista de escuchadores
	 * @param listener
	 */
	public void addRadarListener(RadarListener listener) {
		this.RadarListener.add(listener);
	}

	
	/***
	 * elimina un elemento de su lista de escuchadores
	 * @param listener
	 */
	public void removeRadarListener(RadarListener listener) {
		this.RadarListener.remove(listener);
	}
	
	/**
	 * Devuelve el angulo de Apertura de vision del radar
	 * @return angulo de apertura del radar
	 */
	public int getAnguloApertura() {
		return anguloApertura;
	}
	
	
	/**
	 * Setea el angulo de apertura de vision del radar
	 * @param anguloApertura 
	 * 
	 */
	public void setAnguloApertura(int anguloApertura) {
		this.anguloApertura = anguloApertura;
		double angulo=(double)(anguloApertura);
		this.alcance=(int)(this.alcance - (this.alcanceMaximo*(angulo/360)));
	
	}
	
	
	/**
	 * Muestra el alcance que tiene el radar
	 * @return
	 */
	public int getAlcance() {
		return alcance;
	}
	
	
	
	/**
	 * Setea el alcance que tiene el radar
	 * @param alcance
	 */
	public void setAlcance(int alcance) {
		this.alcance = alcance;
	}
	
	
	/**
	 * muestra la direccion del radar
	 * @return
	 */

	public int getDireccion() {
		return direccion;
	}

	
	
	/**
	 * setea la direccion del radar
	 * @param direccion
	 */
	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}


	/**
	 * retorna a que robot corresponde el radar
	 * @return robot que usa el radar
	 */
	public Robot getRobot() {
		return robot;
	}


	@Override
	public void elementosVistos(ArrayList<Elemento> elementos) {
		// TODO Auto-generated method stub
		
	}


	


}
