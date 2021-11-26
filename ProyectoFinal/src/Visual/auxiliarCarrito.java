package Visual;
import logico.Componente;

public class auxiliarCarrito {
	private int cantidad;
	private Componente carrito;
public auxiliarCarrito(int cantidad, Componente carrito) {
		super();
		this.cantidad = cantidad;
		this.carrito = carrito;
	}

public int getCantidad() {
	return cantidad;
}


public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}


public Componente getCarrito() {
	return carrito;
}


public void setCarrito(Componente carrito) {
	this.carrito = carrito;
}
public float preciototal() {
	 float aux=(carrito.getPrecio()*cantidad);
	return aux ;
}
}