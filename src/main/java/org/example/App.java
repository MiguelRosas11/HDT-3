package org.example;


public class App 
{
    public static void main( String[] args )
    {
        String file = "numeros.csv";
        CSV archivo = new CSV(file);
        for (int i = 0; i < 10; i++) {
            System.out.println(archivo.getLista().get(i));

        }

    }
}

