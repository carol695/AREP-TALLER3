package edu.escuelaing.arem.app;

import java.io.IOException;

public interface RESTService {
    public String getHeader();

    public String getResponse() throws IOException;
}
