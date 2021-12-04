package logico;

import java.io.Serializable;

public class Componente implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = -2233352669269601963L;
protected String nombre;
protected float precio;
protected int cantidadDisponible;
protected int numeroserie;
protected int cantidadminima;
Proveedor proveedor;
public Componente(String nombre,float precio, int cantidadDisponible, int numeroserie, int cantidadminima, Proveedor proveedor) {
	super();
	this.nombre= nombre;
	this.precio = precio;
	this.cantidadDisponible = cantidadDisponible;
	this.numeroserie = numeroserie;
	this.cantidadminima = cantidadminima;
	this.proveedor = proveedor;
}
public float getPrecio() {
	return precio;
}
public int getCantidadDisponible() {
	return cantidadDisponible;
}
public int getNumeroserie() {
	return numeroserie;
}
public int getCantidadminima() {
	return cantidadminima;
}
public Proveedor getProveedor() {
	return proveedor;
}
public void setPrecio(float precio) {
	this.precio = precio;
}
public void setCantidadDisponible(int cantidadDisponible) {
	this.cantidadDisponible = cantidadDisponible;
}
public void setNumeroserie(int numeroserie) {
	this.numeroserie = numeroserie;
}
public void setCantidadminima(int cantidadminima) {
	this.cantidadminima = cantidadminima;
}
public void setProveedor(Proveedor proveedor) {
	this.proveedor = proveedor;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
}
