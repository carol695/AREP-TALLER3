# MICROFRAMEWORKS WEB

Una aplicación distribuida es una aplicación con distintos componentes que se 
ejecutan en entornos separados, normalmente en diferentes plataformas conectadas a través de una red
 
El objetivo de este laboratorio es explorar la arquitectura del microframework WEB denominado sparkweb (https://sparkjava.com/). Este micro framework permite construir aplicaciones web de manera simple usando funciones lambda. onstruir un  servidor web para soportar una funcionalidad similar a la de Spark. Su aplicación debe permitir por lo menos el registro de servicios get y post usando funciones lambda. Para ello el servidor debe leer los archivos del disco local y retornar todos los archivos solicitados, incluyendo páginas html, archivos java script, css e imágenes.
Para mirar los diferentes servicios, se coloca el path localhost:35000/apps/"Nombre del servicio" .
 
**** 
## Empezando

### 🛠️ Abre y ejecuta el proyecto

**1. Para empezar se clona el repositorio colocando el siguiente comando**

```
git clone https://github.com/carol695/AREP-TALLER3.git
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

### :bulb: Construido con

* [Maven](https://maven.apache.org/) - Dependency Management

## :mag_right: Versionamiento

Para definir el versionamiento se pudo obserar los tags del repositorio, y el versionaiento es 1.0 

## :woman: Actores

* **Carol Tatiana Cely Rodriguez** 

## :page_with_curl: Descripción

Se contruyo una interfaz funcional la cual permite la creacion de las funciones lambda al momento de correr el servidor, estas permiten hacer el GET y el POST sin necesidad de servicios extra, de esta manera tambien lee el tipo del archivo para mostrarlo con el content-type respectivo.
