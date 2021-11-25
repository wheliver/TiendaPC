package logico;

public class MemoriaRam extends Componente {
	private String marca;
	private float cantidadmemoria;
	private String tipomemoria;
	public MemoriaRam(String nombre,float precio, int cantidadDisponible, int numeroserie, int cantidadminima, Proveedor proveedor,
			String marca, float cantidadmemoria, String tipomemoria) {
		super(nombre, precio, cantidadDisponible, numeroserie, cantidadminima, proveedor);
		this.marca = marca;
		this.cantidadmemoria = cantidadmemoria;
		this.tipomemoria = tipomemoria;
	}
	public String getMarca() {
		return marca;
	}
	public float getCantidadmemoria() {
		return cantidadmemoria;
	}
	public String getTipomemoria() {
		return tipomemoria;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public void setCantidadmemoria(float cantidadmemoria) {
		this.cantidadmemoria = cantidadmemoria;
	}
	public void setTipomemoria(String tipomemoria) {
		this.tipomemoria = tipomemoria;
	}

}
