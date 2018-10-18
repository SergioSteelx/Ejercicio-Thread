package mx.com.superq.threads;

public class ThreadMain
{
    public static void main(String[] args)
    {
        Tarea tarea = new Tarea();

        System.out.println(Thread.currentThread().getName());
        tarea.run();
        for(int i = 0; i <= 100; i++)
        {
            new Thread(tarea, String.valueOf(i)).start();
        }

    }

}
