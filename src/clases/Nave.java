package clases;


public abstract class Nave extends Movible implements IRadarListener {

	
	private int combustible;
	private int misiles;
	private int nivelDestruccion;
	private int bombas;
	private Radar radar;
	private boolean inmune;
	
	public Nave() {
		this.radar= new Radar();
		this.radar.addRadarListener(this);
	}
	
	
	public int getCombustible() {
		return combustible;
	}

	
	
	
	public boolean isInmune() {
		return inmune;
	}


	public void setInmune(boolean inmune) {
		this.inmune = inmune;
	}


	public void setCombustible(int combustible) {
		this.combustible = combustible;
	}

	public int getMisiles() {
		return misiles;
	}

	public void dispararMisil() {
		if (this.getMisiles() > 0)
			Misil misil = new Misil();
			misil.setDireccion(getDireccion());
			//Crear un misil en la posicion de la nave
			this.setMisiles(getMisiles()-1);
	}
	public void dispararBomba() {
			if (this.getBombas() > 0)
		//crear una bomba en la posicion de la nave
		this.setBombas(getBombas()-1);
	}
	public void setMisiles(int misiles) {
		this.misiles = misiles;
	}

	public int getNivelDestruccion() {
		return nivelDestruccion;
	}

	public void setNivelDestruccion(int nivelDestruccion) {
		this.nivelDestruccion = nivelDestruccion;
	}

	public int getBombas() {
		return bombas;
	}

	public void setBombas(int bombas) {
		this.bombas = bombas;
	}

	public Radar getRadar() {
		return radar;
	}

	public void setRadar(Radar radar) {
		this.radar = radar;
	}

	

	@Override
	public void avanzar() {
		super.avanzar();
		this.setCombustible(getCombustible()-20);
		
	}
	@Override
	public void girar() {
		// TODO Auto-generated method stub
		}

	@Override
	public void chocarContra(Elemento elem) {
		if (elem instanceof BonusMisil) 
			chocarContraBonusMisil((BonusMisil)elem);
		if (elem instanceof BonusInmunidad) 
			chocarContraBonusInmunidad((BonusInmunidad)elem);
		if (elem instanceof BonusReparacion) 
			chocarContraBonusReparacion((BonusReparacion)elem);
		
		if (elem instanceof Bomba) 
			chocarContraBomba((Bomba)elem);
		if (elem instanceof Misil)
			chocarContraMisil((Misil)elem);
		
		if (elem instanceof ObstaculoExplosivo)
			chocarContraObstaculoExplosivo((ObstaculoExplosivo)elem);
		if (elem instanceof Nave)
			chocarContraNave((Nave)elem);	
		//Ver chocar Contra pared
	}
	@Override
	public void chocarContraBonusReparacion(BonusReparacion bonus) {
		
		int total= this.getCombustible()+ 20;
		this.setCombustible(total);
	}

	@Override
	public void chocarContraBonusMisil(BonusMisil bonus) {
		int total= this.getMisiles() + bonus.getRecargaMisil();
		this.setMisiles(total);
	}
	
	@Override
	public void chocarContraBonusInmunidad(BonusInmunidad bonus) {

		this.inmune=true;
	}

	@Override
	public void chocarContraMisil(Misil misil) {
		int total= this.getNivelDestruccion()- misil.getNivelDanio();
		this.setNivelDestruccion(total);
	}
	@Override
	public void chocarContraBomba(Bomba bomba) {
		int total= this.getNivelDestruccion()- bomba.getNivelDaño();
		this.setNivelDestruccion(total);
	}
	@Override
	public void chocarContraNave(Nave nave) {
		this.girar();
	}
	@Override
	public void chocarContraObstaculoExplosivo(ObstaculoExplosivo obstaculo) {
		int total= this.getNivelDestruccion()- obstaculo.getNivelDanio();
		this.setNivelDestruccion(total);
	}
}
