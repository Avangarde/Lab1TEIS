package dev.colswe.lab.junit.vista;

import dev.colswe.lab.junit.logica.Control;
import dev.colswe.lab.junit.modelo.Entidad;

public class MainClass {

	public static void main(final String[] args) {
		final Control c = new Control();
		c.agregarEntidades(new Object[][] { { new Long(1000), "Tornillo", new Double(500) }, //
				{ new Long(10), "Pinza", new Double(5000) }, //
				{ new Long(100), "Tuerca", new Double(1200) }, //
				{ new Long(1), "Taladro", new Double(75000) } });
		for (final Entidad e : c.ordenar(Entidad.CAMPO_NOMBRE)) {
			System.out.println(e);
		}
	}

}
