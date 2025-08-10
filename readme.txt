Prueba E2e - Saucedemo

Proyecto de pruebas automatizadas E2E usando Java, Maven, Selenium Webdriver y Junit.

Simula un flujo completo de compra en Saucedemo.

1. Requisitos Previos

- Java JDK versión 11+ (verificar con java -version)
- Apache Maven instalado (verificar con mvn -version)
- Google Chrome instalado.
- Conexión a internet:
  1. Para que Selenium descargue el driver automáticamente mediante Selenium Manager.
  2. Para descargar las librerias de maven usadas en el proyecto.

2. Configuración inicial

- Clonar el repositorio o descargar el proyecto
- Actualizar dependencias Maven: mvn clean install

3. Ejecución de pruebas

- Desde la terminal
  - Abre una terminal en la carpeta raíz del proyecto
  - Ejecuta: mvn clean test

4. Reporte:
   Se generará en la ruta (target/reports/surefire.html)