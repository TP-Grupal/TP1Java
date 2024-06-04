package juego;
import java.awt.Color;
import entorno.Entorno;
import entorno.Herramientas;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Rayo {
	private Image img;
	private int x;
	private int y;
	private int ancho;
	private int alto;
	private int velocidad;
	private double angulo;
	private double escala;
	
	public Rayo(Image img, int x, int y, double angulo, double escala, int velocidad) {
		this.img =  img;
		this.x = x;
		this.y = y;
		this.angulo = angulo;
		this.escala = escala;
		this.velocidad= velocidad;
		this.ancho = 20;
		this.alto = 20;
	}
	public void dibujarImg(Entorno entorno) {
		entorno.dibujarImagen(this.img,this.x,this.y,this.angulo,this.escala);
	}
	public void mover()
	{
		this.x = this.x + this.velocidad;
	}
	public void moverDerecha() {
		this.x += this.velocidad;
	}
	
	public void moverIzquierda() {
		this.x -= this.velocidad;
	}
	
	public Image getImg() {
		return img;
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
	public double getEscala() {
		return escala;
	}
	public double getEscala() {
		return escala;
	}
}
