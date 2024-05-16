package Clases;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

public class ConsultasAPI {
    public Double obtenerTasaCambio(String base, String target){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/5deb7f62d5f463c221b88576/pair/" + base + "/" + target))
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();
            TasaConversion tasaConversion = gson.fromJson(response.body(), TasaConversion.class);
            return tasaConversion.conversion_rate();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
