<a name="top"></a>
# API Mongo App
## Índice
* [Requisitos para la utilización](#Requisitos)
* [Pasos para descargar el proyecto](#proyecto)
* [Cuenta con autenticación Básica](#autenticación)
* [Cuenta con los siguientes Endpoints](#Endpoints)
*  * [Reportes](#Reportes)
*  * [Usuarios](#Usuarios)
*  * [Roles](#Roles)
<a name="Requisitos"></a>
## Requisitos para la utilización
---
1. Instalar maven sigan los pasos del [video](https://www.youtube.com/watch?v=C_RFcuHf3ao).
2. Descargar JDK desde [aquí](https://adoptopenjdk.net/) versión 11 LTS con JVM OpenJ9 e instalarlo.
3. Agregar el PATH de la ubicación de la instalación del JDK 11 `Ejemplo C:\Program Files\AdoptOpenJDK\jdk-11.0.11.9-openj9\bin` en las variables de entornos, creando una nueva variable `JAVA_HOME` y agregandolo en`path`como una nueva.
4. Verificar que el JDK 11 está en el Netbeans, abren netbeans, luego se van a  `tools`, luego a `java`, luego a `maven`, luego verifican el `Default JDK` que este JDK 11. __En caso de que no esté haga lo siguiente__, en esa misma ventana le dan clik al boton `Manage Java Platforms`, luego click en `Add Platform`, luego click `Next`, seguido buscan donde está instalado JDK `C:\Program Files\AdoptOpenJDK\jdk-11.0.11.9-openj9` y lo seleccionan y le dan `Next` y terminan de aplicar los cambios, reinician el NetBeans y realizan el __Paso 4__
5. Buscamos la carpeta del maven que se llama `apache-maven-3.8.1` y nos dirigimos a `conf`, luego el archivo que dice `settings.xml` lo abrimos con el bloc de notas, y buscamos donde dice: `<mirror>
      <id>maven-default-http-blocker</id>
      <mirrorOf>external:http:*</mirrorOf>
      <name>Pseudo repository to mirror external repositories initially using HTTP.</name>
      <url>http://0.0.0.0/</url>
      <blocked>true</blocked>
    </mirror>` 

    lo borramos y copiamos `<!--mirror>
      <id>maven-default-http-blocker</id>
      <mirrorOf>external:http:*</mirrorOf>
      <name>Pseudo repository to mirror external repositories initially using HTTP.</name>
      <url>http://0.0.0.0/</url>
      <blocked>true</blocked>
    </mirror-->` guardamos y listo.

<a name="proyecto"></a>
## Pasos para descargar el proyecto:
---

1- Clonar o descargar el repositorio

2- Dar click derecho al proyecto y clean and build

3- Dar click derecho al proyecto ir donde dice `Run Maven` después click `Goals` donde dice `Goals` escribir `clean install payara-micro:bundle payara-micro:start` y guardarlo

4- Para ejecutarlo irse donde dice `Run Maven` y click a `clean install payara-micro:bundle payara-micro:start`

<a name="autenticación"></a>
## Cuenta con autenticación Básica
Username= user
Password= admin

<a name="Endpoints"></a>
# Cuenta con los siguientes Endpoints:
<a name="Reportes"></a>
## Reportes

- ### Para agregar reportes 

`/API-APP/resources/reportes/add`

- ### Para agregar un estado nuevo a un reporte ya creado 

`/API-APP/resources/reportes/addEstado/{identificador}` 

el identificador es del reporte al cual iremos agregar otro estado

- ### Para ver todos los reportes

`/API-APP/resources/reportes/all`

- ### Para buscar el reporte

`/API-APP/resources/reportes/search/{id}`

podrán actualizar el reporte, pero no los estados.
- ### Para actualizar el reporte

`/API-APP/resources/reportes/update/{id}`

podrán actualizar el reporte, pero no los estados, ni el estado actual del reporte.

<a name="Usuarios"></a>
## Usuarios

- ### Para agregar un usuario
`/API-APP/resources/usuario/add`

- ### Para agregar usario, deberia utilizarze en android
`/API-APP/resources/usuario/addCaptador`

- ### Para agregar roles al usuario
`/API-APP/resources/usuario/addRole/{idUsuario}/{idRole}`

el idUsuario sera el identificador del usuario, y el idRole, es el identificador del rol el número

- ### Para ver todos los usuarios 
`/API-APP/resources/usuario/all`

- ### Para ver todos los usuarios activos
`/API-APP/resources/usuario/allActivo`

- ### Para verificar si existe el usuario
`/API-APP/resources/usuario/checkUsuario`

- ### Para eliminar un usuario por el identificador 
`/API-APP/resources/usuario/delete/{id}` 

en el id va el identificador del usuario

- ### Para buscar un usuario por id 
`/API-APP/resources/usuario/search/{id}`

- ### Para actualizar un usuario
`/API-APP/resources/usuario/update`

<a name="Roles"></a>
## Roles

- ### Para agregar un rol
`/API-APP/resources/roles/add`

- ### Para ver los roles existentes
`/API-APP/resources/roles/all`

- ### Para eliminar un rol por el identificador 
`/API-APP/resources/roles/delete/{id}` 

- ### Para actualizar un rol 
`/API-APP/resources/roles/update/{id}`

[Subir](#top)


