package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server {
    public static void serve() {
        try (ServerSocket serverSocket = new ServerSocket(8000)) {
            System.out.println("Server started");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Received message:");

                try (BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
                     PrintWriter output = new PrintWriter(socket.getOutputStream())) {

                    while (!input.ready());

                    System.out.println(input.readLine().split(" ")[1]);
                    System.out.println();

                    output.println("HTTP/1.1 200 OK");
                    output.println("Content-Type: text/plain; charset=utf-8");
                    output.println();
                    output.println("Done");
                    output.flush();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
