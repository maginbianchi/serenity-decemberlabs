#language:es

@GetInTouch
Característica: Get In Touch Form

  Escenario: Se muestran correctamente los campos del formulario Get In Touch
    Dado que soy un usuario que se encuentra en la pagina Get In Touch
    Cuando intento utilizar los diferentes componentes
    Entonces los componentes funcionan correctamente


  Escenario: No se permite enviar el formulario sin nombre
    Dado que soy un usuario que se encuentra en la pagina Get In Touch
    Cuando intento enviar el formulario sin completar el campo nombre
    Entonces el sitio me informa que el campo nombre es requerido


  Escenario: No se permite enviar el formulario sin email
    Dado que soy un usuario que se encuentra en la pagina Get In Touch
    Cuando intento enviar el formulario sin completar el campo email
    Entonces el sitio me informa que el campo email es requerido


  Escenario: No se permite enviar el formulario sin mensaje
    Dado que soy un usuario que se encuentra en la pagina Get In Touch
    Cuando intento enviar el formulario sin completar el campo mensaje
    Entonces el sitio me informa que el campo mensaje es requerido


  Escenario: Enviar formulario
    Dado que soy un usuario que se encuentra en la pagina Get In Touch
    Cuando intento enviar el formulario con los siguientes datos:
      | name            | Magin                    |
      | email           | test@decemberlabs.com    |
      | company         | DecemberLabs             |
      | message         | Hola, esto es una prueba |
      | budget          | $25K-$50K                |
      | houYouHearAbout | Events                   |
      | updates         | false                     |
    Entonces el sitio muestra un congrats