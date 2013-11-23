# Suposiciones y decisiones

Los juegos que están fuera de stock se localizan fácilmente porque es algo indicado por la página, pero no ocurre lo
mismo con los que aún no han salido pero se pueden reservar. En ese caso se busca en el título el texto 'Pre-Order' o
en la descripción 'Fecha de lanzamiento', los que cumplan esta condición se considera que están para reservar.

En los juegos de PC aparecen juegos de otras plataformas, al menos de PS3 y Xbox 360 que haya visto. Lo que se hace en
este caso es introducir un método abstracto hasSpecificPlatformErrors en GameParser que en su implementación para
PC indica que estos no son juegos de la plataforma. En el resto de implementaciones ahora mismo siempre devuelve false.

Existen juegos que entran dentro de un pack que no es oficial. Por ejemplo, Un mando de Xbox One con Forza 5, no es una
edición especial del juego sino una oferta de MediaMarkt. Este tipo de elementos que entran en accesorios para
MediaMarkt no es contemplado por el parseador, porque ¿aún no se me ha ocurrido una forma elegante de hacerlo?


# ¿Por qué no se ha hecho TDD?

La mayor dificultad de este ejercicio reside en el análisis y extracción de información de la web de MediaMarkt, cosa
que se hace con HtmlUnit. Si desconfiaramos de HtmlUnit como herramienta usaríamos otra por lo que no merece la pena
hacer tests en ese frente.

Por lo tanto nos queda hacer TDD para diseñar todos los componentes que forman parte de nuestra solución interna. En
este caso se trata de operaciones sencillas que se reduce a limpiar la entrada y formar un objeto Videogame, por lo que
actualmente el uso de TDD no me habría aportado una solución mucho más optima o limpia.

# Log de trabajo

## 20 de Noviembre de 2013: 1 hora

* Carga del proyecto en el IDE.
* Inclusión de Log4j como librería de logging.
* Familiarización con HtmlUnit.

## 22 de Noviembre de 2013: 2 horas y media

* Lectura de una página de juegos de PS3.
* Parser para un videojuego dado el elemento HTML que lo conforma.
* Recorrido de todas las páginas de la plataforma PS3.
* Se parsea todo el contenido de PS3.

## 23 de Noviembre de 2013: 2 horas y 15 minutos

*Tag V1*

* Refactorización para que toda la lógica común se contenga en PageParser y GameParser y la específica en un GameParser
de la plataforma buscada.
* Inclusión del campo Availability al aparecer out of stock en XBOX 360 un juego.
* Se parsea todo el contenido de XBOX 360.
* Se parsea todo el contenido de Wii.
* Se parsea todo el contenido de PS4.
* Cuando aparece Pre-Order en el título del juego se crea con Availability.Preorder (visto parseando juegos de PS4).
* Se parsea todo el contenido de Xbox One.
* Se parsea todo el contenido de Wii U.
* Se parsea todo el contenido de Nintendo 3DS.
* Se parsea todo el contenido de PS Vita.
* Se parsea todo el contenido de PC.

## 23 de Noviembre de 2013: 1 hora

*Tag V2*

* Refactorización para aumentar la legibilidad.
