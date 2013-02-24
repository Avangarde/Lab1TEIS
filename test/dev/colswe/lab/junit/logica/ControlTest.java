/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.colswe.lab.junit.logica;

import dev.colswe.lab.junit.modelo.Entidad;
import dev.colswe.lab.junit.modelo.EntidadDAO;
import dev.colswe.lab.junit.modelo.Sistema;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author juanmanuelmartinezromero
 */
public class ControlTest {

    private static final Control CONTROL = new Control();
    private static final Sistema SISTEMA = Sistema.getInstance();
    private static final EntidadDAO ENTIDAD_DAO = new EntidadDAO();
    private static final ArrayList<Entidad> ARREGLO_VACIO = new ArrayList<Entidad>();
    private static final ArrayList<Entidad> ARREGLO_NO_VACIO = new ArrayList<Entidad>();

    public ControlTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        ARREGLO_NO_VACIO.add(new Entidad(new Long(1000), "Tornillo", new Double(1000)));
        ARREGLO_NO_VACIO.add(new Entidad(new Long(10), "Pinza", new Double(5000)));
        ARREGLO_NO_VACIO.add(new Entidad(new Long(100), "Tuerca", new Double(1200)));
        ARREGLO_NO_VACIO.add(new Entidad(new Long(1), "Taladro", new Double(75000)));
        ARREGLO_NO_VACIO.add(new Entidad(new Long(2), "Taladro", new Double(0)));
        SISTEMA.setEntidades(ARREGLO_NO_VACIO);
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     */
    @Test
    public void testAgregarEntidad() {
        //Prueba para identificar si agrega un elemento normalmente.
        Long cantidad = new Long(3);
        String nombre = "Llave de tubo";
        Double precioUnitario = new Double(30000);
        int tamAnterior = SISTEMA.getEntidades().size();
        CONTROL.agregarEntidad(cantidad, nombre, precioUnitario);
        int tamSiguiente = SISTEMA.getEntidades().size();
        assertEquals(tamAnterior + 1, tamSiguiente);


    }

    @Test
    public void testNoAgregarEntidad() {
        String nombre = "Alicates";
        int tamAnterior = SISTEMA.getEntidades().size();
        try {
            CONTROL.agregarEntidad(new Long(3000), nombre, new Double(nombre));
        } catch (NumberFormatException numberFormatException) {
            System.out.println("Ha ocurrido un numberFormatException");
        } finally {
            int tamSiguiente = SISTEMA.getEntidades().size();
            assertEquals(tamAnterior, tamSiguiente);
        }

    }

    /**
     * Test of agregarEntidades method, of class Control.
     */
    @Test
    public void testAgregarEntidades() {
        Object[][] entidades = new Object[][]{
            {new Long(2000), "Tuercas", new Double(250)}, // Agrega una Entidad Tornillo con Cantidad 1000 y precio 500
            {new Long(100), "Llave 14", new Double(2550)}, // Agrega una Entidad Pinza con Cantidad 5000 y precio 10
            {new Long(100), "Tuerca", new Double(1200)}, // Agrega una Entidad Tornillo con Cantidad 1000 y precio 500
            {new Long(1), "Taladro", new Double(75000)}, // Agrega una Entidad Taladro con Cantidad 1 y precio 75000
            {new Long(2), "Taladro", new Double(0)}};
        int tamAnterior = SISTEMA.getEntidades().size();
        CONTROL.agregarEntidades(entidades);
        int tamSiguiente = SISTEMA.getEntidades().size();
        assertEquals(tamAnterior + entidades.length, tamSiguiente);
    }

    @Test
    public void testNoAgregarTodasEntidades() {
        Object[][] entidades = new Object[4][4];

        entidades[0][0] = new Long(2000);
        entidades[0][1] = "Tuercas";
        entidades[0][2] = new Double(250);

        try {
            entidades[1][0] = new Long(100);
            entidades[1][1] = "Llave 14";
            entidades[1][2] = new Double("Llave 14");
        } catch (NumberFormatException numberFormatException) {
            System.out.println("Ha ocurrido una o varias excepciones de NullPointerException");
        }

        entidades[2][0] = new Long(100);
        entidades[2][1] = "Tuerca";
        entidades[2][2] = new Double(1200);

        try {
            entidades[3][0] = new Long(2);
            entidades[3][1] = "Taladro";
            entidades[3][2] = new Double("Taladro");
        } catch (NumberFormatException numberFormatException) {
            System.out.println("Ha ocurrido una o varias excepciones de NullPointerException");
        }

        int tamAnterior = SISTEMA.getEntidades().size();
        CONTROL.agregarEntidades(entidades);
        int tamSiguiente = SISTEMA.getEntidades().size();
        assertEquals(tamAnterior + entidades.length, tamSiguiente);
    }

    /**
     * Test of ordenar method, of class Control.
     */
    //@Test
    public void testOrdenar() {
        System.out.println("ordenar");
        String nombreCampo = "";
        Control instance = new Control();
        Collection expResult = null;
        Collection result = instance.ordenar(nombreCampo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
