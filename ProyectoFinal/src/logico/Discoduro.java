package logico;

public class Discoduro extends Componente {
	private String marca;
	private String modelo;
	private float capacidadAlmacenamiento;
	private String tipoConexion;
	public Discoduro(float precio, int cantidadDisponible, int numeroserie, int cantidadminima, Proveedor proveedor,
			String marca, String modelo, float capacidadAlmacenamiento, String tipoConexion) {
		super(precio, cantidadDisponible, numeroserie, cantidadminima, proveedor);
		this.marca = marca;
		this.modelo = modelo;
		this.capacidadAlmacenamiento = capacidadAlmacenamiento;
		this.tipoConexion = tipoConexion;
	}
	public String getMarca() {
		return marca;
	}
	public String getModelo() {
		return modelo;
	}
	public float getCapacidadAlmacenamiento() {
		return capacidadAlmacenamiento;
	}
	public String getTipoConexion() {
		return tipoConexion;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public void setCapacidadAlmacenamiento(float capacidadAlmacenamiento) {
		this.capacidadAlmacenamiento = capacidadAlmacenamiento;
	}
	public void setTipoConexion(String tipoConexion) {
		this.tipoConexion = tipoConexion;
	}
}
