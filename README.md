# APLICACIONES DISTRIBUIDAS (HTTP, SOCKETS, HTML, JS,MAVEN, GIT)

Una aplicación distribuida es una aplicación con distintos componentes que se 
ejecutan en entornos separados, normalmente en diferentes plataformas conectadas a través de una red
 
El objetivo de este laboratorio es crear una aplicación para consultar la información de películas de cine. 
Esta aplicación recibe una frase de búsqueda del titulo de cualquier pelicula y está mostrará una tabla con
información acerca de esta misma. Esta información es sacada del API gratuito https://www.omdbapi.com/. 
De igual manera, se implementa un Caché que permita evitar hacer consultas repetidas al API externo. 
 
 
## Empezando

### 🛠️ Abre y ejecuta el proyecto

**1. Para empezar se clona el repositorio colocando el siguiente comando**

```
git clone https://github.com/carol695/Taller1_AREP.git
```
**2. Ya clonado el repositorio abrimos el laboratorio utilizando cualquier de los siguientes IDE.**

* Intellij.
* eclipse.
* visual Studio code. 

**3. Luego de abrir el laboratorio, corremos el proyecto. Para este caso colocaremos lo siguiente: **

```
git clean package exec:java -D"exec.mainClass"="edu.escuelaing.arem.app.httpServer"
```


Una vez veamos el mensaje de "Listo para recibir ..." entramos al buscador de preferencia y entramos al link http://localhost:35000 alli podremos ingresar el nombre de una película

****
### :chart_with_downwards_trend: Prerrequisitos

-   [Git](https://git-scm.com/downloads) - Sistema de control de versiones
-   [Maven](https://maven.apache.org/download.cgi) - Gestor de dependencias
-   [Java 8](https://www.java.com/download/ie_manual.jsp) - Entorno de desarrollo
-   [Intellij Idea](https://www.jetbrains.com/es-es/idea/download/) (Opcional)

### :construction: Arquitectura propuesta

![image](https://user-images.githubusercontent.com/63822072/216467924-5fa01c56-45fd-44c5-92c2-db300a2bda2c.png)

![image](https://user-images.githubusercontent.com/63822072/216468791-ad18b9b2-342d-44d0-9f4c-dd992f91c172.png)


### :bulb: Construido con

* [Maven](https://maven.apache.org/) - Dependency Management

## :mag_right: Versionamiento

Para definir el versionamiento se pudo obserar los tags del repositorio, y el versionaiento es 1.0 

## :woman: Actores

* **Carol Tatiana Cely Rodriguez** 

## :page_with_curl: Descripción

- `Extensibilidad`:  Existe extensibilidad debido a que se puede cambiar la pagina a la que se quiere traer la información.
- `Patrones`: Se utiliza el patron estructural de fachada, debido a que proporciona una interfaz simplificada, un framework o cualquier otro grupo complejo de clases. 
- `Moduralidad`: En esta aplicación se cuenta con moduralidad, ya que se subdivide esta aplicación en partes más pequeñas, realizando cada una un trabajo un poco independiente de la aplicación. 
