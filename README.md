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

#### Configurar base de datos

Para configurar la base de datos en un proyecto con sprint boot asegurese de tener importadas las librerias de JPA y el conector de la base de datos de acuerdo al motor que va a utilizar (MySQL, PostgreSQL, Oracle ...)

##### Importar JPA

- Busque el archivo **pom.xml** de su proyecto 
- Identifique el tag **dependencies**
- Dentro del tag dependencies agregue el siguente comando para importar la libreria de JPA

```

<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

```
- Ajuste las identaciones de ser necesario

#### Configurar MySQL DB

Si el motor de base de datos que va ha utilizar en el proyecto es MySQL siga estos pasos para configurar la base de datos.

##### Importar Conector para MySQL
- Busque el archivo **pom.xml** de su proyecto 
- Identifique el tag **dependencies**
- Dentro del tag dependencies agregue el siguente comando para importar la libreria de JPA

```
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
</dependency>

```

##### Configurar conexion a base de datos MySQL

dentro del archivo **application.properties** ubicado en **src/main/resources** coloque las siguentes sentencias

```

spring.datasource.url=jdbc:mysql://localhost:3306/nombre_de_la_base_de_datos
spring.datasource.username=tu_usuario_de_mysql
spring.datasource.password=tu_contraseña_de_mysql
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

```

**Nota: Recuerde cambiar los paremetros de acuerdo al nombre de usuario de su base de datos, contraseña y nombre de la base de datos**

##### Ejecutar Mysql server con Docker

Abra una terminal en su equipo. **Nota: Docker debe estar instalado y corriendo en su equipo**

Para verificar que se esta ejecutando docker ejecute el siguente comando

```

docker ps

```

No se debe generar ningun error al ejecutar este comando

Ejecute el siguente comando para correr el servidor de mysql

```

docker run -d --name=mysql-container -e MYSQL_ROOT_PASSWORD=tu_contrasena -e MYSQL_USER=tu_usuario -e MYSQL_PASSWORD=tu_contrasena -e MYSQL_DATABASE=nombre_de_la_base_de_datos -p 3306:3306 mysql:latest


```

Aqui hay una breve explicación de los parámetros utilizados en el comando:

```
* -d: Ejecuta el contenedor en segundo plano (modo daemon).
* --name=mysql-container: Asigna un nombre al contenedor, en este caso, "mysql-container".
* -e MYSQL_ROOT_PASSWORD=tu_contrasena: Establece la contraseña del usuario root de MySQL.
* -e MYSQL_USER=tu_usuario: Establece el nombre de usuario personalizado que deseas crear.
* -e MYSQL_PASSWORD=tu_contrasena: Establece la contraseña para el usuario personalizado.
* -e MYSQL_DATABASE=nombre_de_la_base_de_datos: Crea una base de datos con el nombre especificado.
* -p 3306:3306: Mapea el puerto 3306 del contenedor al puerto 3306 del host. Esto permite acceder a la base de datos MySQL desde fuera del contenedor.
```

#### Configurar PostgreSQL DB

Si el motor de base de datos que va ha utilizar en el proyecto es MySQL siga estos pasos para configurar la base de datos.

##### Importar Conector para PostreSQL
- Busque el archivo **pom.xml** de su proyecto 
- Identifique el tag **dependencies**
- Dentro del tag dependencies agregue el siguente comando para importar la libreria de JPA

```

<dependency>
      <groupId>org.postgresql</groupId>
      <artifactId>postgresql</artifactId>
      <scope>runtime</scope>
</dependency>

```

##### Configurar conexion a base de datos PostgreSQL

dentro del archivo **application.properties** ubicado en **src/main/resources** coloque las siguentes sentencias

```

spring.datasource.url=jdbc:postgresql://192.168.1.4:5432/users
spring.datasource.username=postgres
spring.datasource.password=mysecretpassword
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update

```

**Nota: Recuerde cambiar los paremetros de acuerdo al nombre de usuario de su base de datos, contraseña y nombre de la base de datos** 


#### Consulta personalizada

```

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query("SELECT u FROM Usuario u WHERE u.email = :correo AND u.username = :nombreDeUsuario")
    Usuario findUsuarioPorEmailYUsername(@Param("correo") String email, @Param("nombreDeUsuario") String username);
}

```

```

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmailAndUsername(String email, String username);
}

```

```

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String username;
    
    // Otros campos y getters/setters
}

```

#### Guardar un nuevo registro

```

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}

```

#### Actualizar un registro

```

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product updateProduct(Long productId, Product updatedProduct) {
        // Verificar si el producto existe
        Product existingProduct = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));

        // Actualizar los campos del producto existente con los valores del producto actualizado
        existingProduct.setName(updatedProduct.getName());
        existingProduct.setPrice(updatedProduct.getPrice());

        // Guardar la actualización en la base de datos
        return productRepository.save(existingProduct);
    }
}

```

#### Eliminar un registro

```

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public void eliminarUsuarioPorId(Long id) {
        usuarioRepository.deleteById(id);
    }
}

```

#### Consultar por ID

```

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElse(null); // Devuelve null si el usuario no se encuentra
    }
}

```


#### Usar query params

```

@GetMapping(value = "")
  public ResponseEntity<Object> paymentProcess(
      @RequestParam(name="date") Optional<String> dateQuery,
      @RequestParam(name="authorization_code") Optional<String> authQuery,
      @RequestParam(name="store_number") Optional<String> storeNumberQuery
      ) {
    try {
      String date = dateQuery.orElse(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
      String authCode = authQuery.orElse(null);
      String storeNumber = storeNumberQuery.orElse(null);

      List<PaymentsResponse> list = paymentProcessorInteractor.proccessPayment(date, authCode, storeNumber);
      return new ResponseEntity<>(list, HttpStatus.OK);
    } catch(Exception e) {
      return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
 
 ```
 
 
#### Usar Path param
 
 ```
@RequestMapping("/usuarios")
public class UsuarioController {
    @GetMapping("/{id}")
    public ResponseEntity<String> obtenerUsuarioPorId(@PathVariable Long id) {
        // Aquí puedes realizar operaciones para buscar el usuario con el ID proporcionado.
        // En este ejemplo, simplemente devolvemos un mensaje de respuesta con el ID recibido.
        return ResponseEntity.ok("ID del usuario recibido: " + id);
    }
}

```

