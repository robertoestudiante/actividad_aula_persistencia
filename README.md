🎯 Actividad: Check-in Aula – Versión con Persistencia
🗓️ Entrega individual: jueves 13 de noviembre de 2025 – 11:00 AM (GMT-3, Uruguay)
🔗 Entrega: link a tu repositorio GitHub (el mismo de la primera entrega), actualizado con los nuevos archivos de persistencia.

📍 Contexto
En esta nueva versión, vas a retomar el trabajo ya entregado en la actividad Check-in Aula (consola + GUI) y modificarlo para agregar persistencia simple.
El objetivo es que el sistema guarde y recupere los registros entre ejecuciones, manteniendo el diseño original y la estructura modular del proyecto.

✅ Requisitos mínimos
Persistencia simple

Podés usar archivos de texto (.txt o .csv), o bien archivos binarios o JSON.

Debe existir una clase que gestione el guardado y la carga, por ejemplo:

 
edu/cerp/checkin/persistencia/ArchivoManager.java
Cada vez que se agregue una inscripción, el sistema debe guardar automáticamente los datos.

Al iniciar, debe leer los datos previos y mostrarlos en la GUI o en consola.

Reutilizar SesionService

No modifiques su lógica principal: en lugar de eso, integrá el guardado/carga desde esta clase o desde un nuevo servicio complementario.

Mantenimiento del funcionamiento GUI y consola

El programa debe seguir ejecutándose por consola o con --gui.

En ambos modos, los datos deben persistir.

Estructura del proyecto actualizada

 
src/ └─ edu/cerp/checkin/ ├─ model/ ├─ logic/ ├─ persistencia/ │ └─ ArchivoManager.java ├─ console/ ├─ ui/ └─ App.java
💡 Sugerencias
🧩 Elección del formato de persistencia
Podés optar por:

Texto plano (.txt): leer/escribir líneas separadas por “|”.

CSV: fácil de abrir con Excel o Google Sheets.

JSON: usando bibliotecas como org.json o Gson (si querés explorar algo más avanzado).

💾 Consejo
Guardá el archivo en una carpeta data/ dentro del proyecto.
Ejemplo: data/inscripciones.csv

🧠 Reflexión para tu README
En el README.md, agregá un breve párrafo explicando:

“Qué tipo de persistencia elegí y por qué fue adecuada para este proyecto educativo.”
