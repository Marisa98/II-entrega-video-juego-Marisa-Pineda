package clases;

import implementacion.JuegoPrincipal;
import javafx.scene.canvas.GraphicsContext;

public class Tile {
 private int x;
 private int y;
//Paramatros dentro de la imagen principal
 private int altoImagen;
 private int anchoImagen;
 private int xImagen;
 private int yImagen;
 private String indiceImagen;
 private int velocidad;
public Tile(int x, int y, int altoImagen, int anchoImagen, int xImagen, int yImagen, String indiceImagen,
		int velocidad) {
	super();
	this.x = x;
	this.y = y;
	this.altoImagen = altoImagen;
	this.anchoImagen = anchoImagen;
	this.xImagen = xImagen;
	this.yImagen = yImagen;
	this.indiceImagen = indiceImagen;
	this.velocidad = velocidad;
}
  public Tile(int tipoTile, int x, int y, String indiceImagen, int velocidad) {
	super();
	this.x = x;
	this.y = y;
	this.indiceImagen = indiceImagen;
	this.velocidad = velocidad;
    
	switch(tipoTile){
     case 1://Tierra
	     this.altoImagen = 66;
	     this.anchoImagen = 66;
	     this.xImagen = 73;
	     this.yImagen = 842;
     break;
      case 2: //Nubes
	     this.altoImagen = 66;
	     this.anchoImagen = 66;
	     this.xImagen = 283;
	     this.yImagen = 423;
     break;
     case 3: //Rosas
	     this.altoImagen = 66;
	     this.anchoImagen = 66;
	     this.xImagen = 143;
	     this.yImagen = 420;
     break;
     case 4://Puerta
	     this.altoImagen = 66;
	     this.anchoImagen = 66;
	     this.xImagen = 353;
	     this.yImagen = 72;
     break;
    case 5://ventana
	     this.altoImagen = 66;
	     this.anchoImagen = 66;
	     this.xImagen = 283;
	     this.yImagen = 3;
     break;
     case 6://bloque
	     this.altoImagen = 66;
	     this.anchoImagen = 66;
	     this.xImagen = 282;
	     this.yImagen = 142;
     break;
    case 7://Cesped
	     this.altoImagen = 66;
	     this.anchoImagen = 66;
	     this.xImagen = 73;
	     this.yImagen = 73;
     break;
    case 8://tronco
	     this.altoImagen = 66;
	     this.anchoImagen = 66;
	     this.xImagen = 73;
	     this.yImagen =421;
    break;
    case 9://cubo
	     this.altoImagen = 66;
	     this.anchoImagen = 66;
	     this.xImagen = 562;
	     this.yImagen = 74;
    break;
   case 10://rosas rojas
	     this.altoImagen = 66;
	     this.anchoImagen = 66;
	     this.xImagen = 3;
	     this.yImagen = 350;
   break;
   case 11://agua
	     this.altoImagen = 66;
	     this.anchoImagen = 66;
	     this.xImagen = 353;
	     this.yImagen = 354;
 break;
   case 12://rotulo
	     this.altoImagen = 66;
	     this.anchoImagen = 66;
	     this.xImagen = 983;
	     this.yImagen = 275;
break;
 
   case 13://Raiz arbol #1
	     this.altoImagen = 66;
	     this.anchoImagen = 66;
	     this.xImagen = 72;
	     this.yImagen = 701;
break;

   case 14://Raiz arbol #2
	     this.altoImagen = 66;
	     this.anchoImagen = 66;
	     this.xImagen = 143;
	     this.yImagen = 701;
break;
   case 15://hojas arbol #3
	     this.altoImagen = 66;
	     this.anchoImagen = 66;
	     this.xImagen = 74;
	     this.yImagen = 631;
break;
   case 16://hojas arbol #4
	     this.altoImagen = 66;
	     this.anchoImagen = 66;
	     this.xImagen = 142;
	     this.yImagen = 631;
break;
   case 17://hojas arbol #5
	     this.altoImagen = 66;
	     this.anchoImagen = 66;
	     this.xImagen = 75;
	     this.yImagen = 562;  
break;
   case 18://hojas arbol #6
	     this.altoImagen = 66;
	     this.anchoImagen = 66;
	     this.xImagen = 142;
	     this.yImagen = 563;
break;
   case 19://cerca #1
	     this.altoImagen = 66;
	     this.anchoImagen = 66;
	     this.xImagen = 213;
	     this.yImagen = 632;
break;
   case 20://cerca #2
	     this.altoImagen = 66;
	     this.anchoImagen = 66;
	     this.xImagen = 282;
	     this.yImagen = 633;
break;
   case 21://cerca #3
	     this.altoImagen = 66;
	     this.anchoImagen = 66;
	     this.xImagen = 351;
	     this.yImagen = 632;
break;
   case 22://piedra verde
	     this.altoImagen = 66;
	     this.anchoImagen = 66;
	     this.xImagen = 5;
	     this.yImagen = 431;
break;
     }
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
public int getAltoImagen() {
return altoImagen;
}
public void setAltoImagen(int altoImagen) {
this.altoImagen = altoImagen;
}
public int getAnchoImagen() {
return anchoImagen;
}
public void setAnchoImagen(int anchoImagen) {
this.anchoImagen = anchoImagen;
}
public int getxImagen() {
return xImagen;
}
public void setxImagen(int xImagen) {
this.xImagen = xImagen;
}
public int getyImagen() {
return yImagen;
}
public void setyImagen(int yImagen) {
this.yImagen = yImagen;
}
public String getIndiceImagen() {
return indiceImagen;
}
public void setIndiceImagen(String indiceImagen) {
this.indiceImagen = indiceImagen;
}
public int getVelocidad() {
return velocidad;
}
public void setVelocidad(int velocidad) {
this.velocidad = velocidad;
}

public void pintar(GraphicsContext graficos) {
graficos.drawImage(
	JuegoPrincipal.imagenes.get(this.indiceImagen), 
	this.xImagen, this.yImagen, 
	this.anchoImagen, this.altoImagen, 
	this.x--, this.y,
	this.anchoImagen, this.altoImagen
);
}

}