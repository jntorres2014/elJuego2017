package Rescate;

import java.awt.Robot;
import java.util.ArrayList;

import Grafica.JuegoListener;

public class Satelite extends Elemento implements RadarListener, JuegoListener{
	private int nivelEscudo;
	private int cantidadMuniciones;
	private Radar radar;
	

	
	public Satelite(int posicionX, int posicionY, Escenario escenario) {
		super(posicionX, posicionY, escenario);
		this.nivelEscudo=100;
		this.cantidadMuniciones=10;
	}

	@Override
	public void jugar() {
		for (int i=0; i< RadarListener.size(); i++){
			if (RadarListener.get(i) instanceof Robot){
				this.disparar();
				System.out.println("satelite disparo");
			}
		}
			
		
		
	}
	
	@Override
	public void chocarContra(Elemento elemento) {
		//TODO REVISAR SATELITE
		if(elemento instanceof Municion){
			Municion municion = (Municion) elemento;
			this.nivelEscudo = this.nivelEscudo - municion.getDaño();
		}
		if(elemento instanceof Bomba){
			Bomba bomba = (Bomba) elemento;
			this.nivelEscudo = this.nivelEscudo - bomba.getDanio();
		}
	}
		
	public void disparar(){
		if(this.cantidadMuniciones > 0){
			//TODO crear municion 
			this.cantidadMuniciones--;
		}
		
	}
	
	
	/**
	 * devuelve el radar que pertence a el satelite
	 * @return radar del satelite
	 */
	public Radar getRadar() {
		return radar;
	}


	/**
	 * setea un radar para un satelite
	 * @param radar
	 */
	public void setRadar(Radar radar) {
		this.radar = radar;
	}
	
	
	
	/**
	 * muestra el niverl de escudo que tiene el satelite
	 * @return nivel escudo
	 */
	public int getNivelEscudo() {
		return nivelEscudo;
	}
	
	/**
	 * setea el nivel de escudo del satelite
	 * @param nivelEscudo
	 */
	public void setNivelEscudo(int nivelEscudo) {
		this.nivelEscudo = nivelEscudo;
	}
	
	
	/**
	 * muestra la cantidad de municiones que tiene el satelite
	 * @return cantidad de municiones
	 */
	public int getCantidadMuniciones() {
		return cantidadMuniciones;
	}
	
	
	/**
	 * setea la cantidad de municiones de un saltelite
	 * @param cantidadMuniciones
	 */
	public void setCantidadMuniciones(int cantidadMuniciones) {
		this.cantidadMuniciones = cantidadMuniciones;
	}

	@Override
	public void elementosVistos(ArrayList<Elemento> elementos) {		
	}

	@Override
	public void chocarContraBonus(Bonus bonus) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chocarContraRobot(Rescate.Robot robot) {
		this.disparar();
		
		
	}

}
