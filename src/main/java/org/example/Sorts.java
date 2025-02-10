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

    public void mergeSort(ArrayList<Integer> lista){
        csv.Sobreescribir_CSV();
        int medio = lista.size() / 2;
        ArrayList<Integer> izquierda = new ArrayList<>(lista.subList(0, medio));
        ArrayList<Integer> derecha = new ArrayList<>(lista.subList(medio, lista.size()));

        mergeSort(izquierda);
        mergeSort(derecha);

        lista.clear();
        int i = 0, j = 0;
        while (i < izquierda.size() && j < derecha.size()) {
            if (izquierda.get(i) <= derecha.get(j)) {
                lista.add(izquierda.get(i));
                i++;
            } else {
                lista.add(derecha.get(j));
                j++;
            }
        }
        while (i < izquierda.size()) {
            lista.add(izquierda.get(i));
            i++;
        }
        while (j < derecha.size()) {
            lista.add(derecha.get(j));
            j++;
        }
    }

}
