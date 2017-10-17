package clases;

public class Misil extends Movible {
	
	private int nivelDanio;
	
	public Misil (int posicionX, int posicionY) {
	
		
	}
	
	
	public void destruir() {

	}

	
	public int getNivelDanio() {
		return nivelDanio;
	}


	public void setNivelDanio(int nivelDanio) {
		this.nivelDanio = nivelDanio;
	}


	@Override
	public void avanzar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void girar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void jugar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chocarContra(Elemento elemento) {
		
	}

	@Override
	public void morir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chocarPared() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chocarContraBonusReparacion(BonusReparacion bonus) {
		
		
		System.out.println("nada");
	}
	
	@Override
	public void chocarContraBonusMisil(BonusMisil bonus) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chocarContraBonusInmunidad(BonusInmunidad bonus) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void chocarContraMisil(Misil misil) {
		this.morir();
	}
	@Override
	public void chocarContraBomba(Bomba bomba) {
		this.morir();
	}
	@Override
	public void chocarContraNave(Nave nave) {
		this.morir();
	}
	@Override
	public void chocarContraObstaculoExplosivo(ObstaculoExplosivo obstaculo) {
		this.morir();
	}
}
