package clases;

public class Bomba extends Movible{

	private int nivelDa�o=20;
	
	@Override
	public void jugar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chocarContra(Elemento elemento) {

		this.morir();
	}

	@Override
	public void chocarPared() {

		this.morir();
	}

	@Override
	public void chocarContraBonusReparacion(BonusReparacion bonus) {

		System.out.println("no hace nada");
	}
	
	@Override
	public void chocarContraBonusMisil(BonusMisil bonus) {
		System.out.println("nada");		
	}

	@Override
	public void chocarContraBonusInmunidad(BonusInmunidad bonus) {
		
	}

	@Override
	public void chocarContraMisil(Misil misil) {

		this.morir();
	}
	@Override
	public void chocarContraBomba(Bomba bomba) {
		this.morir();
	}

	public int getNivelDa�o() {
		return nivelDa�o;
	}

	public void setNivelDa�o(int nivelDa�o) {
		this.nivelDa�o = nivelDa�o;
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
