package mx.com.superq.threads;

public class Tarea implements Runnable
{
    @Override
    public void run()
    {
        System.out.println("Una tarea MUY MUY MUY importante...-"+Thread.currentThread().getName());
    }
}
