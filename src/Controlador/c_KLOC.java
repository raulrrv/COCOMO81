/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.v_principal;

/**
 * Clase encargada de realizar operaciones con las KLOC.
 *
 * @author Cecivel Solano
 * @author Raúl Romero
 * @version 1.0.0
 * @since COCOMO1 1.0.0
 */
public class c_KLOC {

    int LDC;

    /**
     * Método para sumar las Líneas de Código encontradas en cada archivo leído.
     *
     * @param numCodigo Número de líneas de código de cada archivo
     * @since COCOMO1 1.0.0
     */
    public void SumatoriaLDC(int numCodigo) {
        LDC = v_principal.objM_KLOC.getLDC() + numCodigo;
        v_principal.objM_KLOC.setLDC(LDC);
    }

}
