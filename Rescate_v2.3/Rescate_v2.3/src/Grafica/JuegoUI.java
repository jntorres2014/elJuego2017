package Grafica;

import java.awt.BorderLayout;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Rescate.Config;
import Rescate.Elemento;

public class JuegoUI extends JFrame implements ModeloListener, JuegoListener {
	private Config config = new Config();
	private Tablero tablero;
	
	public JuegoUI(){

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tablero = new Tablero();
		tablero.setBackground(Color.BLACK);
		tablero.setForeground(Color.red);
				
		
		Container panel = this.getContentPane(); //PANEL		
		panel.setLayout(new BorderLayout());
		panel.add(tablero, BorderLayout.CENTER);
				
		this.setSize(config.getAnchoTablero(),config.getAltoTablero());
		this.setVisible(true);	
	}
 
	
	public void iniciar(Modelo modelo){
		this.tablero.setModelo(modelo);		

		this.setVisible(true);
	}



	@Override
	public void actualizar() {
		this.tablero.paint();
	}
	
 
}
