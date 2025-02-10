package org.example;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class CSV {
    private String file;
    private ArrayList<Integer> lista;

    public CSV(String file){
        this.file = file;
        if(!Existe()) {
            this.lista = ListaNumeros();
            escribirCSV();
        }
        else{
            this.lista = leerCSV();
        }
    }
    private boolean Existe(){
        return new File(file).exists();
    }

    public ArrayList<Integer> ListaNumeros(){
        ArrayList<Integer> numeros = new ArrayList<Integer>();
        Random random = new Random();
        for (int i = 0; i < 3000; i++) {
            int numeroAleatorio = random.nextInt(10000);
            numeros.add(numeroAleatorio);
        }
        return numeros;

    }

    public void escribirCSV(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Integer numero : this.lista) {
                writer.write(numero.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo CSV: " + e.getMessage());
        }

    }

    public ArrayList<Integer> getLista() {
        return lista;
    }

    public ArrayList<Integer> leerCSV() {
        ArrayList<Integer> numeros = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                numeros.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo CSV: " + e.getMessage());
        }
        return numeros;
    }
}
