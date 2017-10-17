package clases;

public abstract class Movible extends Elemento {
	public Movible(Tamanio tamanio, Posicion posicion) {
		super(tamanio, posicion);
		// TODO Auto-generated constructor stub
	}

	private double velocidad;
	private int direccion;

	
	public double getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}
	public int getDireccion() {
		return direccion;
	}
	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}
	public void avanzar() {
		this.setDireccion(this.getDireccion()+ 1);
		
		this.getPosicion().setX(this.getPosicion().getX()+1);
		this.getPosicion().setY(this.getPosicion().getY() + 1);
		this.setDireccion(getDireccion());
		System.out.println(getVelocidad());
		System.out.println(getDireccion());
		
	}	
	public  void girar() {
		this.setDireccion(this.getDireccion()*90);
		
	}
	
	@Override
	public void chocarPared() {
	}
		


}
