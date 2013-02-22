package dev.colswe.lab.junit.modelo;

import java.util.Collection;

public class Sistema {

	private Collection<Entidad> entidades;
	private static Sistema instance;

	private Sistema() {
	}

	public static Sistema getInstance() {
		if (instance == null) {
			instance = new Sistema();
		}
		return instance;
	}

	public Collection<Entidad> getEntidades() {
		return entidades;
	}

	public void setEntidades(final Collection<Entidad> entidades) {
		this.entidades = entidades;
	}

}
