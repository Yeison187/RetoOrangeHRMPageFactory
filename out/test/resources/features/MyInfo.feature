# new feature
# Tags: optional

Feature: Como usuario quiero ingresar al modulo Mi Info
  para agregar una nueva dependencia y un adjuntar un archivo.

  Background:nueva dependencia y un adjuntar un archivo
    Then se debe mostra el mensaje: Successfully Saved

  Scenario Outline: Agregar nueva dependencia
    Given necesito agregar una nueva dependencia
    When doy clic en el boton add del area Assigned Dependents,diligencio todos los campos <name>,<dependents>,<birth>
    And doy clic sobre el boton save

    Examples:
      | name   | dependents | birth      |
      | Maria  | Child      | 2021-10-29 |
      | Pedro  | prueba      | 2021-11-02 |
      | Tomas  | Child      | 2021-11-09 |
      | Camila | Other      | 2021-11-06 |


  Scenario Outline: Adjuntar archivo
    Given necesito agregar un nuevo archivo
    When doy clic en el boton add del area Assigned Attachments,adjunto el archivo <ruta>
    And diligencio el campo comment <comentario>, doy clic sobre el boton save

    Examples:
      | ruta                                                                                                                           | comentario          |
      | C:\\Users\\YEISON\\Downloads\\automationtesting-trunk\\OrangeHrmPageFactory\\src\\test\\resources\\File\\Archivo_prueba_1.docx | Comentario prueba 1 |
      | C:\\Users\\YEISON\\Downloads\\automationtesting-trunk\\OrangeHrmPageFactory\\src\\test\\resources\\File\\Archivo_prueba_2.docx | Comentario prueba 2 |