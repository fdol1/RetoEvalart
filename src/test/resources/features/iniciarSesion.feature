#language: es

Característica: Se realiza inicio de sesion exitoso

  Antecedentes:
    Dado que fer ingresa a la pagina de Evalart

  @RutaCritica
    @IniciarSesion
  Esquema del escenario: Realizar inicio de sesion
    Dado que fer ingresa sus credenciales
      | usuario   | clave   |
      | <usuario> | <clave> |
    Entonces Entonces verifica el titulo Prueba de automatización
    Ejemplos:
      | usuario | clave                                            |
      | 740524  | 10df2f32286b7120Mi00LTQyNTA0Nw==30e0c83e6c29f1c3 |
