package logico;

import java.util.ArrayList;
import java.util.Date;

public class Tienda {
private int cantClientesReal;
ArrayList<Combos>miscombos;
ArrayList<Factura>misfacturas;
ArrayList<Cliente>misclientes;
ArrayList<OrdenCompra>mis_orden;
ArrayList<Componente>miscomponentes;
ArrayList<Proveedor>misproveedores;
public static Tienda instanciaGlobal = null;
private int generadorcodigoCompo;

public Tienda() {
	super();
	this.miscombos =  new ArrayList<Combos>();
	this.misfacturas =  new ArrayList<Factura>();
	this.misclientes =  new ArrayList<Cliente>();
	this.mis_orden = new ArrayList<OrdenCompra>();
	this.miscomponentes = new ArrayList<Componente>();
	this.cantClientesReal=0;
	this.misproveedores = new ArrayList<Proveedor>();
}
//patron singelton
	public static Tienda getInstance() {
		if(instanciaGlobal == null) {
			instanciaGlobal = new Tienda();
		}
		return instanciaGlobal;
	}
public ArrayList<OrdenCompra> getMis_orden() {
		return mis_orden;
	}
	public ArrayList<Componente> getMiscomponentes() {
		return miscomponentes;
	}
	public ArrayList<Proveedor> getMisproveedores() {
		return misproveedores;
	}
	public void setMisproveedores(ArrayList<Proveedor> misproveedores) {
		this.misproveedores = misproveedores;
	}
	public void setMis_orden(ArrayList<OrdenCompra> mis_orden) {
		this.mis_orden = mis_orden;
	}
	public void setMiscomponentes(ArrayList<Componente> miscomponentes) {
		this.miscomponentes = miscomponentes;
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
public int getCantClientesReal() {
	return cantClientesReal;
}
public void setCantClientesReal(int cantClientesReal) {
	this.cantClientesReal = cantClientesReal;
}
public static Tienda getInstanciaGlobal() {
	return instanciaGlobal;
}
public static void setInstanciaGlobal(Tienda instanciaGlobal) {
	Tienda.instanciaGlobal = instanciaGlobal;
}
public int getGeneradorcodigoCompo() {
	return generadorcodigoCompo;
}
public void setGeneradorcodigoCompo(int generadorcodigoCompo) {
	this.generadorcodigoCompo = generadorcodigoCompo;
}
public void crearCliente(String nombre, String direccion ,String telefono ,String rnc ,String cedula ) {
	Cliente primer = new Cliente( nombre,direccion,telefono,rnc,cedula);
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
public void introducirComponente(Componente compo) {
	miscomponentes.add(compo);	
	setGeneradorcodigoCompo(getGeneradorcodigoCompo()+1);
}
public Cliente BuscarCliente(String text) {
	Cliente cliente = null;
	boolean encontrado = false;
	int indexBuscador=0;
	
	while (!encontrado && indexBuscador<misclientes.size()) {
		if(misclientes.get(indexBuscador).getCedula().equalsIgnoreCase(text)) {				
			cliente=misclientes.get(indexBuscador);
			encontrado = true;				
		}
		indexBuscador++;
	}
	return cliente;
}
public Factura buscarFacturaCliente(Cliente clien) {
		Factura aux= null;
		boolean encontrado = false;
		int indexBuscador=0;
		
		while (!encontrado && indexBuscador<misfacturas.size()) {
			if(misfacturas.get(indexBuscador).getCliente() == clien) {
				aux = misfacturas.get(indexBuscador);
				encontrado = true;				
			}
			indexBuscador++;
		}
		return aux;	
	}
public Factura buscarFacturaCodigo(String codigo) {
	Factura aux= null;
	boolean encontrado = false;
	int indexBuscador=0;
	
	while (!encontrado && indexBuscador<misfacturas.size()) {
		if(misfacturas.get(indexBuscador).getCodigo().equalsIgnoreCase(codigo)) {
			aux = misfacturas.get(indexBuscador);
			encontrado = true;				
		}
		indexBuscador++;
	}
	return aux;		
}
public Componente buscarcomponente(String codigo) {
	Componente aux= null;
	boolean encontrado = false;
	int indexBuscador=0;
	
	while (!encontrado && indexBuscador<miscomponentes.size()) {
		if(miscomponentes.get(indexBuscador).nombre.equalsIgnoreCase(codigo)) {
			aux = miscomponentes.get(indexBuscador);
			encontrado = true;				
		}
		indexBuscador++;
	}
	return aux;		
}
public void insertarCliente(Cliente a) {
	misclientes.add(a);
}
public Proveedor buscarProveedor(String rnc) {
	Proveedor aux = null;
	boolean encontrado = false;
	int indexBuscador=0;
	
	while (!encontrado && indexBuscador<misfacturas.size()) {
		if(misfacturas.get(indexBuscador).getCodigo().equalsIgnoreCase(rnc)) {
			aux = misproveedores.get(indexBuscador);
			encontrado = true;				
		}
		indexBuscador++;
	}
	return aux;		
}
public void insertarProveedor(Proveedor a) {
	misproveedores.add(a);
	
}
};
