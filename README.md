# Taller-Evaluativo
**Patron de diseño**
Para este proyecto el patrón de proyecto usado fue el de observer, ya que era el que mas se adaptaba al proyecto, para la implementacion de este lo hice con una interfaz, que definia el metodo que iban a tener los dos agentes en este caso el metodo informar que es aquel que imprime en consola.

## Diagramas

- Diagrama de clases
  
<img width="1714" height="1306" alt="Diagrama en blanco" src="https://github.com/user-attachments/assets/e9bb1995-3c65-4980-8c5a-d8742b8d8ec8" />

- Diagrama de contexto

<img width="540" height="936" alt="Diagrama de contexto" src="https://github.com/user-attachments/assets/c1775555-e51c-4649-8501-39c991b16702" />

- Diagrama de casos de uso

<img width="1991" height="840" alt="Diagrama casos de uso" src="https://github.com/user-attachments/assets/a8ad2593-17b1-4877-99be-636eb61a5ed3" />

## Epicas,Feature e Historias de usuario

- **ÉPICA 1: Gestión de Productos**

Como cliente, quiero gestionar el stock de productos en el sistema, para poder mantener actualizada la información de inventario y facilitar la toma de decisiones.

**Features**

- Añadir producto al sistema
  Permitir registrar un producto con su nombre, precio, cantidad inicial y categoría.

- Modificar stock de producto
  Permitir actualizar la cantidad de un producto ya existente.

**Historias de Usuario (HU)**

HU1: Registro de productos
Como administrador, quiero añadir un producto con nombre, precio, cantidad y categoría, para que el sistema gestione el inventario desde cero.

**Criterios de aceptación:**

- El producto debe guardarse.

- Debe mostrarse un mensaje de confirmación al registrarlo.

**HU2: Actualización de stock**
Como administrador, quiero modificar la cantidad de un producto existente, para mantener actualizado el inventario.

**Criterios de aceptación:**

- El sistema debe permitir incrementar o reducir la cantidad.

- El cambio debe reflejarse inmediatamente.

- El sistema debe notificar a los agentes registrados.

**ÉPICA 2: Notificaciones de Stock**

Como cliente, quiero que el sistema notifique automáticamente los cambios en el stock, para poder actuar a tiempo cuando haya problemas de inventario.

**Features**

- Agente de Log
  Registrar en consola cada modificación de stock de un producto.

- Agente de Advertencia
  Alertar cuando un producto tenga menos de 5 unidades disponibles.

**Historias de Usuario (HU)**

HU3: Registro en consola de cambios
Como agente de log, quiero escribir en consola cada vez que se modifique el stock de un producto, para mantener un historial de cambios.

**Criterios de aceptación:**

-Cada modificación debe generar un mensaje en consola.

-El mensaje debe mostrar nombre del producto y unidades disponibles.

**HU4: Alerta por bajo stock**
Como agente de advertencia, quiero emitir una alerta cuando el stock de un producto sea menor a 5 unidades, para que se pueda reabastecer oportunamente.

**Criterios de aceptación:**

- Cuando el stock baje a menos de 5, debe imprimirse un mensaje de alerta en consola.

- El mensaje debe identificar el producto afectado.

**ÉPICA 3: Calidad y Buenas Prácticas**

Como desarrollador, quiero que el sistema siga principios de calidad (SOLID, pruebas, cobertura), para asegurar mantenibilidad y confiabilidad.

**Features**

- Pruebas unitarias con JUnit
  Validar el correcto funcionamiento de los agentes y la gestión de stock.

- Integración con Jacoco y Sonar
  Generar reportes de cobertura y calidad de código.

**Historias de Usuario (HU)**

**HU5: Pruebas unitarias de agentes**
Como desarrollador, quiero ejecutar pruebas unitarias sobre la gestión de stock y los agentes, para comprobar que el sistema funciona como se espera.

**Criterios de aceptación:**

  - Deben ejecutarse con Maven (mvn test).
  - Deben cubrir la mayoria de casos posibles.

**HU6: Métricas de calidad**
Como desarrollador, quiero ejecutar Jacoco y Sonar para revisar la cobertura del código, para garantizar un mínimo del 80%.

**Criterios de aceptación:**

- Jacoco debe generar reporte HTML.

- El reporte debe reflejar mínimo un 80% de cobertura.

## Covertura de pruebas

- SonarQube
<img width="1362" height="527" alt="image" src="https://github.com/user-attachments/assets/e11c1b4a-147f-4b83-838d-7e8366a3b844" />

- Jacoco
<img width="1224" height="184" alt="image" src="https://github.com/user-attachments/assets/e642e129-2a1b-4d43-913a-d66c445b0c55" />

## Pasos a seguir y evidencias de funcionamineto 

- 1. Colocar en consola en el carpeta donde se encuentra el proyecto, el comando : **mvn clean compile**
     <img width="1272" height="175" alt="image" src="https://github.com/user-attachments/assets/4bfa2136-f648-4b79-b5b8-b42554e882e0" />
     <img width="1270" height="418" alt="image" src="https://github.com/user-attachments/assets/e6264372-62e5-471f-9893-88617e21c7f3" />

- 2. Para correr el proyecto,ponemos el comando : **mvn spring-boot:run**
 <img width="1249" height="426" alt="image" src="https://github.com/user-attachments/assets/a4988bc3-57d2-42a0-beaa-6edc6e00ac29" />

- 3. Ahora desde la consola de nuestro computador para agregar un proyecto lo haremos siguiendo el ejemplo:
     curl -X POST http://localhost:8080/productos   -H "Content-Type: application/json"   -d '{"nombre":"Celular","precio":2000,"stock":10,"categoria":"Tecnología"}'
  
  <img width="655" height="77" alt="image" src="https://github.com/user-attachments/assets/8438f3a7-bd63-48b4-8c07-f529254c6a2b" />

     
- 4. Para comprobarlo, buscamos en nuestro navegaodr www.localhost:8080/productos

  <img width="1365" height="312" alt="image" src="https://github.com/user-attachments/assets/ecbc344c-5608-4d8a-81a3-42f8037a0d2c" />

- 5. Para editar el stock del producto tenemos dos opciones:
     - Comprar más unidades, para ello hacemos el comando: curl -X PUT http://localhost:8080/productos/Celular/comprar/5
    <img width="652" height="72" alt="image" src="https://github.com/user-attachments/assets/466b8970-6262-43ce-92ed-b88e5c9b2672" />

    Al tiempo en la consola vemos el mensaje del agente involucrado, en este caso el AgenteLog:

    <img width="1263" height="52" alt="image" src="https://github.com/user-attachments/assets/7dbcb12a-1432-4d19-b4f7-4927aa9f6606" />

    - Vender unidades, para esto hacemos el comando: curl -X PUT http://localhost:8080/productos/Celular/vender/13

 <img width="654" height="73" alt="image" src="https://github.com/user-attachments/assets/03f43d73-3cf1-4c2b-9a35-8f86c854f203" />

    Ya que ahora nos quedan dos unidades, vemos los dos mensajes de los agentes.
    <img width="659" height="46" alt="image" src="https://github.com/user-attachments/assets/4477c746-90f7-434a-aed3-714aa9dc6b60" />









