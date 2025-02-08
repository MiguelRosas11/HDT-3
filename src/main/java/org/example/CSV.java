package org.example;

import java.util.ArrayList;
import java.util.Random;

public class CSV {

    public static ArrayList<Integer> ListaNumeros(){
        ArrayList<Integer> numeros = new ArrayList<Integer>();
        Random random = new Random();
        for (int i = 0; i < 3000; i++) {
            int numeroAleatorio = random.nextInt(10000);
            numeros.add(numeroAleatorio);
        }
        return numeros;

    }
}
