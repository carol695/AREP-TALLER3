package edu.escuelaing.arem.app.services;

import java.io.IOException;

public interface RESTService {
    public String getHeader();

    public String getResponse() throws IOException;
}
