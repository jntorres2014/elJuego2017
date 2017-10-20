package Rescate;

public class Config {
		
		private int altoTablero =500;
		private int anchoTablero= 500;
		
		private int anchoRobot = 40;
		private int altoRobot = 40;
		
		private int	anchoMunicion = 10;
		private int altoMunicion = 10;
		private int	anchoBomba = 15;
		private int altoBomba = 15;
		private int anchoBonusEnergia= 20 ;
		private int altoBonusEnergia = 20;
		private int altoBonusEscudo =20;
		private int anchoBonusEscudo = 20;
		
		private final int duracionJuego = 1000000;
		private int radarAlcanceMaximo;
		private int tiempoEsperaJuego ;
		
		
		
		/**
		 * Devuelve tiempo de duracion del juego
		 * 
		 * @return Tiempo
		 */
		public int getDuracionJuego() {
			return this.duracionJuego;
		}

		/**
		 * Alto del tablero donde se desarrolla el juego en pixels
		 * 
		 * @return Cantidad de pixels
		 */
		public int getAltoTablero() {
			return this.altoTablero;
		}

		
		/**
		 * Ancho del tablero donde se desarrolla el juego en pixels
		 * 
		 * @return Cantidad de pixels
		 */
		
		public int getAnchoTablero() {
			return this.anchoTablero;
		}

		/**
		 * Devuelve el alcance máximo de un radar.
		 * 
		 * 
		 * @return Distancia en pixels
		 */

		public int getRadarAlcanceMaximo() {
			return this.radarAlcanceMaximo;
		}

		/**
		 * Devuelve el tiempo de espera entre turnos
		 * 
		 * @return Segundos
		 */

		public int getTiempoEsperaJuego() {
			return this.tiempoEsperaJuego;
		}

		/**
		 * Devuelve el alto de una municion
		 * 
		 * @return Cantidad de pixels
		 */

		public int getAltoMunicion() {
			return this.altoMunicion;
		}

		/**
		 * Devuelve el ancho de una municion
		 * 
		 * @return Cantidad de pixels
		 */

		public int getAnchoMunicion() {
			return this.anchoMunicion;
		}

		/**
		 * Devuelve el alto de un Robot
		 * 
		 * @return Cantidad de pixels
		 */

		public int getAltoRobot() {
			return this.altoRobot;
		}

		/**
		 * Devuelve el ancho de un Robot
		 * 
		 * @return Cantidad de pixels
		 */
		public int getAnchoRobot() {
			return this.anchoRobot;
		}

		/**
		 * Devuelve el alto de un Bonus Energia
		 * 
		 * @return Cantidad de pixels
		 */

		public int getAltoBonusEnergia() {
			return this.altoBonusEnergia;
		}

		/**
		 * Devuelve el ancho de un Bonus de Energia
		 * 
		 * @return Cantidad de pixels
		 */

		public int getAnchoBonusEnergia() {
			return this.anchoBonusEnergia;
		}

		/**
		 * Devuelve el alto de un Bonus de Escudo
		 * 
		 * @return Cantidad de pixels
		 */
		
		public int getAltoBonusEscudo() {
			return this.altoBonusEscudo;
		}

		/**
		 * Devuelve el ancho de un Bonus de Escudo
		 * 
		 * @return Cantidad de pixels
		 */
		
		public int getAnchoBonusEscudo() {
			return this.anchoBonusEscudo;
		}
		/**
		 * Devuelve el alto de la bomba
		 * @return cantidad de pixeles
		 */
		
		public int getAltoBomba() {
			return altoBomba;
		}
		
		/**
		 * devulve el alto de la bomba
		 * @return cantidad de pixeles
		 */
		public int getAnchoBomba() {
			return anchoBomba;
		}

	}

