package edu.escuelaing.arem.app;

import edu.escuelaing.arem.app.services.RESTService;
import edu.escuelaing.arem.app.spark.Spark;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class httpServer {
    private static final String url = "http://www.omdbapi.com/?t=";
    private static final String key = "&apikey=2c402a46";

    private static httpServer instance = new httpServer();

    private static Map<String, RESTService> services = new HashMap<>();

    OutputStream outputStream = null;

    public static httpServer getInstance(){
        return instance;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }



    
     /**
      * Método principal, inicia un socket
      * recibe la petición get y agrega el nombre a de la
      * película seleccionada a la URL de la API
      *
      * @param args
      * @return
      * @throws IOException
      */
    public void run(String[] args) throws IOException, JSONException {
        ServerSocket serverSocket = null;
        Spark spark = Spark.getInstance();

        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }

        boolean running = true;
        while (running) {
            Socket clientSocket = null;
            //reply = "Inicio";
            try {
                System.out.println("Listo para recibir ...");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String request = "/simple";
            String petition = "GET";
            Boolean FirstLine = true;
            String title = "", inputLine, outputLine = "";
            outputStream = clientSocket.getOutputStream();

            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);


                if (inputLine.contains("/hello?name=")) {
                    String[] res = inputLine.split("=");
                    title = res[1].split("HTTP")[0].replace(" ", "");
                }

                if (FirstLine) {
                    request = inputLine.split(" ")[1];
                    petition = inputLine.split(" ")[0];
                    FirstLine = false;
                }
                if (!in.ready()) {
                    break;
                }
            }


            if (request.startsWith("/apps/")) {
                String path = request.substring(5);
                if (petition.equals("GET")) {
                    String res = spark.getService(path);
                    if (res == null) {
                        spark.get(request.substring(5), ((requests, response) -> {
                            try {
                                String type = path.split("\\.")[1];
                                response.setType("text/" + type);
                                response.setCode("200 OK");
                                response.setPath(path);
                                return response.getResponse();
                            } catch (Exception e) {
                                response.setType("text/hmtl");
                                response.setCode("404 NOT FOUND");
                                response.setPath("404.html");
                                return response.getResponse();
                            }
                        }));
                        res = spark.getService(path);
                        outputLine = res;
                    }
                    //outputLine = get(outputLine).getResponse();
                }
            } else if (petition.equals("POST")) {
                outputLine = spark.post(path, ((requests, response) -> {
                    String paths = path.split("\\?")[0];
                    String type = path.split("\\.")[1];
                    response.setType("text/" + type);
                    response.setCode("200 OK");
                    response.setPath(resquest);
                    return response.getResponse();
                }));

        } else if (!title.equals("")) {
               cache instan =cache.getInstance();
                if(instan.contains(title)){
                    System.out.println("Esta en el cache");
                    String answer = instan.get(title);
                    outputLine ="HTTP/1.1 200 OK\r\n"
                            + "Content-Type: text/html\r\n"
                            + "\r\n"
                            + "<br>"
                            + "<table border=\" 1 \"> \n " + tableFront(answer)
                            + "</table>";
                }
                else{
                    String answer = httpClient.getAnswer(url + title + key);
                    instan.saveQuery(answer, title);
                    outputLine ="HTTP/1.1 200 OK\r\n"
                            + "Content-Type: text/html\r\n"
                            + "\r\n"
                            + "<br>"
                            + "<table border=\" 1 \"> \n " + tableFront(answer)
                            + "</table>";
                }
            } else {
                outputLine = "HTTP/1.1 200 OK\r\n"
                        + "Content-Type: text/html\r\n"
                        + "\r\n"
                        + htmlWithForms();
            }
            out.println(outputLine);
            out.close();
            in.close();
            clientSocket.close();
        }
        serverSocket.close();
    }




    /**
     * Metodo para crear una tabla en formato String JSON
     * @param response String movie information
     * @return String(JSON)
     */
    private static String tableFront(String response) throws JSONException {
        HashMap<String,String> dict = new HashMap<String, String>();
        JSONArray jsonArray = new JSONArray(response);
        for (int i=0; i<jsonArray.length();i++){
            JSONObject object = jsonArray.getJSONObject(i);
            for (String key: object.keySet()) {
                dict.put(key.toString(), object.get(key).toString());
            }
        }
        String table = "<tr> \n";
        for (String keys: dict.keySet()){
            String value = dict.get(keys);
            table += "<td>" + keys + "</td>\n";
            table += "<td>" + value + "</td>\n";
            table += "<tr> \n";
        }
        return table;
    }


    public static String htmlSimple() {
        return "HTTP/1.1 200 OK\r\n"
                + "\r\n"
                + "<!DOCTYPE html>"
                + "<html>"
                + "<head>"
                + "<meta charset=\"UTF-8\">"
                + "<title>Title of the document</title>\n"
                + "</head>"
                + "<body>"
                + "My Web Site"
                + "</body>"
                + "</html>";
    }


    /**
     * Method createv view html
     * @return view html
     */
    public static String htmlWithForms(){
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "    <head>\n" +
                "        <title>informacionPeliculas</title>\n" +
                "        <meta charset=\"UTF-8\">\n" +
                "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    </head>\n" +
                "    <body>\n" +
                "        <h1>Buscar peliculas</h1>\n" +
                "        <form action=\"/hello\">\n" +
                "            <label for=\"name\">Introducir nombre de pelicula a buscar:</label><br>\n" +
                "            <input type=\"text\" id=\"name\" name=\"name\"><br><br>\n" +
                "            <input type=\"button\" value=\"Submit\" onclick=\"loadGetMsg()\">\n" +
                "        </form> \n" +
                "        <div id=\"getrespmsg\"></div>\n" +
                "\n" +
                "        <script>\n" +
                "            function loadGetMsg() {\n" +
                "                let nameVar = document.getElementById(\"name\").value;\n" +
                "                if (nameVar) {\n" +
                "                   console.log(\"Nombre \" + nameVar)\n" +
                "                   const xhttp = new XMLHttpRequest();\n" +
                "                   xhttp.onload = function() {\n" +
                "                       document.getElementById(\"getrespmsg\").innerHTML =\n" +
                "                       this.responseText;\n" +
                "                   }\n" +
                "                   xhttp.open(\"GET\", \"/hello?name=\"+nameVar);\n" +
                "                   xhttp.send();\n" +
                "                };\n" +
                "            }\n" +
                "        </script>\n" +
                "\n" +
                "    </body>\n" +
                "</html>";
    }

    /**
     * Método que ejecuta el servicio
     * @param serviceName
     * @return encabezado + cuerpo
     */
    private static String executeService(String serviceName) {
       String header = "", body = "";
        try {
            RESTService rs = services.get(serviceName);
            header = rs.getHeader();
            body = rs.getResponse();
        } catch (Exception e) {
            System.out.println("Error");
        }
        return header + body;
    }


    /**
     * Método que añade un servicio
     * @param key
     * @param service
     */
    public void addServices(String key, RESTService service){
        services.put(key,service);
    }
}



















