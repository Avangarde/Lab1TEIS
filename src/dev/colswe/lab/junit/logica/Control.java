package dev.colswe.lab.junit.logica;

import dev.colswe.lab.junit.modelo.Entidad;
import dev.colswe.lab.junit.modelo.EntidadDAO;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;

public class Control {

	private final static EntidadDAO DAO;

	static {
		DAO = new EntidadDAO();
	}

	public void agregarEntidad(final Long cantidad, final String nombre, final Double precioUnitario) {
		if (DAO.listarEntidades() == null) {
			DAO.setEntidades(new ArrayList<Entidad>());
		}
		DAO.agregarEntidad(new Entidad(cantidad, nombre, precioUnitario));
	}

	public void agregarEntidades(final Object[][] entidades) {
		for (final Object[] entidad : entidades) {
			agregarEntidad((Long) entidad[0], (String) entidad[1], (Double) entidad[2]);
		}
	}

	public Collection<Entidad> ordenar(final String nombreCampo) {
		final Collection<Entidad> tmp = new TreeSet<Entidad>(
                        new Comparator<Entidad>() {

                            @Override
                            public int compare(final Entidad o1, final Entidad o2) {
                                    int ret = 0;
                                    try {
                                        System.out.println("get" + nombreCampo.substring(0, 1).toUpperCase() + nombreCampo.substring(1));
                                            final Method method = Entidad.class.getMethod("get" + nombreCampo.substring(0, 1).toUpperCase() + nombreCampo.substring(1));
                                            final Object val1 = method.invoke(o1);
                                            final Object val2 = method.invoke(o2);
                                            if (val1 instanceof Long) {
                                                    ret = ((Long) val1).compareTo((Long) val2);
                                            } else if (val1 instanceof Double) {
                                                    ret = ((Double) val1).compareTo((Double) val2);
                                            } else if (val1 instanceof String) {
                                                    ret = ((String) val1).compareTo((String) val2);
                                            }
                                    } catch (final Exception e) {
                                            e.printStackTrace();
                                    }
                                    return ret;
                            }
                       }
                );
		tmp.addAll(DAO.listarEntidades());
		return tmp;
	}

}
