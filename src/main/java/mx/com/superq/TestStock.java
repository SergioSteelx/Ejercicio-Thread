package mx.com.superq;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TestStock {
    public static void main(String args[]) {
        Long inicio = System.nanoTime();

        String Compañia = "AMZN";
        BigDecimal total = new BigDecimal(0.0);


        try {

            //StockRetriever stockRetriever = new StockRetriever(Compañia);
            //BigDecimal precio = stockRetriever.getStockPrice();
            //System.out.println("el precio de las acciones de " + Compañia + " es : " + precio);

            String filename = "C:/Users/sergio/IdeaProjects/Ejercicio threrad/src/main/resources/List.txt";

            List<String> lineas = Files.readAllLines(Paths.get(filename));

            for (String x:lineas)
            {
                StockRetriever stockRetriever = new StockRetriever(x);

                BigDecimal precio = stockRetriever.getStockPrice();

                System.out.println("\nEl precio de las acciones de " + x + " es : " + precio);

                total = total.add(precio);


            }
            System.out.println("\n\nLa suma de los precios es: "+total);
        } catch (IOException e) {
            System.out.println(e);
            //4915 6654 9021 9702
        }
        Long fin = System.nanoTime();
        double resultado = (fin - inicio) / 1000000000.0;

        System.out.println("\nTiempo Inicial = " + inicio/ 1000000000.0 + " Segundos");
        System.out.println("\nTiempo Final = " + fin/ 1000000000.0 + " Segundos");
        System.out.println("\n-----------------------------------------");
        System.out.println("\nTiempo Total = " + resultado + " Segundos");


    }
}