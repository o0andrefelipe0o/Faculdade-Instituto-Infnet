package org.example;

import org.example.util.HttpUtil;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.HttpURLConnection;

public class Exercicio12 {
    static void main(String[] args) throws Exception {

        String path = "https://apichallenges.com/simpleapi/items";
        String text;
        int status;

        // ---------------------------------------------------------
        // a) GET todos os itens
        System.out.println("a) GET todos os itens");
        HttpURLConnection connection = HttpUtil.obterConexao(
                path,
                null,
                "GET"
        );

        connection.setRequestProperty("Accept", "application/json");

        // Obtendo o código de status HTTP.
        status = connection.getResponseCode();
        System.out.println("Código de status HTTP (GET): " + status);

        // Recebendo a resposta.
        text = HttpUtil.lerDadosConexao(connection);
        System.out.println("Lista de itens:");
        System.out.println(text);

        // ---------------------------------------------------------
        // b) Gerar ISBN aleatório
        System.out.print("b) Gerar ISBN aleatório");
        connection = HttpUtil.obterConexao(
                "https://apichallenges.com/simpleapi/randomisbn",
                null,
                "GET"
        );

        connection.setRequestProperty("Accept", "text/plain");

        // Obtendo o código de status HTTP.
        status = connection.getResponseCode();
        System.out.println("\nCódigo de status HTTP (ISBN): " + status);

        // Recebendo o ISBN gerado.
        text = HttpUtil.lerDadosConexao(connection);
        String isbn = text.trim();

        System.out.println("ISBN gerado: " + isbn);

        // ---------------------------------------------------------
        // c) Criar item com POST
        System.out.print("\nc) Criar item com POST");
        connection = HttpUtil.obterConexao(
                path,
                null,
                "POST"
        );

        // Montando o JSON que será enviado.
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("type", "book");
        jsonObject.put("isbn13", isbn);
        jsonObject.put("price", 5.99);
        jsonObject.put("numberinstock", 5);

        // Enviando os dados no corpo da requisição.
        HttpUtil.enviarDadosConexao(connection, jsonObject);

        // Obtendo o código de status HTTP.
        status = connection.getResponseCode();
        System.out.println("\nCódigo de status HTTP (POST): " + status);

        // Recebendo a resposta.
        text = HttpUtil.lerDadosConexao(connection);
        System.out.println("Resposta do POST:");
        System.out.println(text);

        // Extraindo o ID gerado pela API.
        JSONObject item = (JSONObject) new JSONParser().parse(text);
        String id = String.valueOf(item.get("id"));

        // ---------------------------------------------------------
        // d) Atualizar item com PUT
        System.out.print("d) Atualizar item com PUT");
        connection = HttpUtil.obterConexao(
                path,
                id,
                "PUT"
        );

        // Montando o JSON com os dados atualizados.
        jsonObject = new JSONObject();
        jsonObject.put("type", "book");
        jsonObject.put("isbn13", isbn);
        jsonObject.put("price", 8.99);
        jsonObject.put("numberinstock", 10);

        // Enviando os dados no corpo da requisição.
        HttpUtil.enviarDadosConexao(connection, jsonObject);

        // Obtendo o código de status HTTP.
        status = connection.getResponseCode();
        System.out.println("\nCódigo de status HTTP (PUT): " + status);

        // Recebendo a resposta.
        text = HttpUtil.lerDadosConexao(connection);
        System.out.println("Resposta do PUT:");
        System.out.println(text);

        // ---------------------------------------------------------
        // e) Remover item com DELETE
        System.out.print("e) Remover item com DELETE");
        connection = HttpUtil.obterConexao(
                path,
                id,
                "DELETE"
        );

        // Obtendo o código de status HTTP.
        status = connection.getResponseCode();
        System.out.println("\nCódigo de status HTTP (DELETE): " + status);

        // Recebendo a resposta.
        text = HttpUtil.lerDadosConexao(connection);

        System.out.println("Resposta do DELETE:");
        if (text == null || text.isBlank()) {
            System.out.println("Sem conteúdo na resposta.");
        } else {
            System.out.println(text);
        }
    }
}
