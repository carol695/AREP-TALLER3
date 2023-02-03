package edu.escuelaing.arem.app;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        URL personalSite = new URL("https://campusvirtual.escuelaing.edu.co/moodle/course/view.php?id=892");

        System.out.println("Protocol" + personalSite.getProtocol());
        System.out.println("Authority" + personalSite.getAuthority());
        System.out.println("Path" + personalSite.getPath());
        System.out.println("Port" + personalSite.getPort());
        System.out.println("Query" + personalSite.getQuery());
    }
}
