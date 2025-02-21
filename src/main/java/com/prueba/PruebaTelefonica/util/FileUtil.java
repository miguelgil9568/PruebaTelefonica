package com.prueba.PruebaTelefonica.util;

import java.io.*;

public class FileUtil {

    private static final String FILE_PATH = "operaciones.txt";

    public static void guardarEnArchivo(long id, String operacion, String datosAlfanumericos, double resultado) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(id + "," + operacion + "," + datosAlfanumericos + "," + resultado +"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String obtenerOperacion(long id) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (Long.parseLong(parts[0]) == id) {
                    return "Operacion: " + parts[1] +" = "+ parts[3] +" , Mensaje: " + parts[2];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Operación no encontrada";
    }
}