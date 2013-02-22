package dev.colswe.lab.junit.modelo;

import java.util.Collection;

/**
 * Emulación de la base de datos
 *
 * @author juanmanuelmartinezromero
 */
public class Sistema {

    private Collection<Entidad> entidades;
    private static Sistema instance;

    /**
     * Conatructor de Sistema
     */
    private Sistema() {
    }
    /**
     * Crea una unica instancia de sistema.
     * @return la instancia del sistema
     */
    public static Sistema getInstance() {
        if (instance == null) {
            instance = new Sistema();
        }
        return instance;
    }
    /**
     * @return una Coleccion de entidades.
     */
    public Collection<Entidad> getEntidades() {
        return entidades;
    }
    /**
     * Setea la lista de Entidades
     * @param entidades lista de entidades a setear
     */
    public void setEntidades(final Collection<Entidad> entidades) {
        this.entidades = entidades;
    }
}
