package logico;

import java.io.Serializable;
import java.util.Date;

public class OrdenCompra implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = -275997159540814236L;
private String codigo;
private Date fecha;
private String Estado;
private int cantidad;
Componente compo;
private float preciounitario;
Proveedor proveedor;
private String tipodepago;
public OrdenCompra(String codigo, Date fecha, String estado, int cantidad, Componente compo, float preciounitario,
		Proveedor proveedor, String tipodepago) {
	super();
	this.codigo = codigo;
	this.fecha = fecha;
	Estado = estado;
	this.cantidad = cantidad;
	this.compo = compo;
	this.preciounitario = preciounitario;
	this.proveedor = proveedor;
	this.tipodepago = tipodepago;
}
public String getCodigo() {
	return codigo;
}
public Date getFecha() {
	return fecha;
}
public String getEstado() {
	return Estado;
}
public int getCantidad() {
	return cantidad;
}
public Componente getCompo() {
	return compo;
}
public float getPreciounitario() {
	return preciounitario;
}
public Proveedor getProveedor() {
	return proveedor;
}
public String getTipodepago() {
	return tipodepago;
}
public void setCodigo(String codigo) {
	this.codigo = codigo;
}
public void setFecha(Date fecha) {
	this.fecha = fecha;
}
public void setEstado(String estado) {
	Estado = estado;
}
public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}
public void setCompo(Componente compo) {
	this.compo = compo;
}
public void setPreciounitario(float preciounitario) {
	this.preciounitario = preciounitario;
}
public void setProveedor(Proveedor proveedor) {
	this.proveedor = proveedor;
}
public void setTipodepago(String tipodepago) {
	this.tipodepago = tipodepago;
}
}
