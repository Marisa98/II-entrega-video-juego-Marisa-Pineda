package clases;

import implementacion.JuegoPrincipal;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class Item {
	private int x;
	private int y;
	//private int ancho;
	//private int alto;
	private String indiceImagen;
	private boolean capturado;
	public Item(int x, int y, int ancho, int alto, String indiceImagen) {
		super();
		this.x = x;
		this.y = y;
		//this.ancho = ancho;
		//this.alto = alto;
		this.indiceImagen = indiceImagen;
	}
	
	public void pintar(GraphicsContext graficos) {
		if (!capturado)
			graficos.drawImage(JuegoPrincipal.imagenes.get(indiceImagen), this.x, this.y);
		//graficos.fillRect(this.x, this.y, 0,0 );
	}
	
	public Rectangle obtenerRectangulo() {
		return new Rectangle(this.x, this.y,24, 22);
	}

	public boolean isCapturado() {
		return capturado;
	}

	public void setCapturado(boolean capturado) {
		this.capturado = capturado;
	}
}
