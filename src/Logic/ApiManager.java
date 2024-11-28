package Logic;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ApiManager {



    public Result ConsultaApi(String monedaOrigen, String monedaDestino, double cantidad) throws IOException, InterruptedException {

        String direccion = "https://v6.exchangerate-api.com/v6/993cf5243de2f89bc8e75e2c/pair/" +monedaOrigen + "/"+ monedaDestino+ "/"+ cantidad;

        //Ejecuar el proceso de request y response de la API
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();


        //Recibir la respuesta
        HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();


        //LLevar el Json a un objeto
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        resultOmdb resultOmdb = gson.fromJson(json, resultOmdb.class);
        Result res = new Result(resultOmdb);
        return res;
    }
}
