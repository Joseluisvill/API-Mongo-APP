# API Mongo App

## Requisitos para la utilización
- Instalar maven sigan los pasos del [video](https://www.youtube.com/watch?v=C_RFcuHf3ao)
- Descargar JDK desde [aqui](https://adoptopenjdk.net/) version 11 LTS con JVM OpenJ9
- Agregar el PATH de la ubicación de la instalación del JDK 11 en las variables de entornos, crando una nueva variable `JAVA_HOME`
- Verificar que el JDK 11 esta en el Netbeans, abren netbeans, luego se van a  `tools`, luego a `java`, luego a `maven`, luego verifican el `Default JDK` que este JDK 11.


## Pasos a tener en cuenta para la utilización:

1- Clonar o descargar el repositorio

2- Dar click derecho al proyecto y clean and build

3- Dar click derecho al proyecto ir donde dice `Run Maven` despues click `Goals` donde dice `Goals` escribir `clean install payara-micro:bundle payara-micro:start` y guardarlo

4- Para ejecutarlo irse donde dice `Run Maven` y click a `clean install payara-micro:bundle payara-micro:start`

## Cuenta con autenticación Basica
Username= user
Password= admin

# Cuenta con los siguientes Endpoints:

## Reportes

- ### Para agregar reportes 

`/API-APP/resources/reportes/add`

- ### Para agregar un estado nuevo a un reporte ya creado 

`/API-APP/resources/reportes/addEstado/{identificador}` 

el identificador es del reporte al cual iremos agregar otro estado

- ### Para ver todos los reportes

`/API-APP/resources/reportes/all`

## Usuarios
- ### Para agregar un usuario
`/API-APP/resources/usuario/add`

- ### Para ver todos los usuarios 
`/API-APP/resources/usuario/all`

- ### Para eliminar un usuario por el identificador 
`/API-APP/resources/usuario/delete/{id}` 

en el id va el identificador del usuario

- ### Para buscar un usuario por id 
`/API-APP/resources/usuario/search/{id}`

# Proximos endpoints que se estaran desarrollando
- para actualizar campos especificos tanto del usuario como del reporte
- para buscar mostrar un reporte en especifico
y más......

