#language: es

Característica: Se realiza una compra de principio a fin

  Antecedentes:
    Dado que fer ingresa a la pagina de Evalart
    Y que fer ingresa sus credenciales
      | usuario | clave                                            |
      | 740524  | 10df2f32286b7120MS00LTQyNTA0Nw==30e0c83e6c29f1c3 |

  @RutaCritica
    @InteractuarConElementos
  Escenario: : Se requiere hacer una interaccion con cada elemento
    Dado que fer verifica la cantidad de veces a ingresar
    Cuando Cuando realiza las interacciones con los elementos
    Entonces Verifica el mensaje: Felicidades, has terminado la prueba exitosamente