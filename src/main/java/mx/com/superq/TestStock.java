package mx.com.superq;



import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TestStock
{
    public static BigDecimal total = new BigDecimal(0.0);
    public static void main(String args[]) {
        Long inicio = System.nanoTime();

        String Compañia = "AMZN";

        BigDecimal precio = new BigDecimal(0.0);

            try {

                //StockRetriever stockRetriever = new StockRetriever(Compañia);
                //BigDecimal precio = stockRetriever.getStockPrice();
                //System.out.println("el precio de las acciones de " + Compañia + " es : " + precio);

                String filename = "C:/Users/sergio/IdeaProjects/Ejercicio threrad/src/main/resources/List.txt";

                List<String> lineas = Files.readAllLines(Paths.get(filename));
                //Thread j = new Thread();
                //System.out.println(j.getName()+" "+j.toString());
                for (String x : lineas) {
                    StockRetriever stockRetriever = new StockRetriever(x);

                    //precio = stockRetriever.getStockPrice();

                    //j = new Thread(stockRetriever, j.getName());
                    new Thread(stockRetriever, "").start();
                    //j
                    //System.out.println(j.getName()+" "+j.toString());
                    //total = total.add(precio);


                }

                /*synchronized(j)
                {
                    j.wait();*/
                    System.out.println("\n\nLa suma de los precios es: " + total);
                    Long fin = System.nanoTime();
                    double resultado = (fin - inicio) / 1000000000.0;

                    System.out.println("\nTiempo Inicial = " + inicio / 1000000000.0 + " Segundos");
                    System.out.println("\nTiempo Final = " + fin / 1000000000.0 + " Segundos");
                    System.out.println("\n-----------------------------------------");
                    System.out.println("\nTiempo Total = " + resultado + " Segundos");
               // }

            } catch (IOException e) {
                System.out.println(e);
                //4915 6654 9021 9702
            } /*catch (InterruptedException e) {
            }*/




    }

}