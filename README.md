PROYECTO: OpenCart - Prueba E2E Guest Checkout con Serenity BDD + Maven + CSV

REQUISITOS:
- Java 11+
- Maven 3.8+
- Google Chrome instalado
- (Opcional) Eclipse IDE

PASOS PARA EJECUTAR:
1) Clonar el repositorio:
   git clone <URL_DEL_REPO>
   cd opencart-serenity-e2e

2) Ejecutar pruebas (por defecto Chrome):
   mvn clean verify

   (Opcional) Cambiar navegador:
   mvn clean verify -Dwebdriver.driver=chrome

3) Ver reportes Serenity:
   Abrir en el navegador:
   target/site/serenity/index.html

DATOS (CSV):
- Archivo: src/test/resources/data/checkout.csv
- Cada fila del CSV ejecuta 1 escenario E2E completo.
- Las columnas incluyen product1, product2 y los datos para Guest Checkout.

NOTAS:
- Si el sitio demora en cargar regiones luego de elegir país, el framework espera a que el combo "zone/region" esté habilitado.
