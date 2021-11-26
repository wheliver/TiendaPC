package logico;

public class Cliente {
private String nombre;
private String direccion;
private String telefono;
private String rnc;
private String cedula;
private float LimiteCredito;
private float CuentasxCobrar;
public Cliente(String nombre, String direccion, String telefono, String rnc, String cedula) {
	super();
	this.nombre = nombre;
	this.direccion = direccion;
	this.telefono = telefono;
	this.rnc = rnc;
	this.cedula = cedula;
}
public String getNombre() {
	return nombre;
}
public String getDireccion() {
	return direccion;
}
public String getTelefono() {
	return telefono;
}
public String getRnc() {
	return rnc;
}
public String getCedula() {
	return cedula;
}
public float getLimiteCredito() {
	return LimiteCredito;
}
public float getCuentasxCobrar() {
	return CuentasxCobrar;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public void setDireccion(String direccion) {
	this.direccion = direccion;
}
public void setTelefono(String telefono) {
	this.telefono = telefono;
}
public void setRnc(String rnc) {
	this.rnc = rnc;
}
public void setCedula(String cedula) {
	this.cedula = cedula;
}
public void setLimiteCredito(float limiteCredito) {
	LimiteCredito = limiteCredito;
}
public void setCuentasxCobrar(float cuentasxCobrar) {
	CuentasxCobrar = cuentasxCobrar;
}

}
