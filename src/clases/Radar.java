package clases;

import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.print.attribute.standard.Sides;

public class Radar implements IRadarListener{

	private int direccion;
	private int anguloApertura;
	private int alcance;
	private ArrayList<IRadarListener> radarListeners ;
	
	
	
	
	public Radar() {
		this.radarListeners= new ArrayList<IRadarListener>();
	}
	public void addRadarListener(IRadarListener listener) {
		this.radarListeners.add(listener);
	}
	public void removeRadarListener(IRadarListener listener) {
		this.radarListeners.remove(listener);
	}
	
	
	
	public int getDireccion() {
		return direccion;
	}





	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}





	public int getAnguloApertura() {
		return anguloApertura;
	}





	public void setAnguloApertura(int anguloApertura) {
		this.anguloApertura = anguloApertura;
	}





	public int getAlcance() {
		return alcance;
	}





	public void setAlcance(int alcance) {
		this.alcance = alcance;
	}





	public ArrayList<IRadarListener> getRadarListeners() {
		return radarListeners;
	}





	public void setRadarListeners(ArrayList<IRadarListener> radarListeners) {
		this.radarListeners = radarListeners;
	}




	public void girar() {
		
	}
	public Polygon getAreaCobertura(){
		Polygon area = new Polygon();
		//area.addPoint(arg0, arg1);
		Rectangle rect= new Rectangle();
		return area;
		
	}
	
	private void escanear() {
		ArrayList<Elemento> elementos = new ArrayList<>();
		
		NaveCrazy nave = new NaveCrazy();
		NaveCrazy nave2 = new NaveCrazy();
		elementos.add(nave);
		elementos.add(nave2);
		//Agregar logica de poligonos
		
		if (elementos.size()>0) {
			for (int i = 0; i < radarListeners.size(); i++) {
				radarListeners.get(i).elementoDetectado(elementos);// agregar la logica de los detectados
			}
		}
	}

	public void escanear(int angulo) {

	}
	@Override
	public void elementoDetectado(ArrayList<Elemento> elementos) {
		// TODO Auto-generated method stub
		
	}
}
