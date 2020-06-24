package br.com.gabrielrosenbach.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import br.com.gabrielrosenbach.dto.RetornoCepDTO;

public class HttpRequest {

	public static RetornoCepDTO buscarCep(Integer cep) 
    {
        String json;        

        try {
            URL url = new URL("http://viacep.com.br/ws/"+ cep +"/json");
            URLConnection urlConnection = url.openConnection();
            InputStream is = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            StringBuilder jsonSb = new StringBuilder();

            br.lines().forEach(l -> jsonSb.append(l.trim()));
            json = jsonSb.toString();
            
            json = json.replaceAll("[{},:]", "");
            json = json.replaceAll("\"", "\n");                       
            String array[] = new String[30];
            array = json.split("\n");

            String cidade = array[19]; 
            String estado = array[23];
            
            return new RetornoCepDTO(cidade, estado);
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
