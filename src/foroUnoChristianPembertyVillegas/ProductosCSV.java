package foroUnoChristianPembertyVillegas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ProductosCSV {

    // ANSI codes for colors from console
    public static final String RESET = "\u001B[0m";  // Reset Color
    public static final String ROJO = "\u001B[31m";  // Color Red
    public static final String VERDE = "\u001B[32m"; // Color Green 
    public static final String AMARILLO = "\u001B[33m"; // Color Yellow
    public static final String AZUL = "\u001B[34m"; // Color Blue
    public static final String BLANCO = "\u001B[37m"; // Color White

    // Method to create the CSV file with the product information
    public static void crearProductosCSV(String rutaArchivo) {
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            // Write header to the CSV file
            writer.write("Nombre;Categoría         ;Precio\n");

            // Enter product data for users
            writer.write("Laptop;Electrónica       ;800.50\n");
            writer.write("Nevera;Electrodomesticos ;55.75\n");
            writer.write("Libro;Papelería          ;12.30\n");
            writer.write("Silla;Muebles            ;120.00\n");

            System.out.println(VERDE + "Archivo CSV creado exitosamente." + RESET);
        } catch (IOException e) {
            System.out.println(ROJO + "Error al escribir en el archivo: " + e.getMessage() + RESET);
        }
    }

    // Method to read the CSV file and display the content with colors
    public static void leerProductosCSV(String rutaArchivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            System.out.println(AMARILLO + "Lista de Productos:" + RESET);
            System.out.println("----------------------------");

            // Read and display content line by line
            while ((linea = reader.readLine()) != null) {
                // Added different colors to each column of the CSV to make it look more visual
                String[] campos = linea.split(";");
                if (campos.length == 3) {
                    String nombre = campos[0];
                    String categoria = campos[1];
                    String precio = campos[2];

                    // Display columns with different colors
                    System.out.println(VERDE + "Nombre: " + RESET + nombre + 
                                       "\t" + AZUL + "Categoría: " + RESET + categoria + 
                                       "\t" + BLANCO + "Precio: " + RESET + precio);
                }
            }
        } catch (IOException e) {
            System.out.println(ROJO + "Error al leer el archivo: " + e.getMessage() + RESET);
        }
    }

    // Main Method
    public static void main(String[] args) {
        String rutaArchivo = "productos.csv"; // Name file CSV

        // Create file CSV
        crearProductosCSV(rutaArchivo);

        // Reader from file CSV y look the contend
        leerProductosCSV(rutaArchivo);
    }
}
