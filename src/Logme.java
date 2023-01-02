import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Logme {

    public static String MyIp(){
        try {
            URL whatismyip = new URL("http://checkip.amazonaws.com");
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    whatismyip.openStream()));

            String ip = in.readLine(); //you get the IP as a String
            System.out.println(ip);
            return ip;
        }catch (Exception ex){
            System.out.println(ex);
        }
        return "";
    }
    public static void log(String log){
        try {
            var values = new HashMap<String, String>() {{
                put("{"+MyIp()+"} Log", log);
            }};

            var objectMapper = new ObjectMapper();
            String requestBody = objectMapper
                    .writeValueAsString(values);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://hook.us1.make.com/7eg8fy5kda40o468uoatow3s6472onaw"))
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();

            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            System.out.println(response.body());
        }catch (Exception exception){
            System.out.println(exception);
    }
    }


}
