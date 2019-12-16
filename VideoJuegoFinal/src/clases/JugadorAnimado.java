package clases;

import java.util.HashMap;

import javax.swing.JOptionPane;

import implementacion.JuegoPrincipal;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class JugadorAnimado {
	private  static int x;
	private static int y;
	private String indiceImagen;
	private int velocidad;
	private HashMap<String, Animacion> animaciones;
	private static String animacionActual;
	private int puntuacion = 0;
	private static int vida = 5; 
	
	//Coordenadas para pintar el fragmento de la imagen
	private int xImagen;
	private int yImagen;
	private int anchoImagen;
	private int altoImagen;
	
	public JugadorAnimado(int x, int y, String indiceImagen, int velocidad, String animacionActual) {
		super();
		this.x = x;
		this.y = y;
		this.indiceImagen = indiceImagen;
		this.velocidad = velocidad;
		this.animacionActual = animacionActual;
		inicializarAnimaciones();
	}
	
	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public String getIndiceImagen() {
		return indiceImagen;
	}
	public void setIndiceImagen(String indiceImagen) {
		this.indiceImagen = indiceImagen;
	}
	
	//Obtener las coordenas del fragmento de la imagen a pintar
	public void actualizarAnimacion(double t) {
		Rectangle coordenadasActuales = this.animaciones.get(animacionActual).calcularFrame(t);
		this.xImagen = (int)coordenadasActuales.getX();
		this.yImagen = (int)coordenadasActuales.getY();
		this.anchoImagen = (int)coordenadasActuales.getWidth();
		this.altoImagen = (int)coordenadasActuales.getHeight();
	}
	//Movimiento de jugador  
	public void mover(int x,int y ){
		if (this.x>=1100)
			this.x = -100;
		if (JuegoPrincipal.derecha)
			this.x+=velocidad;
		
		if (JuegoPrincipal.izquierda)
			this.x-=velocidad;
		
		if (JuegoPrincipal.arriba)
			this.y-=velocidad;
		
		if (JuegoPrincipal.abajo)
			this.y+=velocidad;
	}
	
	/*if(!estaElimindo()){
		if(!enColision(x,0)) {
			modificarPosicionx(x);
		}
		if(!enColision(0,y)) {
			modificarPosiciony(y);
		}
		}
	}
	
	private boolean enColision(int X, int Y) {
		boolean colision = false;
		int posicionx = x + x;
		int posicioony= y+ y;
		
		
		return false;
	}
	*/
	public void pintar(GraphicsContext graficos) {
		graficos.drawImage(
				JuegoPrincipal.imagenes.get(this.indiceImagen), 
				this.xImagen, this.yImagen, 
				this.anchoImagen, this.altoImagen,
				this.x, this.y,
				this.anchoImagen, this.altoImagen
		);
		//graficos.fillRect(this.x, this.y, this.anchoImagen, this.altoImagen);
		graficos.fillText("PUNTUACION : " + puntuacion, 0, 80);
		graficos.fillText("VIDAS : " + vida, 0, 100);
	}
	
	public Rectangle obtenerRectangulo() {
		return new Rectangle(this.x, this.y, this.anchoImagen, this.altoImagen);
	}
	
	public void inicializarAnimaciones() {
			animaciones = new HashMap<String, Animacion>();
			Rectangle coordenadasCaminar[]= {
					new Rectangle(89,255,29,77),
				    new Rectangle(129,256,35,76),
				    new Rectangle(174,255,28,77),
			};
			Animacion animacionCaminar = new Animacion("caminar",coordenadasCaminar,0.5);
			animaciones.put("caminar",animacionCaminar);

	
	Rectangle coordenadasArriba[]= {
			new Rectangle(1, 86, 41, 82),
			new Rectangle(40, 85, 43, 82),
			new Rectangle(84, 87, 40, 81),
			new Rectangle(125, 88, 41, 80),
			new Rectangle(168, 86, 41, 82),
			
	};
	
	Animacion animacionArriba = new Animacion("arriba",coordenadasArriba,0.1);
	animaciones.put("arriba",animacionArriba);
}
			

       //Rectangle coordenadasDescanso[] = {
	//				new Rectangle(6, 253,28,79),
		//			new Rectangle(48,254,27,79),
					
			//};
			//Animacion animacionDescanso = new Animacion("descanso",coordenadasDescanso,0.2);
			//animaciones.put("descanso",animacionDescanso);			
	
	
	public void verificarColisiones(Item item) {
		if (this.obtenerRectangulo().intersects(item.obtenerRectangulo().getBoundsInLocal())) {
				System.out.println("Estan colisionando");
				if (!item.isCapturado())
					this.puntuacion++;
				item.setCapturado(true);				
		}
	}
 /*public void verificarColisiones2(Item2 itemm) {
		if(this.obtenerRectangulo().intersects(itemm.obtenerRectangulo().getBoundsInLocal())) {
			System.out.println("Estan colisionando2"); 	
			if(!itemm.isCapturado2())
				this.vida--;
			itemm.setCapturado2(true);
		}	
	}


/*	public void verificarColisiones4(Tile mapa) {
		if(this.obtenerRectangulo().intersects(mapa.obtenerRectangulo().getBoundsInLocal())) {
			if(!mapa.isCapturado())
				JOptionPane.showMessageDialog(null, "Fin del juego");
			
			mapa.setCapturado(true);*/
		
	}
	
