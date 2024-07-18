package com.example;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Main2 {

    public static void main(String[] args) throws IOException {
        System.out.println("This request returns a fact about the cats, along with the length of the returned fact.");
        try (CloseableHttpClient client01 = HttpClients.createDefault()) {
            HttpGet get = new HttpGet("https://catfact.ninja/fact");
            try {
                InputStream content = client01.execute(get).getEntity().getContent();

                System.out.println(readContent(content));
            } catch (IOException e) {
                System.out.println("Something went wrong while sending the request or reading the response.");
            }
        }

        System.out.println("This request returns sample POST response data, including the data added by the requester, such as the headers and parameters.");
        try (CloseableHttpClient client02 = HttpClients.createDefault()) {
            HttpPost post = new HttpPost("https://httpbin.org/post");

            List<NameValuePair> params = new ArrayList<>();

            params.add(new BasicNameValuePair("username", "sample01234"));
            params.add(new BasicNameValuePair("password", "01234"));
            post.setEntity(new UrlEncodedFormEntity(params));
            try {
                InputStream content = client02.execute(post).getEntity().getContent();

                System.out.println(readContent(content));
            } catch (IOException e) {
                System.out.println("Something went wrong while sending the request or reading the response.");
            }
        }
    }

    private static String readContent(InputStream content) throws IOException {
        StringBuilder builder = new StringBuilder();
        int next = content.read();

        while (-1 != next) {
            builder.append(((char) next));

            next = content.read();
        }
        return builder.toString();
    }
}
