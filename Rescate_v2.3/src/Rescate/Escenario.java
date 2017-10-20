package Rescate;

import java.awt.Rectangle;
import java.util.ArrayList;

import Grafica.JuegoListener;
import Grafica.JuegoUI;
import Grafica.Modelo;


public class Escenario implements JuegoListener{
	private Config config = new Config();
	/**
	 * se queda en un bucle dando turnos a cada elemento para que implemente sus metodos
	 */
	public void iniciarJuego(){
		crearElementos();
		
		//CREAMOS LA PARTE GRAFICA
		JuegoUI vista = new JuegoUI();
		vista.iniciar(new Modelo()); 
		
		while(true){
			
		 	turnos();		 					 	
		 	
		 	vista.actualizar();
			
			verficarChoques();
			
			depurarElementos();
			//Actualizar Estados
			
			actualizarEnConsola();
			
		 	try {
				Thread.sleep(100); //aca va un 1000
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * muestra los estados en la consola
	 */
	private void actualizarEnConsola() {
		for(int i=0; i<elementos.size();i++){
			Elemento e = elementos.get(i);
			System.out.println(e.getClass().getName()+"- Posicion: , X: "+e.getPosicion().getX()+", Y: "+ e.getPosicion().getY());
		}
		
	}


	/**
	 * añade a una lista todos los elementos que puede visualizar un radar
	 * @param radar
	 * @return lista de elementos
	 */
	public ArrayList<Elemento> verElementos(Radar radar){
		ArrayList<Elemento> elementosVistos = new ArrayList<Elemento>();
		for(int i= 0; i< elementos.size();i++){
			Elemento elemento = JuegoListener.elementos.get(i);
			if(elemento != radar.getRobot()){
				if(radar.getAreaCobertura().contains((int)elemento.getPosicion().getX(),
													(int)elemento.getPosicion().getY())){
					elementosVistos.add(elemento);
				}
			}
		}
		return elementosVistos;
	}
	
	
	
	
	
	/**
	 * Se encarga de monitorear los estados de vida de los elementos presentes en el juego
	 * en caso de que un elemento no este vivo es retirado del juego.
	 * 
	 */
	private void depurarElementos() {
		for(int i=0; i<JuegoListener.elementos.size();i++){
			if (!JuegoListener.elementos.get(i).estaVivo())
				JuegoListener.elementos.remove(i);
		}
		
	}
	
	
	
	/**
	 * controla si un elemento se choco con otro elemento dentro del escenario
	 */
	private void verficarChoques() {
		
		for(int i=0; i<JuegoListener.elementos.size();i++){
			
			Elemento e1 = JuegoListener.elementos.get(i);
			
			//guaramos las coordenadas para verificar si choco contra el tablero
			int coord1 = e1.getPosicion().getX();
			int coord2 = e1.getPosicion().getY();
			//Creamos el rectangulo
			Rectangle r1 = new Rectangle(e1.getPosicion().getX(),
										e1.getPosicion().getY(),
										e1.getTamanio().getAncho(),
										e1.getTamanio().getAlto());
			
			for(int j=i+1; j<JuegoListener.elementos.size(); j++){
				
				//Creamos el rectangulo
				Elemento e2 = JuegoListener.elementos.get(j);
				Rectangle r2 = new Rectangle(e2.getPosicion().getX(),
						e2.getPosicion().getY(),
						e2.getTamanio().getAncho(),
						e2.getTamanio().getAlto());
				if(r1.intersects(r2)){
					e1.chocarContra(e2);
					e1.chocarContra(e1);
				}
			}
			// estaContenidoDentro, hace referencia si no se paso del tope del tablero
			// esta contenidoposito, se fija si las posiciones son positivas 
			boolean estaContenidoDentro = ( (coord1 >= this.config.getAnchoTablero()) || (coord2 >= this.config.getAltoTablero()) ); 
			boolean estaContenidoPositivo= (coord1<= 0) || (coord2 <= 0 ); 
			if(estaContenidoPositivo || estaContenidoDentro){
				e1.chocarContraPared();
			}			
		}


	}


	/**
	 * le da un turno a cada elemento
	 */
	private void turnos() {
		for(int i=0; i<JuegoListener.elementos.size(); i++){
			Elemento elemento = JuegoListener.elementos.get(i);
			
			elemento.jugar();
		}
	}

	/**
	 * crea un elemento y lo añade a la lista de elementos
	 */
	private void crearElementos() {
		
		
		Refugio refugio = new Refugio(270, 250, this); 
		JuegoListener.elementos.add(refugio);
		
		
		Robot robot1 = new Robot(220, 150, this);
		robot1.setNivelEnergia(100);		
		JuegoListener.elementos.add(robot1);
		robot1.setCantidadBomba(10);
		robot1.setCantidadMunicion(10);
		robot1.setRadar(new Radar(robot1));
		
		
		Robot robot2 = new Robot(120, 150, this);
		robot2.setNivelEnergia(100);		
		JuegoListener.elementos.add(robot2);
		robot2.setCantidadBomba(10);
		robot2.setCantidadMunicion(10);
		robot2.setRadar(new Radar(robot2));
		
		
		Satelite satelite = new Satelite(260,250,this);
		JuegoListener.elementos.add(satelite);
		satelite.setRadar(new Radar(satelite));
		
		ZonaRescate zonaRescate = new ZonaRescate(80, 70, this);
		JuegoListener.elementos.add(zonaRescate);
		
		Bonus bonus = new BonusBateria(55, 55, this);
		bonus.setTiempoDeVida(45);
		JuegoListener.elementos.add(bonus);
		
	}
	
	/**
	 * retorna la lista de todos los elementos activos del escenario
	 * @return lista de elementos
	 */
	public ArrayList<Elemento> getElementos() {
		return elementos;
	}

	
	/**
	 * agrega un elemento a la lista de elementos del escenario
	 * @param elementos
	 */
	public void addElemento(Elemento elemento) {
		JuegoListener.elementos.add(elemento);
	}
	
		
			
			
	
	
}
