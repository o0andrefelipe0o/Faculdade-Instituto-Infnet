package org.example;

import org.example.util.HttpUtil;

import java.net.HttpURLConnection;

public class Exercicio11 {
    static void main(String[] args) throws Exception {

        // Abertura de conexão à API para consultar os métodos permitidos.
        HttpURLConnection connection = HttpUtil.obterConexao(
                "https://apichallenges.com/sim/entities",
                null,
                "OPTIONS"
        );

        // Obtendo o código de status HTTP.
        int status = connection.getResponseCode();
        System.out.println("Código de status HTTP (OPTIONS): " + status);

        // Obtendo os métodos HTTP permitidos no cabeçalho Allow.
        String allow = connection.getHeaderField("Allow");
        System.out.println("Métodos HTTP permitidos: " + allow);

        // Recebendo a resposta.
        String text = HttpUtil.lerDadosConexao(connection);
        System.out.println("Resposta da API:");
        System.out.println(text);
    }
}
