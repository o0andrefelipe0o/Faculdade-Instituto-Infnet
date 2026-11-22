package org.example;

import org.example.util.HttpUtil;

import java.net.HttpURLConnection;

public class Exercicio9 {
    static void main(String[] args) throws Exception {

        // Abertura de conexão à API para remover a entidade.
        HttpURLConnection connection = HttpUtil.obterConexao(
                "https://apichallenges.com/sim/entities/",
                "9",
                "DELETE"
        );

        // Obtendo o código de status HTTP.
        int status = connection.getResponseCode();
        System.out.println("Código de status HTTP (DELETE): " + status);

        // Recebendo a resposta.
        String text = HttpUtil.lerDadosConexao(connection);
        System.out.println("Resposta do DELETE:");
        System.out.println(text);

        // Abertura de conexão à API para consultar a entidade removida.
        connection = HttpUtil.obterConexao(
                "https://apichallenges.com/sim/entities/",
                "9",
                "GET"
        );

        System.out.println("Consultando entidade ID 9 com método GET");

        // Obtendo o código de status HTTP.
        status = connection.getResponseCode();
        System.out.println("Código de status HTTP (GET): " + status);

        // Verificando se a entidade não foi encontrada.
        if (status == 404) {
            System.out.println("Entidade não encontrada!");
        }

        // Recebendo a resposta.
        text = HttpUtil.lerDadosConexao(connection);
        System.out.println("Resposta do GET:");
        System.out.println(text);
    }
}
