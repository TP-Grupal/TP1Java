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
		private int ultDirec;
		private int gravedad;
		
		
		private int alto;
		private int ancho;
		
		//salto princesa
		private double velocidadY;
		
		public Elizabeth(Image img ,int x, int y, double angulo, double diametro, int velocidad,int ultDirec) {
			this.img = Herramientas.cargarImagen("Imagenes\\elizabeth.png");
			this.x = x;
			this.y = y;
			this.angulo = angulo;
			this.diametro = diametro;
			this.velocidad = velocidad;
			this.ultDirec = ultDirec;
			this.gravedad = 6;
			
			this.alto = alto;
			this.ancho = ancho;
			
			//salto princesa
			this.velocidadY = 0; // velocidad salto
		}
		public void dibujarImg(Entorno entorno)
		{
			this.y = (int) (this.y + velocidadY);
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
		public void moverY()
		{
			this.y = this.y + 190;
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
	    public void setUltDirec(int ultDirec) {
		this.ultDirec = ultDirec;
	    }
	    
	    //salto princesa
	    public void saltar() {
	    	this.velocidadY = -5; //velocidad con la que se produce el salto
	    }
	    
	    public void aplicoGravedad() {
	    	double gravedad = 0.8;
	    	double velocidadCaida = 5; //velocidad con la que cae la princesa
	    	
	    	this.velocidadY = this.velocidadY + gravedad;
	    	System.out.println("vel y: "+velocidadY);
	    	if (this.velocidadY > velocidadCaida) {
	    		this.velocidadY = velocidadCaida;
	    	}
	    	this.y = (int) (this.y + this.velocidadY);
	    }
	    
	    // para dejar de saltar
	    public void detenerSalto() {
	        this.velocidadY = 0; // pongo velocidadY =0 para que no salte
	    }
	    
	    // para rebotar
	    public void rebotar() {
	        this.velocidadY = -10; // velocidad negativa para hacer que rebote
	    }
		public int getAlto() {
			return alto;
		}
		public int getAncho() {
			return ancho;
		}
		public void gravedadPrincesa() {
		    this.y = this.y + gravedad;
		}
		 public int saltar2() { 
		    	return this.y = this.y - 5;
		}
	    
}
