package edu.escuelaing.arem.app.webApps;

import edu.escuelaing.arem.app.RESTService;
import edu.escuelaing.arem.app.httpServer;

public class FirstApp {
    public static void main(String[] args){
        httpServer server = httpServer.getInstance();
        server.addServices("/cine",
                new RESTService() {
                    @Override
                    public String getHeader() {
                        return "HTTP/1.1 200 OK\r\n"
                                + "Content-Type: application/json \r\n"
                                + "\r\n";
                    }

                    @Override
                    public String getResponse() {
                        return null;
                    }
                });
        server.addServices("/hello", new HelloService());
    }
}
