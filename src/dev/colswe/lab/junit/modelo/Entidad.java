package dev.colswe.lab.junit.modelo;

public class Entidad {

	public static final String CAMPO_CANTIDAD = "cantidad";
	public static final String CAMPO_NOMBRE = "nombre";
	public static final String CAMPO_PRECIO_UNITARIO = "precioUnitario";
	public static final String CAMPO_PRECIO_TOTAL = "precioTotal";

	private static Long COUNT = 0L;
	private Long id;
	private Long cantidad;
	private String nombre;
	private Double precioUnitario;
	private transient Double precioTotal;

	public Entidad() {
		super();
		id = ++COUNT;
	}

	public Entidad(final Long cantidad, final String nombre, final Double precioUnitario) {
		this();
		setCantidad(cantidad);
		setNombre(nombre);
		setPrecioUnitario(precioUnitario);
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public Long getCantidad() {
		return cantidad;
	}

	public void setCantidad(final Long cantidad) {
		this.cantidad = cantidad;
		calcularPrecioTotal();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(final Double precioUnitario) {
		this.precioUnitario = precioUnitario;
		calcularPrecioTotal();
	}

	public Double getPrecioTotal() {
		return precioTotal;
	}

	private void calcularPrecioTotal() {
		precioTotal = cantidad == null || precioUnitario == null ? null : ((Long) (cantidad * precioUnitario.longValue())).doubleValue();
	}

	@Override
	public String toString() {
		return "Entidad [id=" + id + ", cantidad=" + cantidad + ", nombre=" + nombre + ", precioUnitario=" + precioUnitario + ", precioTotal=" + precioTotal + "]";
	}

}
