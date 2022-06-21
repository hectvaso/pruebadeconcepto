# Disyuntor y reintento con Spring Cloud Resilance4j

Introducción
Con el creciente número de servicios, es posible que los servicios necesiten comunicarse con otros servidores de forma sincrónica y, por lo tanto, volverse dependientes del servicio ascendente. Cualquier problema durante la comunicación con los servicios ascendentes se propagará a los servicios descendentes.

Para proteger los servicios de tales problemas, podemos usar algunos de los patrones para proteger el servicio. Entonces, hoy vamos a ver dos de estos, es decir, el disyuntor y el mecanismo de reintento.

Veamos primero el mecanismo de reintento.
---
## Tabla de Contenido

- [Detalle de Funcionalidades](#detalle-de-funcionalidades)
- [Arquitectura](#arquitectura)
- [Construido con](#construido-con)
- [Desarrollo](#desarrollo)
- [Seguridad](#seguridad)
- [Endpoints](#endpoints)
- [Licencia](#licencia)
---

## Descripción

Agrupación de las operaciones para el dominio de negocio ***autenticación***.

## Detalle de Funcionalidades

Las siguientes son las funcionalidades presentes en este repositorio:

- [consultarfcaperfil](src/main/java/com/bolivar/comunes/autenticacion/consultarfcaperfil/README.md)
- [consultarfcausuario](src/main/java/com/bolivar/comunes/autenticacion/consultarfcausuario/README.md)
- [consultarperfilesusuarioldap](src/main/java/com/bolivar/comunes/autenticacion/consultarperfilesusuarioldap/README.md)
- [crearpreguntasexperian](src/main/java/com/bolivar/comunes/autenticacion/crearpreguntasexperian/README.md)
- [generartokenexpirian](src/main/java/com/bolivar/comunes/autenticacion/generartokenexpirian/README.md)
- [loginparaappexternas](src/main/java/com/bolivar/comunes/autenticacion/loginparaappexternas/README.md)
- [obtenercodigosotpexperian](src/main/java/com/bolivar/comunes/autenticacion/obtenercodigosotpexperian/README.md)
- [obtenerdatosexperian](src/main/java/com/bolivar/comunes/autenticacion/obtenerdatosexperian/README.md)
- [retirarjwt](src/main/java/com/bolivar/comunes/autenticacion/retirarjwt/README.md)
- [validarcodigootp](src/main/java/com/bolivar/comunes/autenticacion/validarcodigootp/README.md)
- [validarpreguntasexperian](src/main/java/com/bolivar/comunes/autenticacion/validarpreguntasexperian/README.md)

---

## Arquitectura
Descripción de la arquitectura

## Construido con

El código se encuentra implementado con Java 11 y Gradle 6.6.1 usando las siguientes librerías:

- Lombok - Para simplificar la creación de los medios de acceso a datos de un objeto
- Oracle - Para conexión de base de datos en Oracle
- MyBatis - Para la persistencia de datos entre objetos y procedimientos almacenados
- AWS SDK V2 - Para la conexión al parameter store y a DynamoDB

## Desarrollo
1. Instale Java 11 y un IDE de desarrollo como Eclipse o IntelliJ.
2. Clone este repositorio.
3. Permita la construcción del proyecto con gradle.
4. Inicialice el proyecto
5. Abra http://localhost/autenticacion/swagger-ui/index.html para visualizar la lista de apis

Para ejecutar las pruebas unitarias:
1. Configure sonar-proyect.properties.
2. Corra el Sonar en local.
3. Ejecute el proyecto desde test en gradle.

## Seguridad

---

## Endpoints

- **DEV**
    - API Gateway:  https://fz73xehwah.execute-api.us-east-1.amazonaws.com/dev/autenticacion

- **STAGE**
    - API Gateway: https://c4huz7dmpc-vpce-0d1e15f4e7cf53d97.execute-api.us-east-1.amazonaws.com/stage/autenticacion

- **PROD**
    - API Gateway: https://03l44gahq8-vpce-0316f1f34c146e45d.execute-api.us-east-1.amazonaws.com/prod/autenticacion
    
---

## Licencia

![License](https://img.shields.io/badge/Licencia-Seguros%20Bolivar-green)
- Copyright 2022 ©