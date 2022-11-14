# Introducción

El objetivo de este ejercicio es la refactorización de este simple proyecto Java incluyendo aquellas buenas prácticas
de programación y tecnologías que simplifiquen su uso y mantenimiento.

Se trata de una clase con un método público que devuelve la previsión del tiempo de una ciudad en una fecha concreta.

Para ello, esta clase utiliza una API externa (requiere conexión a internet): [www.open-meteo.com](https://www.open-meteo.com) 

Ejemplo:

```java
WeatherForecast weatherForecast = new WeatherForecast();
weatherForecast.getCityWeather("Madrid", new Date());
```


# Ejercicio

El ejercicio consiste en **refactorizar** el código para hacerlo más **mantenible**, ya que el código existente, aunque **funciona**, es muy difícil de entender. 
  
Para ello se pueden realizar múltiples modificaciones siempre que se mantenga el API público. Ejemplos de modificaciones: incluir tests automáticos, extraer métodos, renombrar variables, modificar tipos de datos, crear nuevas clases, añadir librerías, etc. 


# Documentación

La solución debería contener un fichero README donde se respondan estas preguntas:
- ¿Qué has empezado implementando y por qué?
Voy a utilizar la metodoloía TDD así que lo primero que voy a implementar son los TEST con todas las funcionalidades que se esperan. En nuestro caso ya tenemos implementado una clase con un método, así que en base a la funcionalidad de dicho metodo  vamos a realizar todos los test unitarios que consideramos necesarios, para ello crearemos clases y métodos haciendo uso de la librería JUnit y Maven para la ejecución de los diferentes Test.
- ¿Qué problemas te has encontrado al implementar los tests y cómo los has solventado?
- ¿Qué componentes has creado y por qué?
No he creado ningun componente.
- Si has utilizado dependencias externas, ¿por qué has escogido esas dependencias?
He utilizado las dependencias que venian ya implementada en el proyecto.
- ¿Has utilizado  streams, lambdas y optionals de Java 8? ¿Qué te parece la programación funcional?
Conozco la programación funcional de forma superficial y actualmente estoy en fase de aprendizaje, la considero como un buen recurso para poder utilizarla en diferentes proyectos ya que considero que se puede realizar un código mas compactos ahorrando líneas de código y que favorece a la hora de testear el código.
- ¿Qué piensas del rendimiento de la aplicación? 
- ¿Qué harías para mejorar el rendimiento si esta aplicación fuera a recibir al menos 100 peticiones por segundo?
- ¿Cuánto tiempo has invertido para implementar la solución? 
Aquí me gustaría indicar que actualmente no tengo el nivel necesario para resolver este tipo de problemas, ya que tengo que invertir mucho tiempo en realizar investigacion y busqueda de información.
- ¿Crees que en un escenario real valdría la pena dedicar tiempo a realizar esta refactorización?
Considero que es importante a largo plazo tener un código que no solo cumpla con la funcionalidad si no que se un código mas entendible y testeable ya que esto puede ahorrarnos tiempo a futurio en el caso que tengamos que añadirle o modificar una funcionalidad por ejemplo.

# A tener en cuenta

- Se valorará positivamente el uso de TDD, se revisarán los commits para comprobar su uso.
- Se valorará positivamente la aplicación de los principios SOLID y "código limpio".
- La aplicación ya tiene un API público: un método público que devuelve el tiempo en un String. No es necesario crear nuevas interfaces: REST, HTML, GraphQL, ni nada por el estilo.


# Entrega

La solución debe ser comprimida (incluyendo el directorio .git) en un fichero .zip/.tar.gz y enviarlo por email.
