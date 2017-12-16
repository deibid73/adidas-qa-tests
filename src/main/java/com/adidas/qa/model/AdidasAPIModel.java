package com.adidas.qa.model;

import com.adidas.qa.TestProperties;
import com.adidas.qa.http.HttpClient;
import com.github.kevinsawicki.http.HttpRequest;
import org.hamcrest.Matchers;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;

/**
 * Created by dmontero on 15/12/17.
 */
public class AdidasAPIModel {

    public JSONObject api;
    public long performance;

    public int getAdidasAPIModel() throws IOException {
        HttpClient client = new HttpClient();
        Date date = new Date();
        long timestamp1 = date.getTime();

        HttpRequest response = client.httpGet(TestProperties.base_api + "/api/pages/landing?url=index.html", "application/json");
        long timestamp2 = date.getTime();
        assertThat("response is OK", response.code(), Matchers.is(200));


        String sresponse = response.body();
        System.out.println("RESPONSE " + sresponse);
        api = new JSONObject(sresponse);
        performance=timestamp2-timestamp1;
        return response.code();


    }

    public ArrayList getListOfUrls(JSONArray components) {
        ArrayList<String> urls = new ArrayList<String>();
        for (int i = 0; i < components.length(); i++) {
            JSONObject component = components.getJSONObject(i);
            if (component.toString().contains("url")) {

                System.out.println(component.toString());
                JSONArray items = component.getJSONObject("component").getJSONObject("content_fields").getJSONArray("items");
                for (int j = 0; j < items.length(); j++) {
                    String sUrl = items.getJSONObject(i).getJSONObject("background_media").getJSONObject("desktop_image").getString("url");
                    urls.add(sUrl);

                    sUrl = items.getJSONObject(i).getJSONObject("background_media").getJSONObject("tablet_image").getString("url");
                    urls.add(sUrl);

                    sUrl = items.getJSONObject(i).getJSONObject("background_media").getJSONObject("mobile_image").getString("url");
                    urls.add(sUrl);

                }
            }


        }
        return urls;
    }


}
