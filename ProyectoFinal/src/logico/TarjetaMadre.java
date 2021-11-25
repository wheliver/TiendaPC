package logico;

import java.util.ArrayList;

public class TarjetaMadre extends Componente {
	private String marca;
	private String modelo;
	private String tipoconector;
	private String tipomemoriaRam;
	ArrayList<String> misconexiones;
	public TarjetaMadre(String nombre,float precio, int cantidadDisponible, int numeroserie, int cantidadminima, Proveedor proveedor,
			String marca, String modelo, String tipoconector, String tipomemoriaRam, ArrayList<String> misconexiones) {
		super(nombre, precio, cantidadDisponible, numeroserie, cantidadminima, proveedor);
		this.marca = marca;
		this.modelo = modelo;
		this.tipoconector = tipoconector;
		this.tipomemoriaRam = tipomemoriaRam;
		this.misconexiones = misconexiones;
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
	public String getTipomemoriaRam() {
		return tipomemoriaRam;
	}
	public ArrayList<String> getMisconexiones() {
		return misconexiones;
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
	public void setTipomemoriaRam(String tipomemoriaRam) {
		this.tipomemoriaRam = tipomemoriaRam;
	}
	public void setMisconexiones(ArrayList<String> misconexiones) {
		this.misconexiones = misconexiones;
	}

}
