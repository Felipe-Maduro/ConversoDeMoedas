package com.exemplo;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ApiClient {
    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/";

    private final HttpClient http = HttpClient.newHttpClient();
    private final ObjectMapper mapper = new ObjectMapper();

    /**
     * Retorna o mapa de taxas de câmbio para a moeda base informada.
     */
    public Map<String, Double> getRates(String baseCurrency) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL + baseCurrency))
                .GET()
                .build();

        HttpResponse<String> response = http.send(request, HttpResponse.BodyHandlers.ofString());
        JsonNode root = mapper.readTree(response.body());
        JsonNode ratesNode = root.get("rates");
        @SuppressWarnings("unchecked")
        Map<String, Double> rates = mapper.convertValue(ratesNode, Map.class);
        return rates;
    }
}
