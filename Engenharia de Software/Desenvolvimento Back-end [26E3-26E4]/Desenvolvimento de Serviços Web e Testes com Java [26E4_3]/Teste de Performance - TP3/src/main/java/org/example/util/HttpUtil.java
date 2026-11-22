package org.example.util;

import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtil {
    public static HttpURLConnection obterConexao(String path, String complement, String method) throws Exception {
        if(path == null || path.isBlank() || method == null || method.isBlank()) {
            return null;
        }

        // Só adiciona a barra se houver um complemento para anexar
        if (complement != null && !complement.isBlank()) {
            path = path.endsWith("/") ? path : path + "/";
            // Remove a barra inicial do complement para evitar barra dupla (ex: //123)
            complement = complement.startsWith("/") ? complement.substring(1) : complement;
            path = path + complement;
        }

        URL url = new URL(path);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setConnectTimeout(10_000);//millissegundos
        connection.setRequestMethod(method);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);
        return connection;
    }

    public static String lerDadosConexao(HttpURLConnection connection) throws Exception {
        if(connection == null) {
            return null;
        }

        // Obtendo o código de status HTTP.
        int status = connection.getResponseCode();
        InputStream stream;
        // Verificando se a entidade foi encontrada.
        if (status >= 400) {
            stream = connection.getErrorStream();
        } else {
            stream = connection.getInputStream();
        }
        if (stream == null) {
            return null;
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(stream));
        String line;
        StringBuilder text = new StringBuilder();
        while((line = in.readLine()) != null) {
            text.append(line).append("\n");
        }
        in.close();
        return text.toString();
    }

    public static void enviarDadosConexao(HttpURLConnection connection, JSONObject jsonObject) throws Exception {
        if(connection == null || jsonObject == null) {
            return;
        }

        DataOutputStream out = new DataOutputStream(connection.getOutputStream());
        out.writeBytes(jsonObject.toJSONString());
        out.flush();
        out.close();
    }
}