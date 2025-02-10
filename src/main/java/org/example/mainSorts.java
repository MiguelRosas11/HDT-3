package org.example;
import java.util.Scanner;
import java.util.*;

public class mainSorts {

    public static void main(String[] args) {
        String file = "numeros.csv";
        Sorts sort = new Sorts();
        CSV csv = new CSV(file);
        Scanner sc = new Scanner(System.in);
        int menu = 0;
        while (menu < 1) {
            System.out.println("1. Insertion sort \n2. MergeSort \n3. QuickSort \n4. RadixSort \n5. BucketSort \n6. HeapSort \n7. Desordenar csv \n8. Terminar ejecución.");
            int opc = sc.nextInt();
            sc.nextLine();
            if (opc == 1) {
                sort.InsertionSort(csv.getLista());
                csv.escribirCSV();
            }
            else if(opc == 2){
                sort.mergeSort(csv.getLista());
                csv.escribirCSV();
            }
            else if(opc == 3){
                sort.quickSort(csv.getLista(), 0, csv.getLista().size() - 1);
                csv.escribirCSV();

            }
            else if(opc == 4){
                sort.radixSort(csv.getLista());
                csv.escribirCSV();

            }
            else if(opc == 5){
                sort.bucketSort(csv.getLista());
                csv.escribirCSV();

            }
            else if(opc == 6){
                sort.heapSort(csv.getLista());
                csv.escribirCSV();

            }
            else if(opc == 7){
                csv.Sobreescribir_CSV();
            }
            else if (opc == 8) {
                menu = menu + 1;
            }
            else{
                System.out.println("ingrese una opción válida");
            }
        }
    }
}