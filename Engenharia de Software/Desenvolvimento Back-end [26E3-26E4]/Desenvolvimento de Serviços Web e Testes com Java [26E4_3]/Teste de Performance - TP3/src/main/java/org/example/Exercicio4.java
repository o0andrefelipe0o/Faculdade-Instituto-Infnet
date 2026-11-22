
package org.example;

import org.example.util.HttpUtil;

import java.net.HttpURLConnection;

public class Exercicio4 {
    static void main(String[] args) throws Exception {

        // Montando a URL com parâmetros de consulta.
        String path = "https://apichallenges.com/sim/entities"
                    + "?categoria=teste&limite=5";

        // Abertura de conexão à API com parametrização.
        HttpURLConnection connection = HttpUtil.obterConexao(
                path,
                null,
                "GET"
        );

        // Imprimindo a URL final.
        System.out.println("URL da requisição: " + path);

        // Obtendo o código de status HTTP.
        int status = connection.getResponseCode();
        System.out.println("Código de status HTTP: " + status);

        // Recebendo a resposta.
        String text = HttpUtil.lerDadosConexao(connection);
        System.out.println("Resposta da API:");
        System.out.println(text);
    }
}
