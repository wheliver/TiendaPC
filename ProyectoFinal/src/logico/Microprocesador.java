package logico;

public class Microprocesador extends Componente {
	private String marca;
	private String modelo;
	private String tipoconector;
	private float velocidadprocesamiento;
	public Microprocesador(float precio, int cantidadDisponible, int numeroserie, int cantidadminima,
			Proveedor proveedor, String marca, String modelo, String tipoconector, float velocidadprocesamiento) {
		super(precio, cantidadDisponible, numeroserie, cantidadminima, proveedor);
		this.marca = marca;
		this.modelo = modelo;
		this.tipoconector = tipoconector;
		this.velocidadprocesamiento = velocidadprocesamiento;
	}
	public String getMarca() {
		return marca;
	}
	public String getModelo() {
		return modelo;
	}
	public String getTipoconector() {
		return tipoconector;
	}
	public float getVelocidadprocesamiento() {
		return velocidadprocesamiento;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public void setTipoconector(String tipoconector) {
		this.tipoconector = tipoconector;
	}
	public void setVelocidadprocesamiento(float velocidadprocesamiento) {
		this.velocidadprocesamiento = velocidadprocesamiento;
	}
	
}
