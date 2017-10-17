package clases;

public abstract class Bonus extends Elemento {

	public Bonus(Tamanio tamanio, Posicion posicion) {
		super(tamanio, posicion);
	}
	private int tiempoDeVida;

	
	

	
	public int getTiempoDeVida() {
		return tiempoDeVida;
	}





	public void setTiempoDeVida(int tiempoDeVida) {
		this.tiempoDeVida = tiempoDeVida;
	}



	@Override
	public void chocarContraMisil(Misil misil) {
	System.out.println("nada");
	}

	@Override
	public void chocarContraBomba(Bomba bomba) {
		System.out.println("nada");
	}
	public abstract void darBeneficio();
	@Override
	public void chocarContraNave(Nave nave) {
		this.morir();
	}
	@Override
	public void chocarContraObstaculoExplosivo(ObstaculoExplosivo obstaculo) {
		
	}
}
