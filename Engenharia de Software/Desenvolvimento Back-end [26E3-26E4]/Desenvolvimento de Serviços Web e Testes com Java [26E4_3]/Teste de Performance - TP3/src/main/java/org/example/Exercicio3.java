
package org.example;

import org.example.util.HttpUtil;

import java.net.HttpURLConnection;

public class Exercicio3 {
     static void main(String[] args) throws Exception {
         int id = 13;
        // Abertura de conexão à API com parametrização
         HttpURLConnection connection = HttpUtil.obterConexao(
                "https://apichallenges.com/sim/entities/",
                "" + id,
                "GET");

         System.out.println("Consultando entidade ID: " + id);

         // Obtendo o código de status HTTP.
         int status = connection.getResponseCode();
         System.out.println("Código de status HTTP: " + status);
         if (status == 404) {
             System.out.println("Entidade não encontrada!");
         }

         // Receber a resposta
         String text = HttpUtil.lerDadosConexao(connection);
         System.out.println("Resposta da API:");
         System.out.println(text);
    }
}
