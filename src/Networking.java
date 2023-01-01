import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Networking {


    public static void Net_Talk(){
        try {
            ServerSocket serverSocket = new ServerSocket(1000);
            try{
                while (serverSocket.isBound()){
                    System.out.println("Waiting for Connection");
                    Socket socket = serverSocket.accept();
                    System.out.println("Accepted Connection from: "+ socket.getInetAddress());
                    ObjectInputStream OIS = new ObjectInputStream(socket.getInputStream());
                    ObjectOutputStream OOS = new ObjectOutputStream(socket.getOutputStream());

                    String Request = (String) OIS.readLine();

                    switch (Request){
                        case "Hello":
                            OOS.writeObject("1234");
                    }
                }

            }catch (Exception ex){
                System.out.println(ex);
            }
        }catch (Exception ex){
            System.out.println(ex);
        }
    }
}
