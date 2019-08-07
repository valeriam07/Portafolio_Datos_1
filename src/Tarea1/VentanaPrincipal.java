package Tarea1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;


public class VentanaPrincipal extends JFrame {

    //Ventana que debe contener una tabla donde se pueda seleccionar un CSV
    // Archivo CSV: permite compartir datos de forma tabular, filas y columnas

    private VentanaPrincipal(){

        super("Tabla"); //titulo de la tabla
        DefaultTableModel modelo = new DefaultTableModel();

        JFileChooser buscador = new JFileChooser();
        buscador.showOpenDialog(buscador);

        JTable tabla = new JTable(modelo);
        JScrollPane scroll1 = new JScrollPane();
        tabla.setBounds(12,22,750,700);
        setSize(750,700);
        scroll1.setBounds(12,22,750,700);
        scroll1.setViewportView(tabla);
        add(scroll1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);

        String linea = "";


        try {

            String path = buscador.getSelectedFile().getAbsolutePath();
            File archivo = new File(path);

            FileReader lector = new FileReader(archivo);
            BufferedReader br = new BufferedReader(lector);
            int n = 0;
            int i = 0;
            int ii= 0;
            String separacion = ",";


            while (br.ready()) {

                while (!(linea = br.readLine()).equals("\000")) { // \000 es el fin del archivo

                    while (n == 0) {
                        System.out.println("Se añadio la primera columna");
                        String[] columnparts = linea.split(",");
                        while (i < columnparts.length){
                            modelo.addColumn(columnparts[i]);
                            i++;
                        }
                        n++;

                    }

                    String[] parts = linea.split(",");
                    String data = Arrays.toString(parts);
                    System.out.println("Part es: " + Arrays.toString(parts));

                    modelo.addRow(parts);

                }

            }
        } catch (Exception ex) {

        }
    }

    public static void main(String[] args) {
        VentanaPrincipal t1 = new VentanaPrincipal();
    }
}
