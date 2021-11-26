package logico;

import java.util.ArrayList;
public class Combos {
private String codigo;
private String nombre;
private float descuento;
ArrayList<Componente> miscomponentes;
public Combos(String codigo, String nombre, float descuento, ArrayList<Componente> miscomponentes) {
	super();
	this.codigo = codigo;
	this.nombre = nombre;
	this.descuento = descuento;
	this.miscomponentes =  new ArrayList<Componente>();
}
public String getCodigo() {
	return codigo;
}
public String getNombre() {
	return nombre;
}
public float getDescuento() {
	return descuento;
}
public ArrayList<Componente> getMiscomponentes() {
	return miscomponentes;
}
public void setCodigo(String codigo) {
	this.codigo = codigo;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public void setDescuento(float descuento) {
	this.descuento = descuento;
}
public void setMiscomponentes(ArrayList<Componente> miscomponentes) {
	this.miscomponentes = miscomponentes;
}
public float  getPrecio() {
	float aux = 0;
	
	for (Componente com : miscomponentes) {
		aux= com.getPrecio()+ aux;
	}
	aux=(aux-(aux*descuento));
	return aux;
}
}
