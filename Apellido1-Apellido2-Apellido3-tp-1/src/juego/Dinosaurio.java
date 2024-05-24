package juego;

import entorno.Entorno;
import entorno.Herramientas;

import java.awt.Color;
import java.awt.Image;

public class Dinosaurio {
	private int x;
	private int y;
	private int ancho;
	private int alto;
	private int velocidad;
	private int gravedad;
	
	public Dinosaurio(int x, int y, int ancho, int alto,int velocidad) {	
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
	
	
	public void dibujar(Entorno entorno)
	{
		entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.GREEN);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getAncho() {
		return ancho;
	}
	public int getAlto() {
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
	
	
	

	
}