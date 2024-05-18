package juego;

import entorno.Entorno;
import entorno.Herramientas;
import java.awt.Image;

public class Elizabeth {
	private Image img;
	private int x;
	private int y;
	private double angulo;
	private double diametro;
	private Image rayoEli;
	private int velocidad;
	int ultDirec;

	public Elizabeth(Image img ,int x, int y, double angulo, double diametro, int velocidad,int ultDirec) {
		this.img = Herramientas.cargarImagen("Imagenes\\elizabeth.png");
		this.x = x;
		this.y = y;
		this.angulo = angulo;
		this.diametro = diametro;
		this.velocidad = velocidad;
		this.ultDirec = ultDirec;
	}
	public void dibujarImg(Entorno entorno)
	{
		entorno.dibujarImagen(this.img,this.x, this.y, this.angulo, this.diametro);
	}
	
	public void moverDerecha()
	{
		this.x = this.x + 3;
	}
	
	public void moverIzquierda()
	{
		this.x = this.x - 3;
	}
	public Rayo disparar() {
		this.rayoEli = Herramientas.cargarImagen("Imagenes\\rayo.png");
		return new Rayo(rayoEli, this.x, this.y, 0, 0.1, 10);
	}
	public void mover()
	{
		this.y = this.y + this.velocidad;
	}
	public void up() {
		this.velocidad = this.velocidad * (-1);
	}
	
	public int getX() {
		return x;
	}


	public int getY() {
		return y;
	}

	/**
     * @return double return the angulo
     */
    public double getAngulo() {
        return angulo;
    }

    /**
     * @param angulo the angulo to set
     */
    public void setAngulo(double angulo) {
        this.angulo = angulo;
    }

    /**
     * @return double return the diametro
     */
    public double getDiametro() {
        return diametro;
    }

    /**
     * @param diametro the diametro to set
     */
    public void setDiametro(double diametro) {
        this.diametro = diametro;
    }
	public int getUltDirec() {
		return ultDirec;
	}
}
