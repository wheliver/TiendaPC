package logico;

import java.util.ArrayList;
public class Tienda {
ArrayList<Combos>miscombos;
ArrayList<Factura>misfacturas;
ArrayList<Cliente>misclientes;
public Tienda(ArrayList<Combos> miscombos, ArrayList<Factura> misfacturas, ArrayList<Cliente> misclientes) {
	super();
	this.miscombos =  new ArrayList<Combos>();
	this.misfacturas =  new ArrayList<Factura>();
	this.misclientes =  new ArrayList<Cliente>();
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
}
