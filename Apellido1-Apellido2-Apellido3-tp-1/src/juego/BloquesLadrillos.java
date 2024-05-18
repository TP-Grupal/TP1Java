package juego;

import java.awt.Color;
import entorno.Entorno;
import entorno.Herramientas;
import java.awt.Image;

public class BloquesLadrillos {
	private Image img;
	private int x;
	private int y;
	private final double angulo;
	private double diametro;
	public BloquesLadrillos(Image img, int x, int y, double angulo, double diametro) {
		this.img = Herramientas.cargarImagen("Imagenes\\ladrillo.png");
		this.x = x;
		this.y = y;
		this.angulo = angulo;
		this.diametro = diametro;
	}
	public void dibujarImg(Entorno entorno) {
		entorno.dibujarImagen(this.img, this.x, this.y, angulo, diametro);
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
	
}
