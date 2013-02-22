/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.colswe.lab.junit.logica;

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
    
    public ControlTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
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
     * Test of agregarEntidad method, of class Control.
     */
    @Test
    public void testAgregarEntidad() {
        System.out.println("agregarEntidad");
        Long cantidad = null;
        String nombre = "";
        Double precioUnitario = null;
        Control instance = new Control();
        instance.agregarEntidad(cantidad, nombre, precioUnitario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarEntidades method, of class Control.
     */
    @Test
    public void testAgregarEntidades() {
        System.out.println("agregarEntidades");
        Object[][] entidades = null;
        Control instance = new Control();
        instance.agregarEntidades(entidades);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ordenar method, of class Control.
     */
    @Test
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
