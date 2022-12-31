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
            while (true){
                System.out.println("WORKING");
                Thread.sleep(10000);
            }
        }catch (Exception ex){

        }
    }
}


