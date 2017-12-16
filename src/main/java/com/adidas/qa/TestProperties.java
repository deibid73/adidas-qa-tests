package com.adidas.qa;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
    public static String base_url="";
    public static String base_api="";
    public static String language_locator="";
    public static String men_locator="";
    public static String women_locator="";
    public static String kids_locator="";
    public static String customise_locator="";

    static{

        Properties p=new Properties();

        try {
            p.load(new FileInputStream((System.getProperty("user.dir")+"/src/main/resources/config.properties")));
            base_url=p.getProperty("base_url");
            base_api=p.getProperty("base_api");
            language_locator=p.getProperty("language_locator");
            men_locator=p.getProperty("men_locator");
            women_locator=p.getProperty("women_locator");
            kids_locator=p.getProperty("kids_locator");
            customise_locator=p.getProperty("customise_locator");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
