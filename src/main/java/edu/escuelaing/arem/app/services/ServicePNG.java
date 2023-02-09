package edu.escuelaing.arem.app.services;

import com.sun.net.httpserver.HttpServer;
import edu.escuelaing.arem.app.httpServer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ServicePNG implements RESTService{
    @Override
    public String getHeader() {
        return "";
    }

    @Override
    public String getResponse() throws IOException {
        String response = "HTTP/1.1 200 OK\r\n"
                + "Content-Type: image/jpg\r\n"
                + "\r\n";
        BufferedImage bufferedImage = ImageIO.read(new File("src/main/resource/imagen.jpg"));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        httpServer server = httpServer.getInstance();
        DataOutputStream dataOutputStream = new DataOutputStream(server.getOutputStream());
        ImageIO.write(bufferedImage, "jpg", byteArrayOutputStream);
        dataOutputStream.writeBytes(response);
        dataOutputStream.write(byteArrayOutputStream.toByteArray());
        return response;
    }

}

