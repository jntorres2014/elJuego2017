package clases;

public abstract  class Elemento {
	private Posicion posicion;
	private Tamanio tamanio;
	private boolean estaVivo;
	
	public Elemento(Tamanio tamanio, Posicion posicion) {
		this.tamanio= tamanio;
		this.posicion= posicion;
	}
	
	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	public Tamanio getTamanio() {
		return tamanio;
	}

	public void setTamanio(Tamanio tamanio) {
		this.tamanio = tamanio;
	}

	public boolean isEstaVivo() {
		return estaVivo;
	}

	public void setEstaVivo(boolean estaVivo) {
		this.estaVivo = estaVivo;
	}
	

	public abstract void jugar() ;

	public abstract void chocarContra(Elemento elem);
	
	public abstract void chocarContraBonusReparacion (BonusReparacion bonus);	
	public abstract void chocarContraBonusMisil(BonusMisil bonus);
	public abstract void chocarContraBonusInmunidad(BonusInmunidad bonus);
	public abstract void chocarContraMisil(Misil misil);
	public abstract void chocarContraBomba(Bomba bomba);
	public abstract void chocarContraNave(Nave nave);
	public abstract void chocarContraObstaculoExplosivo(ObstaculoExplosivo obstaculo);
	public abstract void chocarPared();
	
	public  void morir() {
		
	}
}
