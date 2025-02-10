package org.example;

import java.util.ArrayList;

public class Sorts {
    private CSV csv;

    public void InsertionSort(ArrayList<Integer> lista){
        csv.Sobreescribir_CSV();
        for (int i = 1; i < lista.size(); i++) {
            int base = lista.get(i);
            int comparacion = i - 1;
            while(comparacion >= 0 && lista.get(comparacion) > base){
                lista.set(comparacion + 1, lista.get(comparacion));
                comparacion--;
            }
            lista.set(comparacion + 1, base);
        }
    }
}
