# Getting started

### Preconditions to run the project
Java and Maven must be installed on the machine.

### The project directory structure
The project has build scripts for Maven, and follows the standard directory structure used in most Serenity projects:
```Gherkin
src
  + main
  + test
    + java                        Test runners and supporting code
    + resources
      + features                  Feature files
     + search                    Feature file subdirectories 
             GetInTouch.feature
```


## The scenario

```Gherkin
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
```

## Executing the tests
To run the sample project, you can either just run the `CucumberTestSuite` test runner class, or run either `mvn verify` from the command line.

By default, the tests will run using Chrome. You can run them in Firefox by overriding the `driver` system property, e.g.
```json
$ mvn clean verify -Ddriver=firefox
```
