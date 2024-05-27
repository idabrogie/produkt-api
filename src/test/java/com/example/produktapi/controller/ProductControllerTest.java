package com.example.produktapi.controller;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static org.junit.Assert.assertEquals;

class ProductControllerTest {
    WireMockServer wm;
    @BeforeEach
    void setUp() {
        wm = new WireMockRule(wireMockConfig().port(8080));
        wm.start();
    }

    @Test
    void hello() {
        //        // create a stub
        WireMock.stubFor(get(urlEqualTo("/my-endpoint")).willReturn(aResponse().withBody("Hello, world!")));

        // call request in WireMock through OkHttpClient
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("http://localhost:8080/my-endpoint")
                .method("GET", null)
                .build();

        Response response;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // assert the response
        try {
            Assertions.assertEquals("Hello, world!", response.body().string());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}