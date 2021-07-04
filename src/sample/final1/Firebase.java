package sample.final1;

import javafx.fxml.FXML;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

// we are using FIREBASE Api Realtime Database  instead of Firestore Database as Firestore database is easily accessable from the
// android and maven project via various procedures but it is difficult to access it via the JavaFX so we are using RealTime
// Database of the FireBase via the REST API services and use GET and PUT commands

public class Firebase {


// getting the highest bid of all 3 items
    public double get(String b){
        double a = 0.0;
        String name = "";
        if(b.equals("item")){
            name = "name";
        }else if(b.equals("item2")){
            name = "name2";
        }else{
            name = "name3";
        }
        final HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2)
                .build();
        HttpRequest request = HttpRequest.newBuilder().GET()
                .uri(URI.create("https://final-69c78-default-rtdb.firebaseio.com/users/final-69c78-default-rtdb/"+ name +".json"))
                .setHeader("user-agent" , "JAVA 11 http client")
                .build();
        HttpResponse<String> response;
        {
            try {
                response = httpClient.send(request , HttpResponse.BodyHandlers.ofString());

                JSONObject jsonObject = new JSONObject(response.body());
                String value = jsonObject.getString("value");
                a = Double.parseDouble(value);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
        return a;
    }


    // in this we put the value biggest bid regarding all the 3 objects in 3 separate slots in the firebase databse
    public void put(String b , String a){
        String input = "{\n" +
                " \"name\" : \" "+ b +" \" , \n" +
                " \"value\" : \"" + a+"\" \n" +
                "}";
        String name = "";
        if(b.equals("item")){
            name = "name";
        }else if(b.equals("item2")){
            name = "name2";
        }else{
            name = "name3";
        }
        var request = HttpRequest.newBuilder()
                .uri(URI.create("https://final-69c78-default-rtdb.firebaseio.com/users/final-69c78-default-rtdb/"+ name+".json"))
                .header("Content-type" , "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(input))
                .build();
        var client = HttpClient.newHttpClient();
        HttpResponse<String> response = null;
        try {
            response = client.send(request , HttpResponse.BodyHandlers.ofString());
//            System.out.println(response.statusCode());
//            System.out.println(response.body());
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
