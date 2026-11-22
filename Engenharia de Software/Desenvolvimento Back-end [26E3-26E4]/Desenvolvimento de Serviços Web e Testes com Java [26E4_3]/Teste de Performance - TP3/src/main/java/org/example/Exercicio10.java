package org.example;

import org.example.util.HttpUtil;

import java.net.HttpURLConnection;

public class Exercicio10 {
    static void main(String[] args) throws Exception {

        // Abertura de conexão à API para tentar remover a entidade.
        HttpURLConnection connection = HttpUtil.obterConexao(
                "https://apichallenges.com/sim/entities/",
                "2",
                "DELETE"
        );

        // Obtendo o código de status HTTP.
        int status = connection.getResponseCode();
        System.out.println("Código de status HTTP (DELETE): " + status);

        // Verificando se a operação não foi permitida.
        if (status == 403 || status == 405) {
            System.out.println("Operação de exclusão não permitida!");
        }

        // Recebendo a resposta.
        String text = HttpUtil.lerDadosConexao(connection);
        System.out.println("Resposta do DELETE:");
        System.out.println(text);
    }
}