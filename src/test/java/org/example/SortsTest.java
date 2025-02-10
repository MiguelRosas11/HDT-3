package org.example;

import junit.framework.TestCase;
import java.util.ArrayList;
import java.util.Arrays;

public class SortsTest extends TestCase {
    private Sorts sorts;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        sorts = new Sorts();
    }

    public void testInsertionSort() {
        ArrayList<Integer> lista = new ArrayList<>(Arrays.asList(170, 45, 75, 90, 802, 24, 2, 66));
        sorts.InsertionSort(lista);
        assertEquals(Arrays.asList(2, 24, 45, 66, 75, 90, 170, 802), lista);
    }

    public void testMergeSort() {
        ArrayList<Integer> lista = new ArrayList<>(Arrays.asList(170, 45, 75, 90, 802, 24, 2, 66));
        sorts.mergeSort(lista);
        assertEquals(Arrays.asList(2,24,45,66,75,90,170,802), lista);
    }
    public void testQuickSort() {
        ArrayList<Integer> lista = new ArrayList<>(Arrays.asList(170, 45, 75, 90, 802, 24, 2, 66));
        Sorts.quickSort(lista, 0, lista.size() - 1);
        assertEquals(Arrays.asList(2, 24, 45, 66, 75, 90, 170, 802), lista);
    }

    public void testRadixSort() {
        ArrayList<Integer> lista = new ArrayList<>(Arrays.asList(170, 45, 75, 90, 802, 24, 2, 66));
        sorts.radixSort(lista);
        assertEquals(Arrays.asList(2, 24, 45, 66, 75, 90, 170, 802), lista);
    }

    public void testBucketSort() {
        ArrayList<Integer> lista = new ArrayList<>(Arrays.asList(170, 45, 75, 90, 802, 24, 2, 66));
        sorts.bucketSort(lista);
        assertEquals(Arrays.asList(2, 24, 45, 66, 75, 90, 170, 802), lista);
    }

    public void testHeapSort() {
        ArrayList<Integer> lista = new ArrayList<>(Arrays.asList(170, 45, 75, 90, 802, 24, 2, 66));
        sorts.heapSort(lista);
        assertEquals(Arrays.asList(2, 24, 45, 66, 75, 90, 170, 802), lista);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        sorts = null;
    }

}
