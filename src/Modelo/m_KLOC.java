/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.v_principal;

/**
 * Clase con los métodos GET y SET para KLOC y LDC.
 *
 * @author Cecivel Solano
 * @author Raúl Romero
 * @version 1.0.0
 * @since COCOMO1 1.0.0
 */
public class m_KLOC {

    double KLOC;
    int LDC;
/**
 * Método SET de KLOC
 * @param KLOC Kilo Líneas de Código
 * @since COCOMO1 1.0.0
 */
    public void setKLOC(double KLOC) {
        this.KLOC = KLOC;
    }
/**
 * Método GET de KLOC
 * @return Valor de KLOC
 * @since COCOMO1 1.0.0
 */
    public double getKLOC() {
        return KLOC;
    }
/**
 * Método GET de LDC
 * @return Valor de LDC
 * @since COCOMO1 1.0.0
 */
    public int getLDC() {
        return LDC;
    }
/**
 * Método SET de LDC
 * @param LDC Líneas De Código
 * @since COCOMO1 1.0.0
 */
    public void setLDC(int LDC) {
        this.LDC = LDC;
    }

}
