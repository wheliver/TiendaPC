package logico;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
public class Tienda implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = -6634036610616475881L;
private int cantClientesReal;
ArrayList<Combos>miscombos;
ArrayList<Factura>misfacturas;
ArrayList<Usuario>misusuarios;
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
	this.misusuarios = new ArrayList<Usuario>();
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
//Fichero
public void cargarTienda()  {
			FileInputStream file;
			ObjectInputStream oos;
			try {
				file = new FileInputStream("Tienda.dat");
				oos = new ObjectInputStream(file);
				Tienda.setInstanciaGlobal((Tienda)oos.readObject());
				oos.close();
			} catch(IOException | ClassNotFoundException e) 
			{
				Tienda.getInstance().guardarTienda();
			}
		}
	
public void guardarTienda() {
	FileOutputStream file;
	try {
		file = new FileOutputStream("Tienda.dat");
		ObjectOutputStream oos = new ObjectOutputStream(file);
		oos.writeObject(Tienda.getInstance());
		oos.close();
	} catch(IOException e)
	{
		e.printStackTrace();
	}
	
}
public ArrayList<OrdenCompra> getMis_orden() {
		return mis_orden;
	}
	public ArrayList<Componente> getMiscomponentes() {
		return miscomponentes;
	}
	public ArrayList<Usuario> getMisusuarios() {
		return misusuarios;
	}
	public void setMisusuarios(ArrayList<Usuario> misusuarios) {
		this.misusuarios = misusuarios;
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
public void crearCliente(String nombre, String direccion ,String telefono ,String rnc ,String cedula) {
	Cliente primer = new Cliente( nombre,direccion,telefono,rnc,cedula);
	misclientes.add(primer);
	cantClientesReal= cantClientesReal+1;
}
public Cliente buscarCliente(String Cedula) {
	Cliente aux = null;
	boolean encontrado = false;
	int buscador=0;
	
	/*while(!encontrado && buscador<cantClientesReal ) {
		if(misclientes.get(buscador).getCedula().equalsIgnoreCase(Cedula)) {
			encontrado=true;
			aux= misclientes.get(buscador);
		}
		buscador++;*/
	for(Cliente client : Tienda.getInstance().misclientes) {
		if(client.getCedula().equalsIgnoreCase(Cedula)) 
		{
			aux = client;
		}
		
	}
	return aux;

}
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
		if(miscomponentes.get(indexBuscador).getNombre().equalsIgnoreCase(codigo)) {
			aux = miscomponentes.get(indexBuscador);
			encontrado = true;				
		}
		indexBuscador++;
	}
	return aux;		
}

public Combos buscarcombo(String string) {
	// TODO Auto-generated method stub
	return null;
}
public void insertarCliente(Cliente a) {
	misclientes.add(a);
	cantClientesReal= cantClientesReal+1;
}
public Proveedor buscarProveedor(String rnc) {
	Proveedor aux = null;
	boolean encontrado = false;
	int indexBuscador=0;
	
	while (!encontrado && indexBuscador<misproveedores.size()) {
		if(misproveedores.get(indexBuscador).getNombre().equalsIgnoreCase(rnc)) {
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
public String tipoComponente(Componente componente) {
	// TODO Auto-generated method stub
	return null;
}
public boolean confirmLogin(String text, String text2) {
	boolean login = false;
	for (Usuario user : misusuarios) {
		if(user.getUsername().equals(text) && user.getPassword().equals(text2)){
			login = true;
		}
	}
	return login;
}
public void insertarUsuario(Usuario a) {
	misusuarios.add(a);
}
public void insetarFactura(Factura f) {
	// TODO Auto-generated method stub
	misfacturas.add(f);
}
public void insertarOrdendecompra(OrdenCompra ad) {
	// TODO Auto-generated method stub
	mis_orden.add(ad);
}
public Usuario dameloger(String u, String o) {
	// TODO Auto-generated method stub
	Usuario us = null;
		for (Usuario user : misusuarios) {
		if(user.getUsername().equals(u) && user.getPassword().equals(o)){
		us=user;
		}
	}
	return us;
	
}
};
