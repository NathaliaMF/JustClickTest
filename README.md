#   JustClick Test

En este repositorio se encuentran dos microservicios, los cuales son : 
| Microservicio | Puerto |
| ------ | ------ |
| JustClickPrueba | 9990 |
| JustClickSchedule | 9995 |

# JustClickPrueba
Este microservicio es el que se encarga de la redireccion segun el parametro enviado por medio del API. El API para consumir dicho servicio es:

```sh
/JustClick/link/{string}
```
{string} es el parametro a recibir para la redirección del API. Los parametros configurados por ahora son:
| Parametro | Redirección |
| ------ | ------ |
| hola | https://www.google.com/search?q=hola |
| mundo | https://www.google.com/search?q=mundo |
| justclick | https://www.google.com/search?q=justclick |
| prueba | https://www.google.com/search?q=prueba |
El archivo clicks.json se lo guarda en la siguiente rurta:
```sh
d:/clicks.json
```
# JustClickSchedule
Este microservicio se encargara de ejecutar en el quinto minuto de cada hora una tarea programada que lea el archivo clicks.json y lo guarde en una instancia de elasticsearch de docker.
Para consultar en elasticsearch la data se consulta el siguiente indice:
- clicks

# Pasos para crear el contenedor de docker para elasticsearch
1. Descargar una imagen para elasticsearch
```sh
docker pull elasticsearch:7.10.1   
```
2. Crear el contenedor
```sh
docker run -d --name elasticsearch -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" elasticsearch:7.10.1
```

# Base de datos
Se creo la tabla "urls" con los siguientes datos: 
| Campo | Tipo de variable | Descripcion |
| ------ | ------ |------ |
| id | Integer | id unico del parametro |
| element | Character varying | parametro donde se consultara |
| directions | Character varying | url donde se hara la redireccion |
| maximum | Integer | indica el numero de veces que se podra consumir el api con dicho parametro |
| use | Integer | indica el numero de veces que se ha ejecutado el parametro  |

El archivo de base de datos tiene como nombre start.sql y se encuentra en el repositorio
