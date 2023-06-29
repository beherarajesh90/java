package com.java.java11Features;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientApi {

    public static void main(String[] args) throws IOException, InterruptedException {

        String uri = "https://postman-echo.com/get?uname=dfdf&pwd=13444";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .header("testHeader","value")
                .version(HttpClient.Version.HTTP_2)
                .build();

        HttpClient httpClient = HttpClient.newBuilder()
                .build();
        HttpResponse response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());
    }

}
