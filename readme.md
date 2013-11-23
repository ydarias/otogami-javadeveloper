Suposiciones y decisiones

Existen juegos que entran dentro de un pack que no es oficial. Por ejemplo, Un mando de Xbox One con Forza 5, no es una
edición especial del juego sino una oferta de MediaMarkt. Este tipo de elementos que entran en accesorios para
MediaMarkt no es contemplado por el parseador, porque ...

Log de trabajo

20 de Noviembre de 2013: 1 hora

* Carga del proyecto en el IDE.
* Inclusión de Log4j como librería de logging.
* Familiarización con HtmlUnit.

22 de Noviembre de 2013: 2 horas y media

* Lectura de una página de juegos de PS3.
* Parser para un videojuego dado el elemento HTML que lo conforma.
* Recorrido de todas las páginas de la plataforma PS3.
* Se parsea todo el contenido de PS3.

23 de Noviembre de 2013:

* Refactorización para que toda la lógica común se contenga en PageParser y GameParser y la específica en un GameParser
de la plataforma buscada.
* Inclusión del campo Availability al aparecer out of stock en XBOX 360 un juego.
* Se parsea todo el contenido de XBOX 360.
* Se parsea todo el contenido de Wii.
* Se parsea todo el contenido de PS4.
* Cuando aparece Pre-Order en el título del juego se crea con Availability.Preorder (visto parseando juegos de PS4).
* Se parsea todo el contenido de Xbox One.
* Se parsea todo el contenido de Wii U.