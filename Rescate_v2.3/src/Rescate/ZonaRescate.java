package Rescate;

import java.util.ArrayList;
//TODO controlar que la persona rescatada es de aca
public class ZonaRescate extends Elemento{
											
	private ArrayList<Persona> personas;
	private Persona persona = new Persona("PEPE");

	
	public ZonaRescate(int posicionX, int posicionY, Escenario escenario) {
		super(posicionX, posicionY, escenario);
		this.personas= new ArrayList<Persona>();
		personas.add(persona);
		personas.add(persona);
		personas.add(persona);
		personas.add(persona);
		personas.add(persona);
		
	
	}
	
	
	
	
	@Override
	public void jugar() {
	// TODO tendria que hacer algo?
			
	}
	@Override
	public void chocarContra(Elemento elemento) {
		elemento.chocarContra(this);
	}
	
	public void rescatarPersona(){
		personas.remove(personas); 
	}
	
	public void chocarContraRobot(Robot robot){
		
	}




	@Override
	public void chocarContraBonus(Bonus bonus) {
		// TODO Auto-generated method stub
		
	}

	
		
	
}
	