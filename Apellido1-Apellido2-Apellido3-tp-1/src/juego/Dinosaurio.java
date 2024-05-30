package juego;

import entorno.Entorno;
import entorno.Herramientas;

import java.awt.Image;

public class Dinosaurio {
	private Image img;
	private int x;
	private int y;
	private double ancho;
	private double alto;
	private int velocidad;
	private int gravedad;
	
	//imagen disparo
	
	//movimiento dinosaurio
	public boolean movimientoDinosaurio;
	
	public Dinosaurio(Image img,int x, int y, double ancho, double alto,int velocidad) {
		this.img = Herramientas.cargarImagen("Imagenes\\dino-2.png");
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
		this.velocidad = velocidad;
		this.gravedad = 6;
		
	}
	
	public void mover()
	{
		this.x = this.x + this.velocidad;
	}
	
	//dibujo dinosaurio
	public void dibujarImg(Entorno entorno)
	{
		entorno.dibujarImagen(this.img,this.x, this.y, this.ancho, this.alto);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public double getAncho() {
		return ancho;
	}
	public double getAlto() {
		return alto;
	}
	
	public void rebotar()
	{
		this.velocidad = this.velocidad * (-1);
	}
	
	public void Gravedadsi()
	{
		this.y = this.y + this.gravedad;
	}

	public boolean vivo() {
		return true;
	}
	
	public int moverDerecha() {
	     return this.x = this.x + this.velocidad; // se mueve a la derecha
		
	}
	
	public int moverIzquierda() {
		return this.x = this.x - this.velocidad; // se mueve a la izquierda
	}
	
	//bola del dinosaurio

	public Rayo dispararDinosaurio() {
	    Image bolaDinosaurio = Herramientas.cargarImagen("Imagenes\\bola.png");
	    
	    int rayoX; //es la posicion desde donde sale el rayo
	    int direccionRayo; // direccion del rayo
	    if (this.velocidad < 0) {
	        rayoX = (int) (this.x + this.ancho); // es para que salga el rayo desde el lado derecho del dinosaurio
	        direccionRayo = 5; // direccion derecha
	    } else {
	        rayoX = this.x; // es para que salaga el rayo desde el lado izquierdo del dinosaurio
	        direccionRayo = -5; // direccion izquierda
	    }
	    int rayoY = (int) (this.y + (this.alto / 2)); // el rayo sale desde adentro del dinosaurio

	    return new Rayo(bolaDinosaurio, rayoX, rayoY, 0, 0.1, direccionRayo);
	}

	public int getVelocidad() {
		return velocidad;
	}

	public Image getImg() {
		return img;
	}


	
}
