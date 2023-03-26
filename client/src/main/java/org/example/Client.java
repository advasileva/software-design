package org.example;

import java.io.*;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Flow;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Client {
    public static void start() throws InterruptedException, IOException {
        System.out.println("Client started");
        int count = 0;
        while (true) {
            count++;

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(String.format("http://localhost:8000/message-%s", String.valueOf(count))))
                    .build();

            HttpResponse<?> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
            System.out.println(response.statusCode());
            TimeUnit.SECONDS.sleep(3);
        }
    }
}
