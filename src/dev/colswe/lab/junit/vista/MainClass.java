package dev.colswe.lab.junit.vista;

import dev.colswe.lab.junit.logica.Control;
import dev.colswe.lab.junit.modelo.Entidad;

/**
 * Emulación de vista por consola. Se muestra como un ejemplo de uso de la clase Control.
 * @author juanmanuelmartinezromero
 */
public class MainClass {
        /**
         * Ejemplo de uso de la clase Control.
         * @param args 
         */
	public static void main(final String[] args) {
		final Control c = new Control();
		c.agregarEntidades(
                        new Object[][] {
                                { new Long(1000), "Tornillo", new Double(500) }, // Agrega una Entidad Tornillo con Cantidad 1000 y precio 500
				{ new Long(10), "Pinza", new Double(5000) }, // Agrega una Entidad Pinza con Cantidad 5000 y precio 10
				{ new Long(100), "Tuerca", new Double(1200) }, // Agrega una Entidad Tornillo con Cantidad 1000 y precio 500
				{ new Long(1), "Taladro", new Double(75000) }, // Agrega una Entidad Taladro con Cantidad 1 y precio 75000
                                { new Long(2), "Taladro", new Double(0) }}); // Agrega una Entidad Taladro con Cantidad 1 y precio 75000
		for (final Entidad e : c.ordenar(Entidad.CAMPO_NOMBRE)) { // Por cada entidad en la coleccion Ordenar, imprime el orden segun el nombre del Campo
			System.out.println(e);
		}
	}

}
