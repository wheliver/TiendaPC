package logico;

import java.util.ArrayList;
import java.util.Date;

public class Tienda {
private int cantClientesReal;
ArrayList<Combos>miscombos;
ArrayList<Factura>misfacturas;
ArrayList<Cliente>misclientes;
ArrayList<OrdenCompra>mis_orden;

public Tienda(ArrayList<Combos> miscombos, ArrayList<Factura> misfacturas, ArrayList<Cliente> misclientes) {
	super();
	this.miscombos =  new ArrayList<Combos>();
	this.misfacturas =  new ArrayList<Factura>();
	this.misclientes =  new ArrayList<Cliente>();
	this.mis_orden = new ArrayList<OrdenCompra>();
	this.cantClientesReal=0;
}
public ArrayList<Combos> getMiscombos() {
	return miscombos;
}
public ArrayList<Factura> getMisfacturas() {
	return misfacturas;
}
public ArrayList<Cliente> getMisclientes() {
	return misclientes;
}
public void setMiscombos(ArrayList<Combos> miscombos) {
	this.miscombos = miscombos;
}
public void setMisfacturas(ArrayList<Factura> misfacturas) {
	this.misfacturas = misfacturas;
}
public void setMisclientes(ArrayList<Cliente> misclientes) {
	this.misclientes = misclientes;
}
public void crearCliente(String nombre, String direccion ,String telefono ,String rnc ,String cedula ,float limiteCredito ,float cuentasxCobrar) {
	Cliente primer = new Cliente( nombre,direccion,telefono,rnc,cedula,limiteCredito , cuentasxCobrar);
	misclientes.add(primer);
	cantClientesReal= cantClientesReal+1;
}
public Cliente buscarCliente(String Cedula) {
	Cliente aux = null;
	boolean encontrado = false;
	int buscador=0;
	
	while(!encontrado && buscador<cantClientesReal ) {
		if(misclientes.get(buscador).getCedula().equalsIgnoreCase(Cedula)) {
			encontrado=true;
			aux= misclientes.get(buscador);
		}
		buscador++;
	}
	
	return aux;
}/*
public Cliente buscarComponente(int numeroserie) {
	Cliente aux = null;
	boolean encontrado = false;
	int buscador=0;
	
	while(!encontrado && buscador<cantClientesReal ) {
		if(misclientes.get(buscador).getequalsIgnoreCase(Cedula)) {
			encontrado=true;
			aux= misclientes.get(buscador);
		}
		buscador++;
	}
	
	return aux;
}*/
public void CrearOrdendecompra(String codigo, Date fecha, String estado, int cantidad, Componente compo, float preciounitario,
		Proveedor proveedor, String tipodepago) {
	OrdenCompra orde = new OrdenCompra(codigo, fecha, estado, cantidad, compo, preciounitario, proveedor, tipodepago);
	mis_orden.add(orde);
}
};
