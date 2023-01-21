package br.com.locacao.imoveis.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class MethodsUtils {

    public static String buscaCep(String cep) throws IOException {
        String json;
        URL url = new URL("http://viacep.com.br/ws/"+ cep +"/json");
        URLConnection urlConnection = url.openConnection();
        InputStream is = urlConnection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        StringBuilder jsonSb = new StringBuilder();

        br.lines().forEach(l -> jsonSb.append(l.trim()));
        json = jsonSb.toString();
        return json;
    }

}
