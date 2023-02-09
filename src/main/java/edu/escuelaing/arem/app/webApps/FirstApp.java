package edu.escuelaing.arem.app.webApps;

import edu.escuelaing.arem.app.services.*;
import edu.escuelaing.arem.app.httpServer;

import java.io.IOException;

public class FirstApp {
    public static void main(String[] args) throws IOException {
        httpServer server = httpServer.getInstance();
        server.addServices("/index", new ServiceHtml());
        server.addServices("/estilos", new ServiceCSS());
        server.addServices("/javaScript", new ServiceJS());
        server.addServices("/imagen", new ServicePNG());
        server.run(args);
    }
}
