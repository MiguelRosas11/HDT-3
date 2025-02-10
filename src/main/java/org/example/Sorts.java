package org.example;
import java.util.ArrayList;
import java.util.*;
import java.util.Collections;
import java.util.List;

public class Sorts {
    public Sorts() {}

    private CSV csv;

    public void InsertionSort(ArrayList<Integer> lista) {
        for (int i = 1; i < lista.size(); i++) {
            int base = lista.get(i);
            int comparacion = i - 1;
            while (comparacion >= 0 && lista.get(comparacion) > base) {
                lista.set(comparacion + 1, lista.get(comparacion));
                comparacion--;
            }
            lista.set(comparacion + 1, base);
        }
    }

    public void mergeSort(ArrayList<Integer> lista) {
        if (lista.size() <= 1) {
            return;
        }

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
    public static void quickSort(ArrayList<Integer> lista, int inicio, int fin) {
        if (inicio < fin) {
            int pivote = lista.get(fin);
            int i = inicio - 1;

            for (int j = inicio; j < fin; j++) {
                if (lista.get(j) <= pivote) {
                    i++;
                    Collections.swap(lista, i, j);
                }
            }
            Collections.swap(lista, i + 1, fin);
            int pivoteIndex = i + 1;

            quickSort(lista, inicio, pivoteIndex - 1);
            quickSort(lista, pivoteIndex + 1, fin);
        }
    }

    public void radixSort(ArrayList<Integer> lista) {
        int max = Collections.max(lista);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(lista, exp);
        }
    }

    private void countingSort(ArrayList<Integer> lista, int exp) {
        int n = lista.size();
        int[] output = new int[n];
        int[] count = new int[10];

        for (int num : lista) {
            count[(num / exp) % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            int num = lista.get(i);
            output[count[(num / exp) % 10] - 1] = num;
            count[(num / exp) % 10]--;
        }
        for (int i = 0; i < n; i++) {
            lista.set(i, output[i]);
        }
    }

    public void bucketSort(ArrayList<Integer> lista) {
        if (lista.isEmpty()) return;

        int max = Collections.max(lista), min = Collections.min(lista);
        int bucketCount = (max - min) / lista.size() + 1;
        List<List<Integer>> buckets = new ArrayList<>(bucketCount);

        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }
        for (int num : lista) {
            buckets.get((num - min) / lista.size()).add(num);
        }
        lista.clear();
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
            lista.addAll(bucket);
        }
    }

    public void heapSort(ArrayList<Integer> lista) {
        int n = lista.size();

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(lista, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            Collections.swap(lista, 0, i);
            heapify(lista, i, 0);
        }
    }

    private void heapify(ArrayList<Integer> lista, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && lista.get(left) > lista.get(largest)) largest = left;
        if (right < n && lista.get(right) > lista.get(largest)) largest = right;
        if (largest != i) {
            Collections.swap(lista, i, largest);
            heapify(lista, n, largest);
        }
    }
}
