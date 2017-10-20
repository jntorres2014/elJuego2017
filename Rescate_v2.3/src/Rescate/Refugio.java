package Rescate;

public class Refugio extends Elemento{
	
	private Persona[] persona; 
	
	
	public Refugio(int posicionX, int posicionY, Escenario escenario) {
		super(posicionX, posicionY, escenario);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void jugar() {
		// TODO Auto-generated method stub
		
	}
	
	public void quitarPersona(){
		
	}
	
	public void chocarContraRefugio(){
		
	}
	
	@Override
	public void chocarContra(Elemento elemento) {
		
		
	}
	
	
	public void salvarPersona(){
		//TODO [CORRECCION] falta implementar
	}

	

	
	/**
	 * Muestra la lista de personas
	 * @return
	 */
	public Persona[] getPersona() {
		return persona;
	}

	
	
	/**
	 * Setea la lista de personas
	 * @param persona
	 */
	public void setPersona(Persona[] persona) {
		this.persona = persona;
	}

	@Override
	public void chocarContraBonus(Bonus bonus) {		
		
	}

	@Override
	public void chocarContraRobot(Robot robot) {
		this.salvarPersona(); //TODO ACMODAR EL SALVAR PERSONA				
	}
}
