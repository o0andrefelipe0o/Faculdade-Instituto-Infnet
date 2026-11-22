package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Exercicio1 {
    static void main() throws IOException {
        // Abertura de conexão à API com parametrização
        //----------------------------------------------------------------------
        String path = "https://apichallenges.com/sim/entities";
        String method = "GET";
        URL url = new URL(path);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setConnectTimeout(10_000);//millissegundos
        connection.setRequestMethod(method);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        // Obtendo o código de status HTTP
        int status = connection.getResponseCode();
        System.out.println("Código de status HTTP: " + status);

        //----------------------------------------------------------------------
        // Receber a resposta
        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream())
        );
        String line;
        StringBuilder text = new StringBuilder();
        while((line = in.readLine()) != null) {
            text.append(line).append("\n");
        }
        in.close();
        System.out.println("Resposta da API:");
        System.out.println(text);
    }
}
