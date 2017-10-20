package Grafica;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import Rescate.Elemento;

public class Tablero extends Canvas implements JuegoListener {

	private Modelo modelo;
	private final int ANCHO = 100;
	private final int ALTO = 100;
	
	public Tablero(){
//		this.addMouseMotionListener(this);
	}
	
	
	public Modelo getModelo(ArrayList<Elemento> elemento) {
		return modelo;
	}


	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	
	

	public void paint() {
		Graphics g = this.getGraphics();
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		for (int i=0; i< elementos.size(); i++){
			//pinto cada elemento
			Elemento mostrar = elementos.get(i);//creo un elemento manipulable

			int x = (int)mostrar.getPosicion().getX();
			int y = (int)mostrar.getPosicion().getY();
			int alto = (int)mostrar.getTamanio().getAlto();
			int ancho = (int)mostrar.getTamanio().getAncho();			
			dibujar(x,y,alto,ancho);
		}
		
	}
	
	public void dibujar(int x, int y,int alto,int ancho){
		//ahora dibujamos el elemento
		Graphics g = this.getGraphics();
			//g.drawLine(x, y, alto, ancho);
			g.drawRect(x, y, alto, ancho);
			g.setColor(Color.GREEN);
			g.fillRect(x,y,alto,ancho);
			g.drawRect(x,y,alto,ancho);
			g.setColor(Color.RED);
			g.fillRect(x,y,alto,ancho);
			g.drawRect(x,y,alto,ancho);
	
	
	}
  }
