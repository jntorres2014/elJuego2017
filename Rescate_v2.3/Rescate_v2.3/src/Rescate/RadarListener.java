package Rescate;

import java.util.ArrayList;

public interface RadarListener {
	
	ArrayList<RadarListener> RadarListener = new ArrayList<RadarListener>();
	
	/**
	 * los que implementen esta interfaz, deberan cargar los elementos encontrados aqui
	 * @param elementosVistos
	 */
	public void elementosVistos(ArrayList<Elemento> elementos);
	
	
}
