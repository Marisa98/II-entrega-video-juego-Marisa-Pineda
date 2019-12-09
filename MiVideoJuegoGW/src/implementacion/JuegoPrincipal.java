package implementacion;

import java.util.ArrayList;
import java.util.HashMap;

import clases.Item;
import clases.JugadorAnimado;
import clases.Tile;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class JuegoPrincipal extends Application{
	private Scene escena;
	private Group root;
	private Canvas canvas;
	private GraphicsContext graficos;
	private int puntuacion = 0;
	private JugadorAnimado jugadorAnimado;
	public static boolean derecha=false;
	public static boolean izquierda=false;
	public static boolean arriba=false;
	public static boolean abajo=false;
	public static HashMap<String, Image> imagenes; //Shift+Ctrl+O
	private Item item1;
	private Item item2;
	private Item item3;
	private Item item4;
	private Item item5;
	private Item item6;
	
	
	private ArrayList<Tile> tiles;
	//15x8
	private int[][] mapa = {
		//Escenario 1	
    {2,0,3,1,0,0,0,7},
	{2,0,3,1,0,0,0,7},
	{2,0,3,1,0,0,0,7},
	{2,0,6,6,0,0,0,7},
	{2,0,6,4,0,0,0,7},
	{2,0,6,6,0,12,0,7},
	{2,0,3,1,0,22,0,7},
	{2,0,3,1,0,0,0,7},
	{2,0,3,1,0,0,0,7},
	{2,0,6,6,0,0,12,7},
	{2,0,6,4,0,0,22,7},
	{2,0,6,6,0,0,22,7},
	{2,0,3,1,22,0,0,7},
	{2,0,3,1,22,0,0,7},
	{2,0,3,1,0,0,0,7},
	
	{2,0,3,1,0,0,0,7},
	{2,0,3,1,0,12,0,7},
	{2,0,3,1,0,12,0,7},
	{2,0,6,6,0,0,0,7},
	{2,0,6,4,0,0,0,7},
	{2,0,6,6,12,0,0,7},
	{2,0,3,1,12,0,0,7},
	{2,0,3,1,0,0,0,7},
	{2,0,3,1,0,0,12,7},
	{2,0,5,6,0,0,22,7},
	{2,0,6,4,0,0,22,7},
	{2,0,5,6,0,0,0,7},
	{2,0,5,6,22,0,0,7},
	{2,0,6,4,22,0,0,7},
	{2,0,5,6,0,0,0,7},
	
	//Escenrio 2
	{2,0,19,0,0,0,0,11},
	{2,0,20,0,0,0,0,11},
	{2,0,20,17,15,13,0,11},
	{2,0,20,18,16,14,0,11},
	{2,0,20,0,0,0,0,11},
	{2,0,20,0,0,0,0,11},
	{2,0,20,0,0,0,0,11},
	{2,0,20,0,0,12,0,11},
	{2,0,20,0,0,8,0,11},
	{2,0,20,0,0,0,0,11},
	{2,0,20,0,0,0,12,11},
	{2,0,20,0,0,0,8,11},
	{2,0,20,0,0,0,0,11},
	{2,0,20,0,17,15,13,11},
	{2,0,20,0,18,16,14,11},
	
	{2,0,20,0,0,0,0,11},
	{2,0,20,0,0,0,0,11},
	{2,0,20,0,0,0,0,11},
	{2,0,20,0,0,0,0,11},
	{2,0,20,0,0,0,0,11},
	{2,0,20,0,0,12,0,11},
	{2,0,20,0,0,8,0,11},
	{2,0,20,0,0,0,0,11},
	{2,0,20,0,0,0,0,11},
	{2,0,20,0,0,0,0,11},
	{2,0,20,0,0,0,0,11},
	{2,0,20,0,17,15,13,11},
	{2,0,20,0,18,16,14,11},
	{2,0,20,0,0,0,0,11},
	{2,0,21,0,0,0,0,11},
	};
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage ventana) throws Exception {
		inicializarComponentes();
		graficos = canvas.getGraphicsContext2D();
		root.getChildren().add(canvas);
		ventana.setScene(escena);
		ventana.setTitle("BIENVENIDO A MI MUNDO");
		gestionarEventos();
		ventana.show();
		cicloJuego();		
	}
	
	public void inicializarComponentes() {
		jugadorAnimado = new JugadorAnimado(50,350,"principal",1, "caminar");
		root = new Group();
		escena = new Scene(root,990,528);
		canvas  = new Canvas(990,528);
		imagenes = new HashMap<String,Image>();
		item1 = new Item(250,320,0,0,"item");
		item2 = new Item(300,320,0,0,"item");
		item3 = new Item(450,380,0,0,"item");
		item4 = new Item(500,380,0,0,"item");
		item5 = new Item(700,430,0,0,"item");
		item6 = new Item(750,430,0,0,"item");
		cargarImagenes();
		cargarTiles();
	}
	
	public void cargarImagenes() {
		imagenes.put("principal", new Image("principal.png"));
		imagenes.put("tilemap", new Image("tilemap.png"));
		imagenes.put("item", new Image("item.png"));
	}
	
	public void pintar() {
		graficos.setFill(Color.LIGHTGREEN);
		graficos.fillRect(0, 0, 1000, 1000);
		graficos.setFill(Color.BLACK);
		graficos.fillText("Puntuacion: " + puntuacion , 0, 0);
		jugadorAnimado.pintar(graficos);
		//Pintar tiles
		for (int i=0;i<tiles.size();i++)
			tiles.get(i).pintar(graficos);
		//item
		item1.pintar(graficos);
		item2.pintar(graficos);
		item3.pintar(graficos);
		item4.pintar(graficos);
		item5.pintar(graficos);
		item6.pintar(graficos);



	}
	
	public void cargarTiles() {
		tiles = new ArrayList<Tile>();
		for(int i=0; i<mapa.length; i++) {
			for(int j=0; j<mapa[i].length; j++) {
				if (mapa[i][j]!=0)
					tiles.add(new Tile(mapa[i][j], i*66, j*66, "tilemap",0));
			}
		}
	}
	
	
	public void gestionarEventos() {
		//Evento cuando se presiona una tecla
		escena.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent evento) {
					//Aqui tengo que poner el codigo para identificar cuando se presiono una tecla
					switch (evento.getCode().toString()) {
						case "RIGHT": //derecha
							derecha=true;
							break;
						case "LEFT": //derecha
							izquierda=true;
						break;
						case "UP":
							arriba=true;
							break;
						case "DOWN":
							abajo=true;
							break;
						case "SPACE":
							jugadorAnimado.setVelocidad(10);
							jugadorAnimado.setIndiceImagen("principal");
							break;
					}
			}			
		});
		
		escena.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent evento) {
				//Aqui tengo que poner el codigo para identificar cuando se suelta una tecla
				switch (evento.getCode().toString()) {
				case "RIGHT": //derecha
					derecha=false;
					break;
				case "LEFT": //derecha
					izquierda=false;
				break;
				case "UP":
					arriba=false;
					break;
				case "DOWN":
					abajo=false;
					break;
				case "SPACE":
					jugadorAnimado.setVelocidad(1);
					jugadorAnimado.setIndiceImagen("principal");
					break;
			}
				
			}
			
		});
		
	}
	
	public void cicloJuego() {
		long tiempoInicial = System.nanoTime();
		AnimationTimer animationTimer = new AnimationTimer() {
			//Esto simula un ciclo de 60FPS
			@Override
			public void handle(long tiempoActualNanoSegundos) {
				double t = (tiempoActualNanoSegundos - tiempoInicial) / 1000000000.0;
				pintar();
				actualizar(t);
				
			}
			
		};
		animationTimer.start(); //Comienzo de ciclo
	}
	
	public void actualizar(double t) {
		jugadorAnimado.mover();
		
		jugadorAnimado.verificarColisiones(item1);
		jugadorAnimado.verificarColisiones(item2);
		jugadorAnimado.verificarColisiones(item3);
		jugadorAnimado.verificarColisiones(item4);
		jugadorAnimado.verificarColisiones(item5);
		jugadorAnimado.verificarColisiones(item6);
		
		jugadorAnimado.actualizarAnimacion(t);
	}

}
