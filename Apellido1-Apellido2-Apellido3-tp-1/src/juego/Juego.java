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
	private Dinosaurio dinosaurio;
	private Image reina;
	private Image dino;
	private int direccion;
	boolean hayRayo;
	public char TECLA_X = 88;
	private BloquesLadrillos[] ladrillos;
	private BloquesAcero[] acero;
	private Image pared;
	private Menu menu;
	
	//rayos elizabeth y bola dinosaurio
	private Rayo[] rayoElizabeth;
	private Rayo[] rayoDinosaurio;
	
	
	Juego() {
		this.menu = new Menu();
	
		Random rand = new Random();
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, " Super Elizabeth Sis, Volcano Edition - Grupo ... - v1", 1000, 600);
		
		this.ladrillos = new BloquesLadrillos[25];
		
		// Inicializar lo que haga falta para el juego
		this.elizabeth = new Elizabeth(this.reina ,500, 500, 0, 0.4,0, direccion);
		this.dinosaurio = new Dinosaurio(this.dino,500,100,0,0.6,2);
		
		//rayo y bola
		this.rayoElizabeth= new Rayo[1];
		this.rayoDinosaurio= new Rayo[1];
		
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
		if (menu.estaEnMenu()) {
            menu.dibujarFondo(entorno); // Dibuja el fondo antes de los elementos del menú
            menu.dibujarTitulo(entorno); // Dibuja el titulo del juego 
            menu.dibujarElementosMenu(entorno); // Agrega las opciones del juego

            // Escucha las teclas para cambiar al estado de juego principal
            if (this.entorno.estaPresionada(this.entorno.TECLA_ENTER)) {
                menu.cambiarEstado();
            }
        } else {
			// Procesamiento de un instante de tiempo
        	
        	//dibujo personajes
			this.elizabeth.dibujarImg(this.entorno);
			this.dinosaurio.dibujarImg(entorno);
			
			//dibujo ladrilolos
			
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
					this.elizabeth.setUltDirec(1);
				}
			}
			else if(entorno.sePresiono(entorno.TECLA_IZQUIERDA) || entorno.estaPresionada(entorno.TECLA_IZQUIERDA)) {
				if(this.hayRayo == false) {
					this.elizabeth.setUltDirec(2);
				}
			}
			
			//--------
			if(this.entorno.sePresiono(this.entorno.TECLA_IZQUIERDA) || 
					this.entorno.estaPresionada(this.entorno.TECLA_IZQUIERDA)){
				if(up() == true && saltar() == true)
					this.elizabeth.moverY();
			}
			
			//creo el rayo para la princesa
			
			if(entorno.sePresiono(entorno.TECLA_ESPACIO) && (entorno.sePresiono(entorno.TECLA_DERECHA) 
					|| this.hayRayo== false)) {
				this.hayRayo= true;
				for(int i =0; i < rayoElizabeth.length; i++) {
					if(rayoElizabeth[i] == null) {
						this.rayoElizabeth[i]= this.elizabeth.disparar();
					}
				}
			}
			if(entorno.sePresiono(entorno.TECLA_ESPACIO) && (entorno.sePresiono(entorno.TECLA_IZQUIERDA) 
					|| this.hayRayo== false )) {
				this.hayRayo= true;
				for(int i =0; i < rayoElizabeth.length; i++) {
					if(rayoElizabeth[i] == null) {
						this.rayoElizabeth[i]= this.elizabeth.disparar();
					}
				}
			}
			
			/*
			 * dibuja el rayo segun la direccion en la que se esta moviendo Elizabeth
			  */
			
			for(int i = 0; i < rayoElizabeth.length; i++) {
				if(rayoElizabeth[i] != null && elizabeth.getUltDirec() == 1 ) {
					rayoElizabeth[i].dibujarImg(entorno);
					rayoElizabeth[i].moverDerecha();
					if(!hayRayo(rayoElizabeth[i])) {
						rayoElizabeth[i] = null;
						this.hayRayo= false;
					}
				}
			}
			for(int i = 0; i < rayoElizabeth.length; i++) {
				if(rayoElizabeth[i] != null && elizabeth.getUltDirec() == 2) {
					rayoElizabeth[i].dibujarImg(entorno);
					rayoElizabeth[i].moverIzquierda();
					if(!hayRayo(rayoElizabeth[i])) {
						rayoElizabeth[i] = null;
						this.hayRayo= false;
					}
				}
			}
			
			// ** parte del dinosaurio **
			
			this.dinosaurio.mover();
			boolean swich = true;
			if (this.dinosaurio.getX() <= 0 +  dinosaurio.getAncho()/2 || this.dinosaurio.getX() >= 1000 - dinosaurio.getAncho() ) {
				this.dinosaurio.rebotar();		
			}
			if(this.dinosaurio.vivo() == true) {			
				for(int i = 0; i < this.ladrillos.length; i++) {				
					if(this.dinosaurio.getY() >= this.ladrillos[i].getY() - 50&& this.dinosaurio.getY() <= this.ladrillos[i].getY() + 50
					&& this.dinosaurio.getX() >= this.ladrillos[i].getX() - 80&& this.dinosaurio.getX() <= this.ladrillos[i].getX() + 80) {
						
						swich = false;				
				    }
				}
				if(swich == true) {
					this.dinosaurio.Gravedadsi();
				}
			  }	
	
			// creo bola dinosaurio
			if (dinosaurio.getVelocidad() > 0) { // Si la velocidad es mayor que 0, el dinosaurio se está moviendo hacia la derecha
			    this.hayRayo = true;
			    for (int i = 0; i < rayoDinosaurio.length; i++) {
			        if (rayoDinosaurio[i] == null) {
			            this.rayoDinosaurio[i] = this.dinosaurio.dispararDinosaurio();
			        }
			    }
			} else if (dinosaurio.getVelocidad() < 0) { // Si la velocidad es menor que 0, el dinosaurio se está moviendo hacia la izquierda
			    this.hayRayo = true;
			    for (int i = 0; i < rayoDinosaurio.length; i++) {
			        if (rayoDinosaurio[i] == null) {
			            this.rayoDinosaurio[i] = this.dinosaurio.dispararDinosaurio();
			        }
			    }
			}
			
			// dibuja la bola del dinosaurio segun su direccion dinosaurio
			
			for(int i = 0; i < rayoDinosaurio.length; i++) {
			    if(rayoDinosaurio[i] != null && dinosaurio.moverDerecha() > 0 ) {
			        rayoDinosaurio[i].dibujarImg(entorno);
			        rayoDinosaurio[i].moverIzquierda();
			        if(!hayRayo(rayoDinosaurio[i])) {
			            rayoDinosaurio[i] = null;
			            this.hayRayo= false;
			        }
			    }
			}
			for(int i = 0; i < rayoDinosaurio.length; i++) {
			    if(rayoDinosaurio[i] != null && dinosaurio.moverIzquierda() < 0) {
			        rayoDinosaurio[i].dibujarImg(entorno);
			        rayoDinosaurio[i].moverDerecha(); // Aquí se ajusta el movimiento del rayo
			        if(!hayRayo(rayoDinosaurio[i])) {
			            rayoDinosaurio[i] = null;
			            this.hayRayo= false;
			        }
			    }
			}
			
			// salto princesa
					if (this.entorno.sePresiono(TECLA_X) && this.saltar()) {
						this.elizabeth.saltar();
					}
					if (!this.saltar()) {
						this.elizabeth.aplicoGravedad();
					}
			
			for (int i = 0; i < this.ladrillos.length; i++) {
			        // Verificar colisión abajo
			        if (ColisionPrincesaAbajo(this.ladrillos[i])) {
			        		
			            this.elizabeth.rebotar();// si toca la parte de abajo, tengo que detener el salton y hacer un tipo rebote hacia abajo
			        }
			        
			        // Verificar colisión arriba
			        if (ColisionPrincesaArriba(this.ladrillos[i])) {
			            this.elizabeth.detenerSalto(); // si toca la parte de arriba solo detengo el salto y listo, despues camina normalmente 
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
	
	private boolean up() {
		if(this.entorno.sePresiono(this.TECLA_X)){
			return true;
		}
		return false;
	}
	
	private boolean saltar() {
		boolean posX = false, posY = false;
		
		for(int i = 0; i < this.ladrillos.length; i++) {
			if(this.ladrillos[i].getX() + this.ladrillos[i].getDiametro() > this.elizabeth.getX())
				posX = true;
			if(this.ladrillos[i].getY() + this.ladrillos[i].getDiametro() < this.elizabeth.getY() + this.elizabeth.getDiametro())
				posY = true;
		}					
		return posX && posY;
	}
	
	private boolean ColisionPrincesaAbajo(BloquesLadrillos ladrillo) {
		boolean col= false;
		int posInfElizabeth = this.elizabeth.getY() + this.elizabeth.getAlto()/2;
		int posDerElizabeth = this.elizabeth.getX() + this.elizabeth.getAncho() /2;
		int posIzqElizabeth = this.elizabeth.getX() - this.elizabeth.getAncho()/2;
		int posSupElizabeth = this.elizabeth.getY() - this.elizabeth.getAlto() /2;
		
		int posSupladrillo = ladrillo.getY() - ladrillo.getAlto()/2 +1;
		int posDerladrillo = ladrillo.getX() + ladrillo.getAncho() /2 +1;
		int posIzqladrillo = ladrillo.getX() - ladrillo.getAncho()/2 +1;
		int posInfladrillo = ladrillo.getY() + ladrillo.getAlto() /2 +1;
		
		if(posDerElizabeth < posIzqladrillo && posIzqElizabeth < posIzqladrillo ||
				posDerElizabeth > posDerladrillo && posIzqElizabeth > posDerladrillo)
			col = false;
		else if(posSupElizabeth == posInfladrillo)
			col = true;
		return col;
	}
	
	private boolean ColisionPrincesaArriba(BloquesLadrillos ladrillo) {
		boolean col= false;
		int posInfElizabeth = this.elizabeth.getY() + this.elizabeth.getAlto()/2;
		int posDerElizabeth = this.elizabeth.getX() + this.elizabeth.getAncho() /2;
		int posIzqElizabeth = this.elizabeth.getX() - this.elizabeth.getAncho()/2;
		int posSupElizabeth = this.elizabeth.getY() - this.elizabeth.getAlto() /2;
		
		int posSupladrillo = ladrillo.getY() - ladrillo.getAlto()/2 +1;
		int posDerladrillo = ladrillo.getX() + ladrillo.getAncho() /2 +1;
		int posIzqladrillo = ladrillo.getX() - ladrillo.getAncho()/2 +1;
		int posInfladrillo = ladrillo.getY() + ladrillo.getAlto() /2 +1;
		
		if(posDerElizabeth < posIzqladrillo && posIzqElizabeth < posIzqladrillo ||
				posDerElizabeth > posDerladrillo && posIzqElizabeth > posDerladrillo)
			col = false;
		else if(posInfElizabeth == posSupladrillo)
			col = true;
		return col;
		
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}
}
