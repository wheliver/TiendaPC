package Visual;
import logico.Combos;
public class auxiliarCarito2 {
	private int cantidad;
	private Combos carrito;
public auxiliarCarito2(int cantidad, Combos carrito) {
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


public Combos getCarrito() {
	return carrito;
}


public void setCarrito(Combos carrito) {
	this.carrito = carrito;
}
public float preciototal() {
	 float aux=(carrito.getPrecio()*cantidad);
	return aux ;
}
}