package org.example;

import org.example.util.HttpUtil;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;

public class Exercicio5 {
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
        System.out.println("ID gerado: " + jsonObject.get("id"));
    }
}