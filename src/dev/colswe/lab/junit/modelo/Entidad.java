package dev.colswe.lab.junit.modelo;

/**
 * Representación de un objeto singular de la aplicación con la información que
 * el cliente solicita
 *
 * @author juanmanuelmartinezromero
 */
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

    /**
     * A cada entidad creada le agrega el siguiente numero de ID
     */
    public Entidad() {
        super();
        id = ++COUNT;
    }

    /**
     * Crea una instancia de entidad a partir de los atributos ingresados
     *
     * @param cantidad
     * @param nombre
     * @param precioUnitario
     */
    public Entidad(final Long cantidad, final String nombre, final Double precioUnitario) {
        this();
        setCantidad(cantidad);
        setNombre(nombre);
        setPrecioUnitario(precioUnitario);
    }

    /**
     * @return El id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id ID a setear
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return La cantidad
     */
    public Long getCantidad() {
        return cantidad;
    }

    /**
     * Setea la cantidad y calcula el precio total
     *
     * @param cantidad Cantidad a setear
     */
    public void setCantidad(final Long cantidad) {
        this.cantidad = cantidad;
        calcularPrecioTotal();
    }

    /**
     * @return El nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre Nombre a setear
     */
    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return El precio unitario
     */
    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    /**
     * Setea el precio unitario y calcula el precio total
     * @param precioUnitario  Precio por unidad a setear
     */
    public void setPrecioUnitario(final Double precioUnitario) {
        this.precioUnitario = precioUnitario;
        calcularPrecioTotal();
    }
    /**
     * 
     * @return El precio Total
     */
    public Double getPrecioTotal() {
        return precioTotal;
    }
    
    /**
     * Calcula el precio total
     */
    private void calcularPrecioTotal() {
        //Si no tiene cantidad o no tiene precio @return null, si no, calcula el precio total
        precioTotal = cantidad == null || precioUnitario == null ? null : ((Long) (cantidad * precioUnitario.longValue())).doubleValue();
    }
    /**
     * Convierte los atributos de la entidad a un String
     * @return El String que representa la cadena
     */
    @Override
    public String toString() {
        return "Entidad [id=" + getId() + ", cantidad=" + cantidad + ", nombre=" + nombre + ", precioUnitario=" + precioUnitario + ", precioTotal=" + precioTotal + "]";
    }
}
