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
	boolean hayRayo = false;
	boolean hayRayoDino;
	public char TECLA_X = 88;
	private BloquesLadrillos[] ladrillos;
	private BloquesAcero[] acero;
	private Image pared;
	private Menu menu;
	public char TECLA_ESCAPE = 27;
	//salto princesa
	private int pasoSalto;
	
	//rayos elizabeth y bola dinosaurio
	private Rayo[] rayoElizabeth;
	private Rayo[] rayoDinosaurio;
	boolean hayBola;
	
	Juego() {
		this.menu = new Menu(dino);
		Random rand = new Random();
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, " Super Elizabeth Sis, Volcano Edition - Grupo ... - v1", 1000, 600);
		
		this.ladrillos = new BloquesLadrillos[71];
		
		// Inicializar lo que haga falta para el juego
		this.elizabeth = new Elizabeth(this.reina ,500, 500, 0, 0.3,0, direccion);
		this.dinosaurio = new Dinosaurio(this.dino,500,100,0,0.4,2);
		
		//rayo y bola
		this.rayoElizabeth= new Rayo[1];
		this.rayoDinosaurio= new Rayo[1];
		int contadorP1 = 0;
		int contadorP2 = 0;
		for(int i = 0;i<this.ladrillos.length; i++) {
            if(i<=24) {
            	this.ladrillos[i] = new BloquesLadrillos(this.pared,45*i,380,0,0.3);
            }
            if(i>=25 && i<=47) {
            	this.ladrillos[i] = new BloquesLadrillos(this.pared,45*contadorP1,570,0,0.3);
            	contadorP1 ++;
            }
            if(i>=48) {
            	this.ladrillos[i] = new BloquesLadrillos(this.pared,45*contadorP2,200,0,0.3);
            	contadorP2 ++;
            }
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
	            	 this.elizabeth = new Elizabeth(this.reina ,500, 500, 0, 0.3,0, direccion);
	 	    		this.dinosaurio = new Dinosaurio(this.dino,500,100,0,0.4,2);
	 	    		
	 	    		int contadorP1 = 0;
	 	    		int contadorP2 = 0;
	 	    		for(int i = 0;i<this.ladrillos.length; i++) {
	 	                if(i<=24) {
	 	                	this.ladrillos[i] = new BloquesLadrillos(this.pared,45*i,380,0,0.3);
	 	                }
	 	                if(i>=25 && i<=47) {
	 	                	this.ladrillos[i] = new BloquesLadrillos(this.pared,45*contadorP1,570,0,0.3);
	 	                	contadorP1 ++;
	 	                }
	 	                if(i>=48) {
	 	                	this.ladrillos[i] = new BloquesLadrillos(this.pared,45*contadorP2,200,0,0.3);
	 	                	contadorP2 ++;
	 	                }
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

	                menu.cambiarEstado();
	            }
	            // Verifica si se presiona la tecla "Escape" para cerrar el programa
	            if (this.entorno.estaPresionada(this.TECLA_ESCAPE)) {
	                System.exit(0); // Cierra el programa
	            }
	        } else
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
				if(this.ladrillos[i]!= null) {
					this.ladrillos[i].dibujarImg(this.entorno);
				}
				
			}
			for(int i = 0; i < this.acero.length; i++) {
				this.acero[i].dibujarImg(this.entorno);
			}
			// Se fija que la proncesa no golpee el costado de un bloque
			boolean golpe = false;
			for(int i = 0; i < this.ladrillos.length; i++) {				
				if(this.ladrillos[i] != null &&
				   this.elizabeth.getY() >= this.ladrillos[i].getY() - this.ladrillos[i].getAlto() / 2 &&
				   this.elizabeth.getY() <= this.ladrillos[i].getY() + this.ladrillos[i].getAlto() / 2&&
				   this.elizabeth.getX() >= this.ladrillos[i].getX() - this.ladrillos[i].getAncho() &&
				   this.elizabeth.getX() <= this.ladrillos[i].getX() + this.ladrillos[i].getAncho()) {	
					golpe = true;
			    }
			}
			for(int i = 0; i < this.acero.length; i++) {				
				if(this.acero[i] != null &&
				   this.elizabeth.getY() >= this.acero[i].getY() - this.acero[i].getAlto() / 2 &&
				   this.elizabeth.getY() <= this.acero[i].getY() + this.acero[i].getAlto() / 2&&
				   this.elizabeth.getX() >= this.acero[i].getX() - this.acero[i].getAncho() &&
				   this.elizabeth.getX() <= this.acero[i].getX() + this.acero[i].getAncho()) {	
					golpe = true;
			    }
			}
			
			//Mueve a la princesa 
			if(this.entorno.estaPresionada(this.entorno.TECLA_DERECHA) && 
			   this.elizabeth.getX() + this.elizabeth.getAncho() /2 < this.entorno.ancho() &&
			   golpe != true) {
				this.elizabeth.moverDerecha();
			}
			if(this.entorno.estaPresionada(this.entorno.TECLA_IZQUIERDA) && 
			   this.elizabeth.getX() + this.elizabeth.getAncho() /2 > 45 &&
			   golpe != true) {
				this.elizabeth.moverIzquierda();
		    }
			
			//guarda la última dirección de Elizabeth para saber hacia dónde disparar el rayo	
			if(entorno.sePresiono(entorno.TECLA_DERECHA) || entorno.estaPresionada(entorno.TECLA_DERECHA)) {
				if(this.hayRayo == false) {
					System.out.println("a");
					this.elizabeth.setUltDirec(1);
				}
			}
			else if(entorno.sePresiono(entorno.TECLA_IZQUIERDA) || entorno.estaPresionada(entorno.TECLA_IZQUIERDA)) {
				if(this.hayRayo == false) {
					System.out.println("b");
					this.elizabeth.setUltDirec(2);
				}
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
		
			// dibuja el rayo segun la direccion en la que se esta moviendo Elizabeth
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
			
			//Creo el salto verificando que toque el piso (la gravedad este desactivada)
			boolean swichP = this.pasoSalto == 0;
			boolean saltoActivo = true;
			for(int i = 0; i < this.ladrillos.length; i++) {				
				if(this.ladrillos[i] != null &&
				   this.elizabeth.getY() >= this.ladrillos[i].getY() - this.ladrillos[i].getAlto() &&
				   this.elizabeth.getY() <= this.ladrillos[i].getY() + this.ladrillos[i].getAlto() &&
				   this.elizabeth.getX() >= this.ladrillos[i].getX() - this.ladrillos[i].getAncho() &&
				   this.elizabeth.getX() <= this.ladrillos[i].getX() + this.ladrillos[i].getAncho()) {	
					swichP = false;	
					saltoActivo = false;
			    }
			}
			for(int i = 0; i < this.acero.length; i++) {				
				if(this.acero[i] != null &&
				   this.elizabeth.getY() >= this.acero[i].getY() - this.acero[i].getAlto() &&
				   this.elizabeth.getY() <= this.acero[i].getY() + this.acero[i].getAlto() -20 &&
				   this.elizabeth.getX() >= this.acero[i].getX() - this.acero[i].getAncho() &&
				   this.elizabeth.getX() <= this.acero[i].getX() + this.acero[i].getAncho()) {	
					swichP = false;	
					saltoActivo = false;
			     }
		    }
			if(swichP == true) {
				this.elizabeth.gravedadPrincesa();
			}
			
			//Romper bloques y rebotes (y reduzco el salto si se choca cun un bloque en la parte superior)
			for(int i = 0; i < this.ladrillos.length; i++) {				
				if(this.ladrillos[i] != null &&
				   this.elizabeth.getY()  <= this.ladrillos[i].getY() + this.ladrillos[i].getAlto()&&
			       this.elizabeth.getY()  >= this.ladrillos[i].getY() + this.ladrillos[i].getAlto()- 20 &&
				   this.elizabeth.getX() >= this.ladrillos[i].getX() - this.ladrillos[i].getAncho()&&
				   this.elizabeth.getX() <= this.ladrillos[i].getX() + this.ladrillos[i].getAncho()) {	
					this.ladrillos[i] = null;
					this.pasoSalto = 0;
			    }
		   }
			for(int i = 0; i < this.acero.length; i++) {				
				if(this.acero[i] != null &&
				   this.elizabeth.getY()  <= this.acero[i].getY() + this.acero[i].getAlto()&&
			       this.elizabeth.getY()  >= this.acero[i].getY() + this.acero[i].getAlto()- 20 &&
				   this.elizabeth.getX() >= this.acero[i].getX() - this.acero[i].getAncho()&&
				   this.elizabeth.getX() <= this.acero[i].getX() + this.acero[i].getAncho()) {
					this.pasoSalto = 0;
			    }
		   }
			
			//salto
			if(this.entorno.sePresiono(TECLA_X) &&  saltoActivo == false) {
				saltoActivo = true;
				this.pasoSalto = 40;	
			}
			if(pasoSalto > 0) {
				this.elizabeth.saltar2();
				this.pasoSalto--;	
			}
			// ** DINOSAURIO **
			//Muevo al dinosaurio
			this.dinosaurio.mover();			
			if (this.dinosaurio.getX() <= 0 +  this.dinosaurio.getAncho() || this.dinosaurio.getX() >= 1000 - this.dinosaurio.getAncho() ) {
				this.dinosaurio.rebotar();		
			}
			//Aplico gravedad al dinosaurio
			boolean swich = true;
			if(this.dinosaurio.vivo() == true) {			
				for(int i = 0; i < this.ladrillos.length; i++) {				
					if(this.ladrillos[i] != null &&
					   this.dinosaurio.getY() >= this.ladrillos[i].getY() - this.ladrillos[i].getAlto()&&
					   this.dinosaurio.getY() <= this.ladrillos[i].getY() + this.ladrillos[i].getAlto()&&
					   this.dinosaurio.getX() >= this.ladrillos[i].getX() - this.ladrillos[i].getAncho()&&
					   this.dinosaurio.getX() <= this.ladrillos[i].getX() + this.ladrillos[i].getAncho()) {
						
						  swich = false;				
				    }
				}
				for(int i = 0; i < this.acero.length; i++) {
					if(this.acero[i] != null &&
					   this.dinosaurio.getY() >= this.acero[i].getY() - this.acero[i].getAlto() && 
					   this.dinosaurio.getY() <= this.acero[i].getY() + this.acero[i].getAlto() && 
					   this.dinosaurio.getX() >= this.acero[i].getX() - this.acero[i].getAncho() && 
					   this.dinosaurio.getX() <= this.acero[i].getX() + this.acero[i].getAncho()) {
						
						 swich = false;				
				    }
				}
				if(swich == true) {
					this.dinosaurio.Gravedadsi();
				}
			  }	
	
			// creo bola dinosaurio
			if (dinosaurio.getVelocidad() > 0) { // Si la velocidad es mayor que 0, el dinosaurio se está moviendo hacia la derecha
			    this.hayBola = true;
			    for (int i = 0; i < rayoDinosaurio.length; i++) {
			        if (rayoDinosaurio[i] == null) {
			            this.rayoDinosaurio[i] = this.dinosaurio.dispararDinosaurio();
			        }
			    }
			} else if (dinosaurio.getVelocidad() < 0) { // Si la velocidad es menor que 0, el dinosaurio se está moviendo hacia la izquierda
			    this.hayBola = true;
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
			            this.hayRayoDino= false;
			        }
			    }
			}
			for(int i = 0; i < rayoDinosaurio.length; i++) {
			    if(rayoDinosaurio[i] != null && dinosaurio.moverIzquierda() < 0) {
			        rayoDinosaurio[i].dibujarImg(entorno);
			        rayoDinosaurio[i].moverDerecha(); // Aquí se ajusta el movimiento del rayo
			        if(!hayRayo(rayoDinosaurio[i])) {
			            rayoDinosaurio[i] = null;
			            this.hayRayoDino= false;
			        }
			    }
			}
			//colision muerte princesa 
				for(int i = 0;i<this.rayoDinosaurio.length; i++) {
					if(this.rayoDinosaurio[i] != null) {
						if(this.rayoDinosaurio[i].getX() >= this.elizabeth.getX() - this.elizabeth.getAncho() &&
							this.rayoDinosaurio[i].getX() <= this.elizabeth.getX() + this.elizabeth.getAncho() &&
							this.rayoDinosaurio[i].getY() >= this.elizabeth.getY() - this.elizabeth.getAlto()  &&
							this.rayoDinosaurio[i].getY() <= this.elizabeth.getY() + this.elizabeth.getAlto()-50) {
							menu.cambiarEstado();
						}
					}			
			}
			//colision rayo y bola de fuego
				for(int i = 0;i<this.rayoDinosaurio.length; i++) {
					for (int j = 0; j < this.rayoElizabeth.length; j++) {
						if(this.rayoDinosaurio[i] != null && this.rayoElizabeth[j] != null) {
							if(this.rayoDinosaurio[i].getX() + this.rayoDinosaurio[i].getAncho() >= this.rayoElizabeth[j].getX() - this.rayoElizabeth[j].getAncho() &&
									this.rayoDinosaurio[i].getX() - this.rayoDinosaurio[i].getAncho() <= this.rayoElizabeth[j].getX() + this.rayoElizabeth[j].getAncho() &&
									this.rayoDinosaurio[i].getY() + this.rayoDinosaurio[i].getAlto() >= this.rayoElizabeth[j].getY() - this.rayoElizabeth[j].getAlto() &&
									this.rayoDinosaurio[i].getY() - this.rayoDinosaurio[i].getAlto() <= this.rayoElizabeth[j].getY() + this.rayoElizabeth[j].getAlto()) {
								this.rayoDinosaurio[i] = null;
								this.rayoElizabeth[j] = null;
						}
					}else if(this.rayoElizabeth[j] == null){
						this.hayRayo = false;
					}
				}
			}
			//Colision rayo con dinosaurio !revisar tira error¡
			for (int j = 0; j < this.rayoElizabeth.length; j++) {
					if(this.rayoElizabeth[j] != null && this.dinosaurio != null)
						if (this.rayoElizabeth[j].getX() >= this.dinosaurio.getX() - this.dinosaurio.getAncho() &&
							this.rayoElizabeth[j].getX() <= this.dinosaurio.getX() + this.dinosaurio.getAncho() &&
							this.rayoElizabeth[j].getY() >= this.dinosaurio.getY() - this.dinosaurio.getAlto()  &&
							this.rayoElizabeth[j].getY() <= this.dinosaurio.getY() + this.dinosaurio.getAlto()-50) {
							this.dinosaurio = null;
							this.rayoElizabeth[j] = null;
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
