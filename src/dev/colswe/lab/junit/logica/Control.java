package dev.colswe.lab.junit.logica;

import dev.colswe.lab.junit.modelo.Entidad;
import dev.colswe.lab.junit.modelo.EntidadDAO;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;

/**
 *  Clase de lógica de la aplicación. Contiene todo lo necesario para ejecutar las pruebas
 * @author juanmanuelmartinezromero
 */
public class Control {

    private final static EntidadDAO DAO;

    // Crea una sola instancia de EntidadDAO
    static {
        DAO = new EntidadDAO();
    }

    /**
     * Agrega una entidad por medio de EntidadDAO
     *
     * @param cantidad Numero de entidaddes
     * @param nombre Nombre de la entidad
     * @param precioUnitario Precio de la entidad
     */
    public void agregarEntidad(final Long cantidad, final String nombre, final Double precioUnitario) {
        if (DAO.listarEntidades() == null) {    //Si no hay entidades se creará una arreglo que las contendrá
            DAO.setEntidades(new ArrayList<Entidad>());
        }
        DAO.agregarEntidad(new Entidad(cantidad, nombre, precioUnitario)); //Crea una entidad y la agrega
    }

    /**
     * Agrega un conjunto de Entidades en un Arreglo por medio del metodo agregarEntidad
     * @param entidades Arreglo bidimensional (Las propiedades de las entidades entre un arreglo de Objetos, a decir, la cantidad: Posicion[0], el nombre: Posicion[1], el precio Unitario: Posicion[3])
     */
    public void agregarEntidades(final Object[][] entidades) {
        for (final Object[] entidad : entidades) { 
            agregarEntidad((Long) entidad[0], (String) entidad[1], (Double) entidad[2]); // Para cada entidad llama a agregarEntidad
        }
    }
    /**
     * Crea una Colección de entidades ordenadas a partir del nombre del campo proporcionado.
     * @param nombreCampo Nombre del campo contenido dentro de la entidad, puede ser Nombre, Cantidad o PrecioUnitario
     * @return Colección organizada de entidades
     */
    public Collection<Entidad> ordenar(final String nombreCampo) {
        final Collection<Entidad> tmp = new TreeSet<Entidad>(   //  Crea una coleccion de entidades a partir de un TreeSet
                new Comparator<Entidad>() { //  Es necesario crear un comparador de entidades para el TreeSet
                    @Override
                    public int compare(final Entidad o1, final Entidad o2) {    //  Se sobreescribe el metodo compare para organizar el TreeSet
                        int ret = 0;
                        try {
                            /*
                             * Obtiene el metodo con el nombre de campo proporcionado, 
                            agregando get y conviertiendo la primer letra a Mayuscula y le agrega el resto de la cadena*/
                            final Method method = Entidad.class.getMethod("get" + nombreCampo.substring(0, 1).toUpperCase() + nombreCampo.substring(1));
                            final Object val1 = method.invoke(o1);  //Invoca los metodos para obtener el atributo de las entidades segun el atributo ingresado
                            final Object val2 = method.invoke(o2);
                            if (val1 instanceof Long) {
                                ret = ((Long) val1).compareTo((Long) val2); //  Si es instancia de Long los compara segun el atributo cantidad
                            } else if (val1 instanceof Double) {
                                ret = ((Double) val1).compareTo((Double) val2); //   Si es instancia de Double los compara segun el atributo precio
                            } else if (val1 instanceof String) {
                                ret = ((String) val1).compareTo((String) val2); //   Si es instancia de String los compara segun el atributo nombre
                            }
                        } catch (final Exception e) {
                            e.printStackTrace();
                        }
                        return ret;
                    }
                });
        tmp.addAll(DAO.listarEntidades());  //  Agrega las entidades del DAO al TreeSet
        return tmp;
    }
}
