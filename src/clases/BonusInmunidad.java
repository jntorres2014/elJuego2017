package clases;

public class BonusInmunidad extends Bonus {
	private int recargaDeInmunidad=40;;

	public int getRecargaDeInmunidad() {
		return recargaDeInmunidad;
	}

	public void setRecargaDeInmunidad(int recargaDeInmunidad) {
		this.recargaDeInmunidad = recargaDeInmunidad;
	}

	@Override
	public void darBeneficio() {
		
	}

	@Override
	public void jugar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chocarContra(Elemento elemento) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
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
		System.out.println("nada");
	}
}
