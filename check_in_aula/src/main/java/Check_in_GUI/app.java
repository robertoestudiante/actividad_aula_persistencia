/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Check_in_GUI;

import console.MainConsole;
import Logic.SesionService;


public class app {
   public static void main(String[] args) {
    SesionService sesion = new SesionService(); // carga inscripciones al iniciar

    if (args.length > 0 && args[0].equals("--gui")) {
        MainGUI gui = new MainGUI(sesion);
        gui.mostrar();
    } else {
        Consola consola = new Consola(sesion);
        consola.iniciar();
    }
}
}

