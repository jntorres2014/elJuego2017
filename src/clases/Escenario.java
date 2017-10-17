package clases;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;

public class Escenario {

	private ArrayList<Elemento> elementos;
	private int tiempo;
	private Movible mov;
	
	public void iniciar () {
	
		this.crearElementosIniciales();
		
		while (tiempo > 0) {
			this.turno();
			verificarChoques();
			quitarElementos();
			//mostrar estados del juego
			this.tiempo--;
			this.mostrarEstado();
		}
	}



	private void crearElementosIniciales() {
		
		Movible nave = new NaveCrazy();
		Elemento bonus = new BonusInmunidad();
		Elemento bomba = new Bomba();
		Posicion posicion = new Posicion();
		
		posicion.setX(10);
		posicion.setY(10);
		bonus.setPosicion(posicion);
		nave.setPosicion(posicion);
		bomba.setPosicion(posicion);
		
//		elementos.add(nave);
//		elementos.add(bonus);
//		elementos.add(bomba);
	
	}
	
	private void turno() {
		
		//jugar de los elementos
		for (int i = 0; i < this.elementos.size(); i++) {
			Elemento e = this.elementos.get(i);
			e.jugar();
			mov.avanzar();
		}
	}
//	verificar Colisiones
//		java.awt.Rectangle 
// investigar 	Rectangle.intersect(src1, src2, dest);
//		Rectangle rect = new Rectangle();
//		rect.union(r);
		//	verificar Chocar contra pared
//	private void chocarContraPared() {

	//		Nuevo metodo de los elementos
		private void verificarChoques() {
			for (int i = 0; i < elementos.size(); i++) {
				Elemento elem1 = this.elementos.get(i);
				
				int coordenada1 = elem1.getPosicion().getX();
				int coordenada2 = elem1.getPosicion().getY();
				
				Rectangle rectangulo = new Rectangle(coordenada1,coordenada2,
										elem1.getTamanio().getAncho(),elem1.getTamanio().getAlto());
				for (int j = i+1; j < elementos.size(); j++) {
				
					Elemento elem2 = elementos.get(j);
					Rectangle rectangulo2 = new Rectangle(elem2.getPosicion().getX(),
												elem2.getPosicion().getY(), 
											elem2.getTamanio().getAncho(),
											elem2.getTamanio().getAlto());
					if(rectangulo.intersects(rectangulo2)) {
						elem1.chocarContra(elem2);
						elem2.chocarContra(elem1);
					}
				}
				
			}
		}
		//quitar elementos muertos
			// preguntar por estar vivos
		// quitarElementos();
		private void mostrarEstado() {

			System.out.println("jugada: "+this.tiempo);
		//	for (Elemento elemento :this.elementos) {
				
//			}
			
		}
	
	private void quitarElementos() {
		for (int i = 0; i < this.elementos.size(); i++) {
			Elemento e = this.elementos.get(i);
			if (e.isEstaVivo()== false) {
				elementos.remove(i);
			}
		}
		
	}
	
}
