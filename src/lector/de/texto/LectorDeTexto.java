package lector.de.texto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class LectorDeTexto {

    public static void main(String[] args) {
        int opcion;
        String ruta;
        JTextArea salida = new JTextArea();
        //Definir el nombre del file de texto a modificar
//        do {
//            nombre = JOptionPane.showInputDialog("Ingrese el nombre del file");
//        } while (nombre == null || nombre.isEmpty());
        ruta = "/home/rafael/prueba.txt";

        //Menu principal
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Bienvenido a su programa de lectura de files\nQue desea hacer hoy\n1 - Leer la DB\n2 - Escribir en la DB\n3 - Borrar la DB\nLa ruta de su file es:\n" + ruta));
            File file = new File(ruta);

            switch (opcion) {
                //Leer un file
                case 1:
                    String linea,
                     retornar = "";
                    try {
                        FileReader readFile = new FileReader(file);
                        BufferedReader buffer = new BufferedReader(readFile);
                        while ((linea = buffer.readLine()) != null) {
                            retornar += linea + "\n";
                        }
                        buffer.close();
                        salida.setText(retornar);
                        JOptionPane.showMessageDialog(null, salida);
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, "Se ha producido un error:\n" + e.getMessage());
                    }
                    break;
                //Escribir en un file
                case 2:
                    try {
                    FileWriter writeFile = new FileWriter(file, true);
                    BufferedWriter buffer = new BufferedWriter(writeFile);
                    buffer.write(JOptionPane.showInputDialog("Ingrese la linea de texto a agregar"));
                    buffer.newLine();
                    buffer.close();
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Se ha producido un error:\n" + e.getMessage());
                }
                break;
                //borrar todo el file de texto
                case 3:
                    try {
                    BufferedWriter buffer = new BufferedWriter(new FileWriter(ruta));
                    buffer.write("");
                    buffer.close();
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Se ha producido un error:\n" + e.getMessage());
                }
                break;
                default:

                    break;

            }

        } while (opcion >= 1 && opcion <= 3);
    }

}
