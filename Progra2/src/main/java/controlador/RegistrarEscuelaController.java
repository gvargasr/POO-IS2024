/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this
 * license Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import vista.RegistrarEscuela;

/**
 *
 * Clase para controlar el metodo Registrar escuela y enlazarlo con la interfaz grafica
 * @author gvargasr
 */
public class RegistrarEscuelaController {

  public static RegistrarEscuela ventana = new RegistrarEscuela();

  public static void mostrar() {
    ventana.setVisible(true);
  }

  public static void ocultar() {
    ventana.dispose();
  }

  public static void eventoBotonRegistrarEscuela() {
    String nombre = ventana.getNombre();
    String codigo = ventana.getCodigo();
    VistaPrincipalController.modelo.registrarEscuela(nombre, codigo);
  }

  public static void eventoBotonLimpiar() {
    ventana.limpiarEspacios();
  }



}
