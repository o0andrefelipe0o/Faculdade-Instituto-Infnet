package org.example;

import org.example.util.HttpUtil;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;

public class Exercicio6 {
    static void main(String[] args) throws Exception {
        // Abertura de conexão à API com parametrização.
        HttpURLConnection connection = HttpUtil.obterConexao(
                "https://apichallenges.com/sim/entities",
                null,
                "POST"
        );

        // Enviando o JSON no corpo da requisição.
        DataOutputStream out = new DataOutputStream(connection.getOutputStream());

        // Montando o JSON que será enviado.
        /*
        {
          "name": "aluno"
        }
         */
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "aluno");
        // Enviando o JSON no corpo da requisição.
        out.writeBytes(jsonObject.toJSONString());
        out.flush();
        out.close();

        // Recebendo a resposta.
        String text = HttpUtil.lerDadosConexao(connection);

        // Identificando o ID gerado.
        JSONParser parser = new JSONParser();
        jsonObject = (JSONObject) parser.parse(text);

        // Abertura de conexão à API com parametrização
        connection = HttpUtil.obterConexao(
                "https://apichallenges.com/sim/entities/",
                "" + jsonObject.get("id"),
                "GET");

        System.out.println("Consultando entidade ID: " + jsonObject.get("id"));

        // Obtendo o código de status HTTP.
        int status = connection.getResponseCode();
        System.out.println("Código de status HTTP: " + status);
        if (status == 404) {
            System.out.println("Entidade não encontrada!");
        }

        // Receber a resposta
        text = HttpUtil.lerDadosConexao(connection);
        System.out.println("Resposta da API:");
        System.out.println(text);
    }
}
