package org.example;

import org.example.util.HttpUtil;
import org.json.simple.JSONObject;

import java.net.HttpURLConnection;

public class Exercicio7 {
    static void main(String[] args) throws Exception {
        // Abertura de conexão à API com parametrização.
        HttpURLConnection connection = HttpUtil.obterConexao(
                "https://apichallenges.com/sim/entities",
                "10",
                "POST"
        );

        // Montando o JSON que será atualizado.
        /*
        {
          "name": "atualizado"
        }
         */
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "atualizado");

        // Enviando o JSON no corpo da requisição.
        HttpUtil.enviarDadosConexao(connection, jsonObject);

        // Obtendo o código de status HTTP.
        int status = connection.getResponseCode();
        System.out.println("Código de status HTTP (POST): " + status);

        // Recebendo a resposta.
        String text = HttpUtil.lerDadosConexao(connection);
        System.out.println("Resposta da API (POST): ");
        System.out.println(text);

        // Abertura de conexão à API com parametrização para consultar a entidade atualizada.
        connection = HttpUtil.obterConexao(
                "https://apichallenges.com/sim/entities/",
                "10",
                "GET");

        System.out.println("Consultando entidade ID 10 com método GET");

        // Obtendo o código de status HTTP.
        status = connection.getResponseCode();
        System.out.println("Código de status HTTP (GET): " + status);
        if (status == 404) {
            System.out.println("Entidade não encontrada!");
        }

        // Receber a resposta
        text = HttpUtil.lerDadosConexao(connection);
        System.out.println("Resposta da API (GET):");
        System.out.println(text);
    }
}
