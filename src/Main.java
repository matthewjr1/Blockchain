import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static ArrayList<Thread> System_Threads = new ArrayList<>();
    public static Random random = new Random();
    public static void main(String[] args) {
        Start();
    }

    public static void Start(){
        try {
            Thread Network_Talk = new Thread(Networking::Net_Talk);

            System_Threads.add(Network_Talk);

            for (Thread thread1: System_Threads){
                thread1.start();
                System.out.println("Started Thread: "+ thread1);
            }
        }catch (Exception ex){

        }
    }
}


