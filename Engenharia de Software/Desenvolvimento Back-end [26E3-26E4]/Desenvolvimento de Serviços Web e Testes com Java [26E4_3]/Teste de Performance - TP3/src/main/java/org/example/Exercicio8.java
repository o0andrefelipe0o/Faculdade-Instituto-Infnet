package org.example;

import org.example.util.HttpUtil;
import org.json.simple.JSONObject;

import java.net.HttpURLConnection;

public class Exercicio8 {
    static void main(String[] args) throws Exception {

        // Montando o JSON que será enviado.
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "atualizado");

        // Abertura de conexão à API com parametrização.
        HttpURLConnection connection = HttpUtil.obterConexao(
                "https://apichallenges.com/sim/entities/",
                "10",
                "PUT"
        );

        // Enviando o JSON no corpo da requisição.
        HttpUtil.enviarDadosConexao(connection, jsonObject);

        // Obtendo o código de status HTTP.
        int status = connection.getResponseCode();
        System.out.println("Código de status HTTP (PUT): " + status);

        // Recebendo a resposta.
        String text = HttpUtil.lerDadosConexao(connection);
        System.out.println("Resposta do PUT:");
        System.out.println(text);

        // Consultando a entidade após a atualização.
        connection = HttpUtil.obterConexao(
                "https://apichallenges.com/sim/entities/",
                "10",
                "GET"
        );

        System.out.println("Consultando entidade ID: 10 com método GET");

        // Obtendo o código de status HTTP.
        status = connection.getResponseCode();
        System.out.println("Código de status HTTP (GET): " + status);

        // Recebendo a resposta.
        text = HttpUtil.lerDadosConexao(connection);
        System.out.println("Resposta do GET:");
        System.out.println(text);
    }
}