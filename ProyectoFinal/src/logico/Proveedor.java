package logico;

public class Proveedor {
private String nombre;
private String rnc;
private String telefono;
private String direccion;
private float cuentaxpagar;
public Proveedor(String nombre, String rnc, String telefono, String direccion, float cuentaxpagar) {
	super();
	this.nombre = nombre;
	this.rnc = rnc;
	this.telefono = telefono;
	this.direccion = direccion;
	this.cuentaxpagar = cuentaxpagar;
}
public String getNombre() {
	return nombre;
}
public String getRnc() {
	return rnc;
}
public String getTelefono() {
	return telefono;
}
public String getDireccion() {
	return direccion;
}
public float getCuentaxpagar() {
	return cuentaxpagar;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public void setRnc(String rnc) {
	this.rnc = rnc;
}
public void setTelefono(String telefono) {
	this.telefono = telefono;
}
public void setDireccion(String direccion) {
	this.direccion = direccion;
}
public void setCuentaxpagar(float cuentaxpagar) {
	this.cuentaxpagar = cuentaxpagar;
}
}
