package Controlador;

import Vista.v_principal;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Clase encargada de validar y leer los archivos seleccionados.
 *
 * @author Cecivel Solano
 * @author Raúl Romero
 * @version 1.0.0
 * @since COCOMO1 1.0.0
 */
public class c_archivo {

    int numCodigo = 0, numComent = 0, numBlanco = 0;
    BufferedReader bufer;

    public static v_principal objPrincipal;

    /**
     * Este método valida que el archivo selccionado sea compatible (.java),
     * para posteriormente realizar un correcto conteo de líneas.
     *
     * @param archivo
     * @return Valor boolean
     * @since COCOMO1 1.0.0
     */
    public static boolean formato(File archivo) {
        boolean bool = false;
        if (archivo.getName().endsWith("java")) {       //formatos soportados
            bool = true;
        } else {
            bool = false;
            JOptionPane.showMessageDialog(null, "Formato de Archivo No Soportado.\nSeleccione un archivo .java");
        }
        return bool;
    }

    /**
     * Carga el archivo al buffer para leerlo línea por línea.
     *
     * @param archivo Recibe el archivo que anteriormente fue seleccionado
     * @since COCOMO1 1.0.0
     */
    public void leer(File archivo) {
        try {
            FileReader entrada = new FileReader(archivo);      //obtener los caracteres del archivo y guardarlo en una variable
            bufer = new BufferedReader(entrada); //cargar en memoria el contenido del archivo

            int numLineasCodigo = contarLineas();            //contar las lineas de codigo, comentario y en blanco
            // devuelve solo las líneas de código
            if (numLineasCodigo < 1000) {         //
                JOptionPane.showMessageDialog(null, "Tenga en cuenta que este archivo tiene menos de 1000 líneas de código", "Importante", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha podido leer el archivo.\nError: " + e);
        }
    }

    /**
     * Método para contar y separar las líneas, tanto de Código, Comentarios y
     * en Blanco.
     *
     * @return Un entero con el valor de LDC
     * @since COCOMO1 1.0.0
     */
    public int contarLineas() {

        String linea;
        try {
            while ((linea = bufer.readLine()) != null) {     //leer linea por linea hasta que terminarlas todas
                linea = linea.trim();           //elimina espacios a la izquierda y derecha de la linea
                //   System.out.println(linea);
                if (linea.length() == 0) {      //si la linea tiene una longitud de cero, entonces está en blanco
                    numBlanco++;                //incremento de contador de lineas en blanco
                    //  System.out.println("es una linea blanca");
                } else if (linea.length() >= 2 && linea.substring(0, 2).equals("/*")) {    //comprueba que la linea tenga al menos dos caracteres
                    //para poder comprobar si contiene el substring "\*"

                    numComent++;                                //incremento de contador de lineas en comentario
                    //System.out.println("es un comentario");
                    //continue;       //continua con el siguiente ciclo, es decir, lee la siguiente linea
                    try {
                        while ((linea = bufer.readLine()) != null) {         //inicia otro bucle para leer lineas de comentarios por bloques
                            linea = linea.trim();           //elimina espacios a la izquierda y derecha de la linea
                            //        System.out.println(linea);
                            if (linea.length() == 0) {       //si la linea tiene una longitud de cero, entonces está en blanco
                                numBlanco++;            //incremento de contador de lineas en blanco
                                // System.out.println("es una linea blanca");
                            } else if (linea.length() >= 2 && linea.substring(0, 2).equals("*/")) {       //si no es linea en blanco entonces valida si es el fin del
                                //comentario en bloque
                                numComent++;                         //incremento de contador de lineas en comentario
                                //System.out.println("es un comentario");
                                break;      //al encontrar el fin del comentario de bloque entonces termina este bucle para continuar con el anterior bucle
                            } else {
                                numComent++;        //incremento de contador de lineas en comentario
                                //System.out.println("es un comentario");
                            }
                        }
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "No se ha podido leer el archivo.\nError: " + ex);
                    }
                } else if (linea.substring(0, 1).equals("/") || linea.substring(0, 1).equals("*")) {  //si no es linea en blanco entonces valida si es un comentario de linea
                    numComent++;        //incremento de contador de lineas en comentario
                    //System.out.println("es un comentario");
                } else {      // si no es linea en blanco ni comentario entonces es linea de codigo
                    numCodigo++;        //incremento de contador de lineas de codigo
                    // System.out.println("es codigo");
                }

            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "No se ha podido leer el archivo.\nError: " + ex);
        }

        return numCodigo;
    }

    /**
     * Método GET de las Líneas de Código encontradas
     *
     * @return Un entero con el número de LDC
     * @since COCOMO1 1.0.0
     */
    public int getNumCodigo() {
        return numCodigo;
    }

    /**
     * Método GET de las Líneas de Comentarios encontradas
     *
     * @return Un entero con el número de comentarios
     * @since COCOMO1 1.0.0
     */
    public int getNumComent() {
        return numComent;
    }

    /**
     * Método GET de las Líneas en Blanco encontradas
     *
     * @return Un entero con el número de líneas en blanco
     * @since COCOMO1 1.0.0
     */
    public int getNumBlanco() {
        return numBlanco;
    }

} //fin clase
