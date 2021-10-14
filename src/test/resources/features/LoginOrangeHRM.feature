# new feature
# Tags: optional

Feature: Yo como administrativo puedo iniciar sesion en el aplicativo


  @validSesion
  Scenario: Inicio sesion valido
    Given necesito ingresar al sistema OrangHRM
    When ingreso un Admin
    And  una admin123
    Then al dar click en el boton Login, debe ingresar al sistema




