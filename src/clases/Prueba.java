package clases;

public class Prueba {

	public static void main(String[] args) {

		Nave nave = new NaveCrazy();
		Posicion pos = new Posicion();
		pos.setX(123);
		pos.setY(12);
		nave.setPosicion(pos);
		Escenario juego = new Escenario();
		juego.iniciar();
		System.out.println("feghng");
		System.out.println(nave.getPosicion().getX());
		nave.avanzar();
		nave.avanzar();
		nave.avanzar();
		nave.avanzar();
		nave.avanzar();
		nave.avanzar();
		
		System.out.println(nave.getPosicion().getX());
	}

}
