
package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import org.example.util.HttpUtil;

public class Exercicio2 {
     static void main(String[] args) throws Exception {
        // Consultando as entidades de ID 1 até 8.
        for (int id = 1; id <= 8; id++) {
            // Abertura de conexão à API com parametrização
            HttpURLConnection connection = HttpUtil.obterConexao(
                    "https://apichallenges.com/sim/entities/",
                    "" + id,
                    "GET");

            System.out.println("Consultando entidade ID: " + id);

            // Receber a resposta
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            );
            String line;
            StringBuilder text = new StringBuilder();
            while((line = in.readLine()) != null) {
                text.append(line);
            }
            in.close();
            System.out.println("Resposta da API:");
            System.out.println(text);

            if (id < 8){
                System.out.println("==================================");
            }
        }
    }
}
