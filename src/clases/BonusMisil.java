package clases;


public class BonusMisil extends Bonus {
	private int RecargaMisil;
	
	@Override
	public void darBeneficio() {
		// TODO Auto-generated method stub
		
	}
	

	public int getRecargaMisil() {
		return RecargaMisil;
	}


	public void setRecargaMisil(int recargaMisil) {
		RecargaMisil = recargaMisil;
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
}
