import java.lang.reflect.Constructor;

public class Main {
    public static void main(String[] args){
        Runnable01 R1 = new Runnable01("Thread-1");
R1.start();
        Runnable01 R2 = new Runnable01("Thread-2");
R2.start();

        LazyInitializedSingleton instanceOne = LazyInitializedSingleton.getInstance();
        LazyInitializedSingleton instanceTwo = null;
        try {
            Constructor[] constructors = LazyInitializedSingleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                // This code will destroy the singleton pattern
                constructor.setAccessible(true);
                instanceTwo = (LazyInitializedSingleton) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());

    }
}
