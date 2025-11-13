package edu.cerp.checkin.persistencia;

import edu.cerp.checkin.model.Inscripcion;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArchivoManager {

    private static final String RUTA = "data/inscripciones.csv";

    // Guardar una inscripción
    public void guardarInscripcion(Inscripcion inscripcion) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA, true))) {
            bw.write(inscripcion.getNombre() + "|" + inscripcion.getCurso() + "|" + inscripcion.getFecha());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    // Leer todas las inscripciones
    public List<Inscripcion> cargarInscripciones() {
        List<Inscripcion> lista = new ArrayList<>();
        File archivo = new File(RUTA);
        if (!archivo.exists()) return lista;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("\\|");
                if (partes.length == 3) {
                    lista.add(new Inscripcion(partes[0], partes[1], partes[2]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer: " + e.getMessage());
        }
        return lista;
    }
}
