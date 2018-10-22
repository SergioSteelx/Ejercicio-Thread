package mx.com.superq;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestStock
{
    private static volatile BigDecimal total = new BigDecimal(0.0);
    public static void main(String args[])
    {
        Long inicio = System.nanoTime();
        String filename = "C:/Users/sergio/IdeaProjects/Ejercicio threrad/src/main/resources/List.txt";
        try
        {
            int cores = Runtime.getRuntime().availableProcessors();
            double blokingCoefficeient = 0.9;
            int poolSize =(int)(cores / (1 - blokingCoefficeient));

            System.out.println("Cores: " + cores);
            System.out.println("PoolSize: " + poolSize);
            //System.out.println("Cores: " + cores);

            List<String> lineas = Files.readAllLines(Paths.get(filename));
            Collection<Callable<Object>> tareas = new ArrayList<>();
            for (String linea : lineas)
            {
                StockRetriever stockRetriever = new StockRetriever(linea.trim());
                tareas.add(Executors.callable(stockRetriever));
            }
            ExecutorService threadpool = Executors.newFixedThreadPool(poolSize);
            threadpool.invokeAll(tareas);
            threadpool.shutdown();

            System.out.println("\n\nLa suma de los precios es: " + total);

            Long fin = System.nanoTime();

            double resultado = (fin - inicio) / 1000000000.0;

            System.out.println("\nTiempo Inicial = " + inicio / 1000000000.0 + " Segundos");
            System.out.println("\nTiempo Final = " + fin / 1000000000.0 + " Segundos");
            System.out.println("\n-----------------------------------------");
            System.out.println("\nTiempo Total = " + resultado + " Segundos");

        }
        catch(IOException e)
        {
            System.out.println("Error al sacar nombres de la lista");
        }
        catch (InterruptedException e)
        {
            System.out.println("se interrumpio la ejecucion de los hilos");
        }
        //implementacion de un pool de treads

    }


    public static synchronized void addprice(BigDecimal precio)
    {
        total = total.add(precio);
    }


/*
    public static void main2(String args[]) {
        try {
            String filename = "C:/Users/sergio/IdeaProjects/Ejercicio threrad/src/main/resources/List.txt";


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
                    j.wait();

            // }

        } catch (IOException e) {
            System.out.println(e);
            //4915 6654 9021 9702
        }
    }*/

}