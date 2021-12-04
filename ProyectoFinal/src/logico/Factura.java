package logico;
import java.io.Serializable;
import java.util.ArrayList;

import Visual.auxiliarCarito2;
import Visual.auxiliarCarrito;

public class Factura implements Serializable {
	
private static final long serialVersionUID = -17876355794681696L;


	private String Codigo;
	private float LimiteCredito;
	private float preciototal;
	Usuario vendedor;
	ArrayList<auxiliarCarito2>miscombos;
	ArrayList<auxiliarCarrito>miscomponentes;
	Cliente cliente;
	private String tipodepago;
	private boolean pagado;
	public Factura(String codigo, float limiteCredito, Usuario vendedor, ArrayList<auxiliarCarito2> miscombos,
			ArrayList<auxiliarCarrito> miscomponentes, Cliente cliente, String tipodepago, boolean pagado) {
		super();
		Codigo = codigo;
		LimiteCredito = limiteCredito;
		this.vendedor = vendedor;
		this.miscombos =new ArrayList<auxiliarCarito2>();
		this.miscomponentes = new ArrayList<auxiliarCarrito>();
		this.cliente = cliente;
		this.tipodepago = tipodepago;
		this.pagado = pagado;
	}
	public String getCodigo() {
		return Codigo;
	}
	public float getLimiteCredito() {
		return LimiteCredito;
	}
	public float getpreciototal() {
		preciototall();
		return preciototal;
	}
	public Usuario getVendedor() {
		return vendedor;
	}
	public ArrayList<auxiliarCarito2> getMiscombos() {
		return miscombos;
	}
	public ArrayList<auxiliarCarrito> getMiscomponentes() {
		return miscomponentes;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public String getTipodepago() {
		return tipodepago;
	}
	public boolean Pagado() {
		return pagado;
	}
	public void setCodigo(String codigo) {
		Codigo = codigo;
	}
	public void setLimiteCredito(float limiteCredito) {
		LimiteCredito = limiteCredito;
	}
	public void setVendedor(Usuario vendedor) {
		this.vendedor = vendedor;
	}
	public void setMiscombos(ArrayList<auxiliarCarito2> miscombos) {
		this.miscombos = miscombos;
	}
	public void setMiscomponentes(ArrayList<auxiliarCarrito> miscomponentes) {
		this.miscomponentes = miscomponentes;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public void setTipodepago(String tipodepago) {
		this.tipodepago = tipodepago;
	}
	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}
	/*public float setpreciototal() {
		return preciototal;
	}*/
	
public void preciototall(){
float aux = 0;
for (auxiliarCarito2 au2 : miscombos) {
	aux=aux+au2.preciototal();
}
for (auxiliarCarrito au : miscomponentes) {
	aux=aux+au.preciototal();
}
preciototal=aux;

}
}