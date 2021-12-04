package logico;
import java.io.Serializable;
import java.util.ArrayList;
public class Factura implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -17876355794681696L;
	private String Codigo;
	private float LimiteCredito;
	private float preciototal;
	Usuario vendedor;
	ArrayList<Combos>miscombos;
	ArrayList<Componente>miscomponentes;
	Cliente cliente;
	private String tipodepago;
	private boolean pagado;
	public Factura(String codigo, float limiteCredito, Usuario vendedor, ArrayList<Combos> miscombos,
			ArrayList<Componente> miscomponentes, Cliente cliente, String tipodepago, boolean pagado) {
		super();
		Codigo = codigo;
		LimiteCredito = limiteCredito;
		this.vendedor = vendedor;
		this.miscombos =new ArrayList<Combos>();
		this.miscomponentes = new ArrayList<Componente>();
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
		return preciototal;
	}
	public Usuario getVendedor() {
		return vendedor;
	}
	public ArrayList<Combos> getMiscombos() {
		return miscombos;
	}
	public ArrayList<Componente> getMiscomponentes() {
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
	public void setMiscombos(ArrayList<Combos> miscombos) {
		this.miscombos = miscombos;
	}
	public void setMiscomponentes(ArrayList<Componente> miscomponentes) {
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
	public float setpreciototal() {
		return preciototal;
	}
	

}
