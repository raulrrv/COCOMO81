/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestMetodos;

import Vista.v_principal;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Clase dedicada para realizar los Test.
 * 
 * @author Cecivel Solano
 * @author Raúl Romero
 * @version 1.0.0
 * @since COCOMO1 1.0.0
 */
public class Test_LDC {
 
    /**
     * Test del método "ValidaTotalLDC" que comprueba si el total de líneas de código es mayor a 1000.
     * En caso positivo.
     * @since COCOMO1 1.0.0
     */
    @Test
    public void TestValidarTotalLDC(){
       boolean bool = v_principal.validarTotalLDC(2000);
       assertEquals("El total de Líneas de Código es muy bajo.",true, bool);
    }
    
      /**
     * Test del método "ValidaTotalLDC" que comprueba si el total de líneas de código es mayor a 1000.
     * En caso negativo.
     * @since COCOMO1 1.0.0
     */
    @Test
    public void TestValidarTotalLDC2(){
       boolean bool = v_principal.validarTotalLDC(800);
       assertEquals("El total de Líneas de Código es muy bajo.",true, bool);
    }
 
}
