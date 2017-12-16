package com.adidas.qa.http;

import com.github.kevinsawicki.http.HttpRequest;
import org.apache.cxf.helpers.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Component
public class HttpClient {

    private static final Logger LOGGER = Logger.getLogger(HttpClient.class);

    public String get(String url) throws IOException {
        InputStream in = new URL( url).openStream();
        return IOUtils.toString(in);
    }

    public HttpRequest httpGet(String url, String acceptHeader){
        HttpRequest httpGetResponse = HttpRequest.get(url).accept(acceptHeader);
        return httpGetResponse;
    }
    public HttpRequest httpGet(String url, String acceptHeader, String authUserName, String authPassword) {
        return httpGet(url, acceptHeader, authUserName, authPassword, new HashMap<String, String>());
    }

    public HttpRequest httpGet(String url, String acceptHeader, String authUserName, String authPassword, Map<String, String> headers) {
        HttpRequest httpGetResponse = HttpRequest.get(url).accept(acceptHeader).basic(authUserName, authPassword).headers(headers);

        LOGGER.info("******HTTP GET REQUEST****** ");
        LOGGER.info("******HTTP GET REQUEST URL****** " + url);
//        LOGGER.info("******RESPONSE BODY****** " + httpGetResponse.body());
        LOGGER.info("******RESPONSE MESSAGE****** " + httpGetResponse.message());
        LOGGER.info("******RESPONSE CODE****** " + httpGetResponse.code());
        return httpGetResponse;
    }

    public HttpRequest httpPost(String url, String contentTypeHeader, String body, String authUserName, String authPassword) {
        return httpPost(url, contentTypeHeader, body, authUserName, authPassword, new HashMap<String, String>());
    }

    public HttpRequest httpPost(String url, String contentTypeHeader, String body, String authUserName, String authPassword, Map<String, String> headers) {
        HttpRequest httpPostResponse = HttpRequest.post(url)
                .contentType(contentTypeHeader)
                .basic(authUserName, authPassword)
                .headers(headers)
                .send(body);

        LOGGER.info("******HTTP POST REQUEST****** ");
        LOGGER.info("******HTTP POST REQUEST URL****** " + url);
//        LOGGER.info("******RESPONSE BODY****** " + httpPostResponse.body());
        LOGGER.info("******RESPONSE MESSAGE****** " + httpPostResponse.message());
        LOGGER.info("******RESPONSE CODE****** " + httpPostResponse.code());
        return httpPostResponse;
    }

    public HttpRequest httpPut(String url, String contentTypeHeader, String body, String authUserName, String authPassword) {
        return httpPut(url, contentTypeHeader, body, authUserName, authPassword, new HashMap<String, String>());
    }

    public HttpRequest httpPut(String url, String contentTypeHeader, String body, String authUserName, String authPassword, Map<String, String> headers) {
        HttpRequest httpPutResponse = HttpRequest.put(url)
                .contentType(contentTypeHeader)
                .basic(authUserName, authPassword)
                .headers(headers)
                .send(body);

        LOGGER.info("******HTTP PUT REQUEST****** ");
        LOGGER.info("******HTTP PUT REQUEST URL****** " + url);
//        LOGGER.info("******RESPONSE BODY****** " + httpPutResponse.body());
        LOGGER.info("******RESPONSE MESSAGE****** " + httpPutResponse.message());
        LOGGER.info("******RESPONSE CODE****** " + httpPutResponse.code());
        return httpPutResponse;
    }

    public HttpRequest httpDelete(String url, String acceptHeader, String authUserName, String authPassword) {
        return HttpRequest.delete(url).accept(acceptHeader).basic(authUserName, authPassword);
    }

    public HttpRequest httpDelete(String url, String acceptHeader, String authUserName, String authPassword, Map<String, String> headers) {
        HttpRequest httpGetResponse = HttpRequest.delete(url).accept(acceptHeader).basic(authUserName, authPassword).headers(headers);

        LOGGER.info("******HTTP DELETE REQUEST****** ");
        LOGGER.info("******HTTP DELETE REQUEST URL****** " + url);
//        LOGGER.info("******RESPONSE BODY****** " + httpGetResponse.body());
        LOGGER.info("******RESPONSE MESSAGE****** " + httpGetResponse.message());
        LOGGER.info("******RESPONSE CODE****** " + httpGetResponse.code());
        return httpGetResponse;
    }

}
