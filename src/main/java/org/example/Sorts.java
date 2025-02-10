package org.example;

import java.util.*;
import java.util.Collections;

public class Sorts {
    public Sorts(){}
    private CSV csv;

    public void InsertionSort(ArrayList<Integer> lista){
        for (int i = 0; i < lista.size(); i++) {


        }
    }

    public void radixSort(ArrayList<Integer> lista){
        int max = Collections.max(lista);
        for(int exp =1 ; max/exp >0; exp*=10 ){
            countingSort(lista, exp);
        }
    }

    private static void countingSort(ArrayList<Integer> lista, int exp){
        int n = lista.size();
        int[] output = new int[n];
        int[] count = new int[10];

        for (int num: lista) count[(num /exp) %10]++;
        for(int i = 1; i < 10; i++) count[i] += count[i-1];
        for(int i = n-1; i >= 0; i--){
            int num = lista.get(i);
            output[count[(num / exp) %10] -1]= num;
            count[(num / exp) %10]--;
        }
        for (int i=0; i<n ; i++)lista.set(i, output[i]);
    }

    public void bucketSort(ArrayList<Integer> lista){
        if (lista.isEmpty())return;;

        int max = Collections.max(lista), min = Collections.min(lista);
        int bucketCount = (max - min) / lista.size() + 1;
        List<List<Integer>> buckets = new ArrayList<>(bucketCount);

        for (int i = 0; i < bucketCount; i++) buckets.add(new ArrayList<>());
        for (int num: lista) buckets.get((num -min)/lista.size()).add(num);
        lista.clear();
        for (List<Integer> bucket: buckets) {
            Collections.sort(bucket);
            lista.addAll(bucket);
        }
    }

    public void heapSort(ArrayList<Integer> lista){
        int n = lista.size();

        for (int i= n/2 -1; i>=0; i--){
            heapfy(lista, n, i);
        }

        for (int i = n-1; i > 0; i--){
            Collections.swap(lista, 0, i);

            heapfy(lista, i, 0);
        }
    }

    private static void heapfy(ArrayList<Integer> lista, int n, int i){
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && lista.get(left) > lista.get(largest)) largest = left;
        if (right < n && lista.get(right) > lista.get(largest)) largest = right;
        if (largest != i) {
            Collections.swap(lista, i, largest);
            heapfy(lista, n, largest);
        }
    }

}
