/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Check_in_GUI;

import console.MainConsole;
import Logic.SesionService;


public class app {
    public static void main(String[] args) {
        boolean usarGui = false;
        for (String a : args) if ("--gui".equalsIgnoreCase(a)) usarGui = true;

        SesionService service = new SesionService();
        service.cargarDatosDemo(); // datos de prueba

        if (usarGui) {
            
            GUI.show(service);
            System.out.println("funcionando");
        } else {
            MainConsole.run(service);
        }
    }
}

