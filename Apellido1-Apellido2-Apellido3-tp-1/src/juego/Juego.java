package juego;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;

import entorno.Entorno;
import entorno.InterfaceJuego;
import java.awt.Image;

public class Juego extends InterfaceJuego {
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;	

	// Variables y métodos propios de cada grupo
	private Elizabeth elizabeth;
	private Image reina;
	private Rayo[] rayos;
	private int direccion;
	boolean hayRayo;
	public char TECLA_X = 88;
	private BloquesLadrillos[] ladrillos;
	private BloquesAcero[] acero;
	private Image pared;

	Juego() {
		Random rand = new Random();
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, " Super Elizabeth Sis, Volcano Edition - Grupo ... - v1", 1000, 600);

		// Inicializar lo que haga falta para el juego
		this.elizabeth = new Elizabeth(this.reina ,500, 500, 0, 0.4,0, direccion);
		this.rayos= new Rayo[1];
		this.ladrillos = new BloquesLadrillos[25];
		for(int i = 0; i < this.ladrillos.length; i++) {
			if(i == 0)
				this.ladrillos[i] = new BloquesLadrillos(this.pared,50,570,0,0.3);
			else if(i == 1)
				this.ladrillos[i] = new BloquesLadrillos(this.pared,145,570,0,0.3);
			else if(i == 2)
				this.ladrillos[i] = new BloquesLadrillos(this.pared,240,570,0,0.3);
			else if(i == 3)
				this.ladrillos[i] = new BloquesLadrillos(this.pared,335,570,0,0.3);
			else if(i == 4)
				this.ladrillos[i] = new BloquesLadrillos(this.pared,385,570,0,0.3);
			else if(i == 5)
				this.ladrillos[i] = new BloquesLadrillos(this.pared,475,570,0,0.3);
			else if(i == 6)
				this.ladrillos[i] = new BloquesLadrillos(this.pared,569,570,0,0.3);
			else if(i == 7)
				this.ladrillos[i] = new BloquesLadrillos(this.pared,665,570,0,0.3);
			else if(i == 8)
				this.ladrillos[i] = new BloquesLadrillos(this.pared,760,570,0,0.3);
			else if(i == 9)
				this.ladrillos[i] = new BloquesLadrillos(this.pared,855,570,0,0.3);
			else if(i == 10)
				this.ladrillos[i] = new BloquesLadrillos(this.pared,50,380,0,0.3);
			else if(i == 11)
				this.ladrillos[i] = new BloquesLadrillos(this.pared,145,380,0,0.3);
			else if(i == 12)
				this.ladrillos[i] = new BloquesLadrillos(this.pared,240,380,0,0.3);
			else if(i == 13)
				this.ladrillos[i] = new BloquesLadrillos(this.pared,530,380,0,0.3);
			else if(i == 14)
				this.ladrillos[i] = new BloquesLadrillos(this.pared,855,380,0,0.3);
			else if(i == 15)
				this.ladrillos[i] = new BloquesLadrillos(this.pared,950,380,0,0.3);
			else if(i == 16)
				this.ladrillos[i] = new BloquesLadrillos(this.pared,820,380,0,0.3);
			else if(i == 17)
				this.ladrillos[i] = new BloquesLadrillos(this.pared,50,200,0,0.3);
			else if(i == 18)
				this.ladrillos[i] = new BloquesLadrillos(this.pared,342,200,0,0.3);
			else if(i == 19)
				this.ladrillos[i] = new BloquesLadrillos(this.pared,440,200,0,0.3);
			else if(i == 20)
				this.ladrillos[i] = new BloquesLadrillos(this.pared,540,200,0,0.3);
			else if(i == 21)
				this.ladrillos[i] = new BloquesLadrillos(this.pared,635,200,0,0.3);
			else if(i == 22)
				this.ladrillos[i] = new BloquesLadrillos(this.pared,950,200,0,0.3);
			else if(i == 23)
				this.ladrillos[i] = new BloquesLadrillos(this.pared,930,200,0,0.3);
			else
				this.ladrillos[i] = new BloquesLadrillos(this.pared,950,570,0,0.3);
		}
		this.acero = new BloquesAcero[5];
		for (int j = 0; j < this.acero.length; j++) {
			if(j == 0)
				this.acero[j] = new BloquesAcero(this.pared,385,380,0,0.24);
			else if(j == 1)
				this.acero[j] = new BloquesAcero(this.pared,675,380,0,0.24);
			else if(j == 2)
				this.acero[j] = new BloquesAcero(this.pared,195,200,0,0.24);
			else
				this.acero[j] = new BloquesAcero(this.pared,780,200,0,0.24);
		}
		// Inicia el juego!
		this.entorno.iniciar();
	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y por lo
	 * tanto es el método más importante de esta clase. Aquí se debe actualizar el
	 * estado interno del juego para simular el paso del tiempo (ver el enunciado
	 * del TP para mayor detalle).
	 */
	public void tick() {
		// Procesamiento de un instante de tiempo
		this.elizabeth.dibujarImg(this.entorno);
		
		for(int i = 0; i < this.ladrillos.length; i++) {
			this.ladrillos[i].dibujarImg(this.entorno);
		}
		for(int i = 0; i < this.acero.length; i++) {
			this.acero[i].dibujarImg(this.entorno);
		}
		
		if(this.entorno.estaPresionada(this.entorno.TECLA_DERECHA) && 
				this.elizabeth.getX() + this.elizabeth.getDiametro() /2 < this.entorno.ancho())
			this.elizabeth.moverDerecha();
		if(this.entorno.estaPresionada(this.entorno.TECLA_IZQUIERDA) && 
				this.elizabeth.getX() + this.elizabeth.getDiametro() /2 > 45)
			this.elizabeth.moverIzquierda();
		
		//guarda la última dirección de Elizabeth para saber hacia dónde disparar el rayo
		if(entorno.sePresiono(entorno.TECLA_DERECHA) || entorno.estaPresionada(entorno.TECLA_DERECHA)) {
			if(this.hayRayo == false) {
				this.elizabeth.ultDirec = 1;
			}
		}
		else if(entorno.sePresiono(entorno.TECLA_IZQUIERDA) || entorno.estaPresionada(entorno.TECLA_IZQUIERDA)) {
			if(this.hayRayo == false) {
				this.elizabeth.ultDirec = 2;
			}
		}
		
		//--------
		
		
		//creo el rayo
		
		if(entorno.sePresiono(entorno.TECLA_ESPACIO) && (entorno.sePresiono(entorno.TECLA_DERECHA) 
				|| this.hayRayo== false)) {
			this.hayRayo= true;
			for(int i =0; i < rayos.length; i++) {
				if(rayos[i] == null) {
					this.rayos[i]= this.elizabeth.disparar();
				}
			}
		}
		if(entorno.sePresiono(entorno.TECLA_ESPACIO) && (entorno.sePresiono(entorno.TECLA_IZQUIERDA) 
				|| this.hayRayo== false )) {
			this.hayRayo= true;
			for(int i =0; i < rayos.length; i++) {
				if(rayos[i] == null) {
					this.rayos[i]= this.elizabeth.disparar();
				}
			}
		}
		
		/*
		 * dibuja el rayo segun la direccion en la que se esta moviendo Elizabeth
		  */
		
		for(int i = 0; i < rayos.length; i++) {
			if(rayos[i] != null && elizabeth.getUltDirec() == 1 ) {
				rayos[i].dibujarImg(entorno);
				rayos[i].moverDerecha();
				if(!hayRayo(rayos[i])) {
					rayos[i] = null;
					this.hayRayo= false;
				}
			}
		}
		for(int i = 0; i < rayos.length; i++) {
			if(rayos[i] != null && elizabeth.getUltDirec() == 2) {
				rayos[i].dibujarImg(entorno);
				rayos[i].moverIzquierda();
				if(!hayRayo(rayos[i])) {
					rayos[i] = null;
					this.hayRayo= false;
				}
			}
		}
	}
	
	//---fin del tick()---
		 
	private boolean hayRayo(Rayo rayo) {
		if(rayo.getX() + rayo.getEscala() /2 <= 0 || rayo.getX() - rayo.getEscala() /2 >= entorno.ancho())
			return false;
		else 
			return true;
	}
	

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}
}
