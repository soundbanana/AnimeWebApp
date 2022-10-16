package ru.kpfu.itis.chemaev.net.client;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class NetSample {
    public static void get() {
        try {
            URL url = new URL("https://gorest.co.in/public/v1/users?name=Devajyoti Tagore");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");

            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            System.out.println(connection.getResponseCode());

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                StringBuilder content = new StringBuilder();
                String input;
                while ((input = reader.readLine()) != null) {
                    content.append(input);
                }
                System.out.println(content.toString());
            }
            connection.disconnect();

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void post() {
        try {
            URL postUrl = new URL("https://gorest.co.in/public/v1/users");
            HttpURLConnection postConnection = (HttpURLConnection) postUrl.openConnection();
            String token = "3247df66c027309df362aad144e8229d3333347d2c356a4a616c2f5a81847244";

            postConnection.setRequestMethod("POST");

            postConnection.setRequestProperty("Content-Type", "application/json");
            postConnection.setRequestProperty("Accept", "application/json");
            postConnection.setRequestProperty("Authorization", "Bearer " + token);

            postConnection.setDoOutput(true);

            // email should be unique, in otherwise 422 status code will bee returned
            String jsonInputString = "{\"id\":\"2995\",\"name\":\"Danil Aboba\", \"gender\":\"male\", \"email\":\"asfkjghkasjhfg@asfg.ru\", \"status\":\"active\"}";

            try (OutputStream outputStream = postConnection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
                outputStream.write(input, 0, input.length);
            }

            System.out.println(postConnection.getResponseCode());

            try (BufferedReader reader =
                         new BufferedReader(
                                 new InputStreamReader(postConnection.getInputStream())
                         )) {
                StringBuilder content = new StringBuilder();
                String input;
                while ((input = reader.readLine()) != null) {
                    content.append(input);
                }
                System.out.println(content.toString());
            }

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void head() {
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/posts?userId=1");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("HEAD");
            connection.setRequestProperty("Content-Type", "application/json");

            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            System.out.println(connection.getResponseCode());

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void put() {
        try {
            URL putURL = new URL("https://gorest.co.in/public/v1/users");

            HttpURLConnection putConnection = (HttpURLConnection) putURL.openConnection();
            String token = "3247df66c027309df362aad144e8229d3333347d2c356a4a616c2f5a81847244";

            putConnection.setRequestMethod("PUT");
            putConnection.setRequestProperty("Content-Type", "application/json");
            putConnection.setRequestProperty("Accept", "application/json");
            putConnection.setRequestProperty("Authorization", "Bearer " + token);

            putConnection.setDoOutput(true);

            putConnection.getInputStream();

            String jsonInputString = "{\"name\":\"Danil Chemaev\", \"gender\":\"male\", \"email\":\"tenali.asaramakrishna2@gmail.com\", \"status\":\"active\"}";

            try (OutputStream outputStream = putConnection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
                outputStream.write(input, 0, input.length);
            }

            System.out.println(putConnection.getResponseCode());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void delete() {
        try {
            URL postUrl = new URL("https://gorest.co.in/public/v1/users");
            HttpURLConnection postConnection = (HttpURLConnection) postUrl.openConnection();
            String token = "3247df66c027309df362aad144e8229d3333347d2c356a4a616c2f5a81847244";

            postConnection.setRequestMethod("POST");
            HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection();
            connection.setRequestMethod("DELETE");
            int responseCode = connection.getResponseCode();
        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
//        post();
//        get();
//        head();
        put();
//        delete();

    }

}