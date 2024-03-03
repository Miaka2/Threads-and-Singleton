import java.util.Random;

public class Runnable01 implements Runnable{
    private Thread t;
    private String threadName;

    private Random random;

    Runnable01(String name){
        threadName = name;
        random = new Random();
        System.out.println("Creating "+ threadName);
    }
    public void run(){
        System.out.println("Running "+ threadName);
        try{
            for(int i = 10; i > 0; i--){
               System.out.println("Thread " + threadName + ", "+ i);
               Thread.sleep(this.random.nextInt(50)+10);
            }
        } catch (InterruptedException e){
            System.out.println("Thread "+ threadName + " interrupted.");
        }
        System.out.println("Thread "+ threadName + " exiting.");
    }

    public void start (){
        System.out.println("Starting " + threadName);
        if(t == null){
            t = new Thread(this,threadName);
            t.start();
        }
    }
}
