package dev.colswe.lab.junit.modelo;

import java.util.Collection;

/**
 * Clase de acceso a datos
 *
 * @author juanmanuelmartinezromero
 */
public class EntidadDAO {

    private final Sistema sistema = Sistema.getInstance();  //  Crea una sola instancia de sistema

    /**
     * @return La lista de entidades
     */
    public Collection<Entidad> listarEntidades() {
        return sistema.getEntidades();
    }
    /**
     * Setea el conjunto de entidades
     * @param entidades Conjunto de entidades a setear
     */
    public void setEntidades(final Collection<Entidad> entidades) {
        sistema.setEntidades(entidades);
    }
    /**
     * Agrega una entidad a la colección
     * @param entidad 
     */
    public void agregarEntidad(final Entidad entidad) {
        sistema.getEntidades().add(entidad);
    }
}
