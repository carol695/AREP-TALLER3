# DISEÑO Y ESTRUCTURACIÓN DE DE APLICACIONES DISTRIBUIDAS EN INTERNET

Una aplicación distribuida es una aplicación con distintos componentes que se 
ejecutan en entornos separados, normalmente en diferentes plataformas conectadas a través de una red
 
El objetivo de este laboratorio es escribir un servidor web que soporte múlltiples solicitudes seguidas (no concurrentes). Para ello el servidor debe leer los archivos del disco local y retornar todos los archivos solicitados, incluyendo páginas html, archivos java script, css e imágenes.
Para mirar los diferentes servicios, se coloca el path localhost:35000/apps/"Nombre del servicio" .
 
**** 
## Empezando

### 🛠️ Abre y ejecuta el proyecto

**1. Para empezar se clona el repositorio colocando el siguiente comando**

```
git clone https://github.com/carol695/Taller2_AREP.git
```
**2. Ya clonado el repositorio abrimos el laboratorio utilizando cualquier de los siguientes IDE.**

* Intellij.
* eclipse.
* visual Studio code. 

**3. Luego de abrir el laboratorio, corremos el proyecto. Para este caso colocaremos lo siguiente: **

```
git clean package exec:java -D"exec.mainClass"="edu.escuelaing.arem.app.WebApss.FirstApp"
```

Una vez veamos el mensaje de "Listo para recibir ..." entramos al buscador de preferencia y entramos al link http://localhost:35000/apps/ "Nombre del servicio"

### Para el nombre del servicio podemos reemplazarlo con: 

* index: Archivo en html.
* estilos: Archivo en css.
* imagen: Imagen en formato jpg.
* javaScript: Formato en js. 

****
### :chart_with_downwards_trend: Prerrequisitos

-   [Git](https://git-scm.com/downloads) - Sistema de control de versiones
-   [Maven](https://maven.apache.org/download.cgi) - Gestor de dependencias
-   [Java 8](https://www.java.com/download/ie_manual.jsp) - Entorno de desarrollo
-   [Intellij Idea](https://www.jetbrains.com/es-es/idea/download/) (Opcional)

****

### :construction: Arquitectura propuesta

#### Para html 

![image](https://user-images.githubusercontent.com/63822072/217949026-6cc28799-52b1-465f-adde-860daa588a1b.png)

#### Para CSS

![image](https://user-images.githubusercontent.com/63822072/217949523-86873440-23ea-4da8-906e-5b33c32ff64d.png)

### Nota: De igual manera, la estructura anteriormente visualizada se utiliza para los dos servicios faltantes. Tanto para documentos javaScript e imagen. 

****
### :bulb: Construido con

* [Maven](https://maven.apache.org/) - Dependency Management

## :mag_right: Versionamiento

Para definir el versionamiento se pudo obserar los tags del repositorio, y el versionaiento es 1.0 

## :woman: Actores

* **Carol Tatiana Cely Rodriguez** 

## :page_with_curl: Descripción

Se construye una interfaz(RESTService) la cual tiene los metodos para devolver el header y el body de una pagina, se crearon varias clases que implementan esta interfaz para que leyeran archivos html, css, js y jgp, para esto se usa un httpServer el cual es el encargado de conectar y revisar que el link ingresa para redireccionar de la mejor manera y así mostrar el cuerpo de cada servicio. 
Además se genera una carpeta en el main, llamada resource, donde esta tendra los archivos .html, .css, .js y jpg. 
