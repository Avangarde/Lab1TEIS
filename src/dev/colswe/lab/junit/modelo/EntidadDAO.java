package dev.colswe.lab.junit.modelo;

import java.util.Collection;

public class EntidadDAO {

	private final Sistema sistema = Sistema.getInstance();

	public Collection<Entidad> listarEntidades() {
		return sistema.getEntidades();
	}

	public void setEntidades(final Collection<Entidad> entidades) {
		sistema.setEntidades(entidades);
	}

	public void agregarEntidad(final Entidad entidad) {
		sistema.getEntidades().add(entidad);
	}

}
