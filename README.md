<div align="left">
    <a href="https://www.uptc.edu.co/sitio/export/sites/default/portal/.content/imagenes/header-v2/uptc_log_2021.png_1492831668.png">
        <img width="250" src="https://www.uptc.edu.co/sitio/export/sites/default/portal/.content/imagenes/header-v2/uptc_log_2021.png_1492831668.png" alt="Banco Galicia"/>
    </a>
  <blockquote>
    PROGRAMACION III - 2023 - II
  </blockquote>
</div>
<br/>


# ms-users

### Proyecto Spring Boot: Basic CRUD

Este proyecto consiste en un CRUD expuesto mediante una API REST, simulando interacciones a una base de datos a nivel de
`service`.  
El objetivo es proporcionar un quickstart siguiendo convenciones y buenas prácticas en cuanto a la estructura y contenido
de una aplicación Spring Boot.
En este proyecto se implementa el modelo de usuario y el modelo rol con el fin de almacenar esta informacion en una base de datos postgresql

###### Aclaraciones importantes
- JDK 17
- Spring boot core 3.1.4
- Maven
- Postgresql
- Usa spring-boot-starter-validation para realizar validacion y sanitizacion de datos
- Usa spring-boot-starter-data-jpa para la conexion a la base de datos y la administracion de las entidades 
- Se usa implictamente el framework Hibernate
- Se usa jackson-databind para trasnformar la data proviniente del request de snacke_case a camelCase
- Para consumir los servicios el body se debe enviar en snacke_case y con jackson-databind se transforma en camelCase
- Se usa un conector para postgresql con el fin de realizar la conexion con la DB

###### Ejecutar proyecto localmente - Modo standalone

Para ejecutar el proyecto en forma local basta con ejecutar el siguiente comando:

```bash
mvn spring-boot:run
```

###### Ejecutar proyecto localmente - Modo container


###### Documentación relacionada
* [Documentación Docker](https://docs.docker.com/)
* [Fabric8 Maven Plugin](https://maven.fabric8.io/)