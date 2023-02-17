package edu.escuelaing.arem.app.spark;

import edu.escuelaing.arem.app.cache;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class Spark {
    public static cache gets;
    private static Spark instance;

    private static HashMap<String, String> services = new HashMap<>();

    private Spark(){}

    public static Spark getInstance() {
        if(instance == null){
            instance = new Spark();
        }
        return instance;
    }

    public static void get(String path){
        Request request = new Request();
        Response response = new Response();

        String res = ServiceSpark.app(request,response);
        services.put(path, res);
    }

    public String getService(String path){
        byte[] file;
        try{
            file = Files.readAllBytes(Paths.get("src/main/resources/" + path));
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        return new String(file);
    }

    public String post(String path, ServiceSpark service){
        Response response = new Response();
        Request request = new Request();
        services.put(path, ServiceSpark.app(request,response));
        return ServiceSpark.app(request,response);
    }
}
