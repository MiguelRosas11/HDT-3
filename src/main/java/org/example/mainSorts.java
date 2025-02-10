package org.example;

import java.util.*;

public class mainSorts {

    public static void main(String[] args) {
        Sorts sort = new Sorts();
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(170, 45, 75, 90, 802, 24, 2, 66));

        System.out.println("Original: " + numbers);


        ArrayList<Integer> InsertionSort = new ArrayList<>(numbers);
        sort.InsertionSort(InsertionSort);
        System.out.println("insertion Sort: " + InsertionSort);

        ArrayList<Integer> mergeSort = new ArrayList<>(numbers);
        sort.mergeSort(mergeSort);
        System.out.println("merge Sort: " + mergeSort);

        ArrayList<Integer> QuickSort = new ArrayList<>(numbers);
        sort.quickSort(QuickSort, 0, QuickSort.size() - 1);
        System.out.println("Quick Sort: " + QuickSort);

        ArrayList<Integer> radixSorted = new ArrayList<>(numbers);
        sort.radixSort(radixSorted);
        System.out.println("Radix Sort: " + radixSorted);

        ArrayList<Integer> bucketSorted = new ArrayList<>(numbers);
        sort.bucketSort(bucketSorted);
        System.out.println("Bucket Sort: " + bucketSorted);

        ArrayList<Integer> heapSorted = new ArrayList<>(numbers);
        sort.heapSort(heapSorted);
        System.out.println("Heap Sort: " + heapSorted);
    }
}
