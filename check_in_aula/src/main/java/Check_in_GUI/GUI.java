/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Check_in_GUI;
import Logic.SesionService;
import model.Inscripcion;

import javax.swing.table.DefaultTableModel;

import javax.swing.*;
import java.awt.*;
import java.util.List;



/**
 * Interfaz gráfica mínima para el Check-in Aula.
 * Permite registrar inscripciones y ver la lista actual.
 */
public class GUI {

    public static void show(SesionService service) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Check-in Aula (GUI)");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);
            frame.setLocationRelativeTo(null);

            // Panel principal
            JPanel panel = new JPanel(new BorderLayout(10, 10));
            panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            // --- Formulario de registro ---
            JPanel form = new JPanel(new GridLayout(4, 2, 5, 5));
            JTextField nombreField = new JTextField();
            JTextField documentoField = new JTextField();
            JComboBox<String> cursoBox = new JComboBox<>(new String[]{"Prog 1", "Prog 2", "Base de Datos"});
            JButton registrarBtn = new JButton("Registrar");

            form.add(new JLabel("Nombre:"));
            form.add(nombreField);
            form.add(new JLabel("Documento:"));
            form.add(documentoField);
            form.add(new JLabel("Curso:"));
            form.add(cursoBox);
            form.add(new JLabel(""));
            form.add(registrarBtn);

            // --- Tabla de inscripciones ---
            String[] columnas = {"Nombre", "Documento", "Curso", "Hora"};
            DefaultTableModel model = new DefaultTableModel(columnas, 0);
            JTable tabla = new JTable(model);
            JScrollPane scroll = new JScrollPane(tabla);

            // Cargar datos iniciales
            actualizarTabla(model, service.listar());

            registrarBtn.addActionListener(e -> {
                String nombre = nombreField.getText();
                String documento = documentoField.getText();
                String curso = (String) cursoBox.getSelectedItem();
                service.registrar(nombre, documento, curso);
                actualizarTabla(model, service.listar());
                nombreField.setText("");
                documentoField.setText("");
            });

            panel.add(form, BorderLayout.NORTH);
            panel.add(scroll, BorderLayout.CENTER);

            frame.add(panel);
            frame.setVisible(true);
        });
    }

    private static void actualizarTabla(DefaultTableModel model, List<Inscripcion> inscripciones) {
        model.setRowCount(0);
        for (Inscripcion i : inscripciones) {
            model.addRow(new Object[]{
                    i.getNombre(),
                    i.getDocumento(),
                    i.getCurso(),
                    i.getFechaHora().toString()
            });
        }
    }
}