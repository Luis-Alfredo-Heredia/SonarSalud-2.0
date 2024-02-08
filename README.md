# SonarSalud

Una aplicación que, a través del análisis de voz y patrones de habla, pueda ofrecer indicadores sobre la salud mental y
el bienestar emocional de los usuarios.

# Configuración de un Proyecto JavaFX en STS o Eclipse con JDK 8

Si estás utilizando **Spring Tool Suite (STS)** o **Eclipse**, y necesitas configurar un proyecto **JavaFX** para
ejecutarse con el **JDK 8**, aquí están los pasos que puedes seguir:

## Asegúrate de tener JDK 8 instalado

1. Verifica que tienes el **JDK 8** instalado en tu máquina.
2. Puedes descargarlo desde la página oficial de Oracle si no lo tienes.

## Configura tu IDE para usar el JDK 8

1. En STS o Eclipse, ve a `Window > Preferences` (en Mac, `Eclipse > Preferences`).
2. Expande `Java` y haz clic en `Installed JREs`.
3. Si el JDK 8 no está listado, añádelo haciendo clic en `Add > Standard VM`, luego navega hasta la carpeta donde está
   instalado tu JDK 8 y selecciónalo.
4. Asegúrate de marcar el JDK 8 como el JRE predeterminado.

## Configura el proyecto para usar JDK 8

1. Haz clic derecho sobre tu proyecto en el explorador de proyectos.
2. Selecciona `Properties > Java Build Path`.
3. En la pestaña `Libraries`, si ves un `JRE System Library` que no es el JDK 8, elimínalo.
4. Haz clic en `Add Library > JRE System Library > Next > Installed JREs`.
5. Selecciona el JDK 8 que configuraste anteriormente y haz clic en `Finish`.

## Agrega las librerías de JavaFX

1. Si JavaFX no está incluido en tu JDK 8 (por ejemplo, si estás utilizando OpenJDK 8), necesitarás descargar las
   librerías de JavaFX y añadirlas manualmente.
2. Puedes encontrar el SDK de JavaFX para Java 8 en sitios como Gluon o buscar en línea las librerías de JavaFX
   compatibles con Java 8.
3. Una vez descargado, descomprime el SDK y copia los JAR necesarios (como `javafx.controls.jar`, `javafx.fxml.jar`,
   etc.) en una carpeta dentro de tu proyecto o en un lugar de tu elección.
4. De nuevo en las propiedades del proyecto, en `Java Build Path`, bajo la pestaña `Libraries`, haz clic en
   `Add External JARs...` y selecciona los JARs de JavaFX que copiaste.

## Configura los argumentos de la VM (si es necesario)

1. Ve a `Run > Run Configurations`.
2. Selecciona tu aplicación JavaFX en la lista de la izquierda.
3. En la pestaña `Arguments`, bajo `VM arguments`, no deberías necesitar argumentos especiales para JavaFX en Java 8,
   pero si los necesitas, aquí es donde los pondrías.

## Ejecuta tu aplicación

1. Asegúrate de que tu clase principal está configurada correctamente en la configuración de ejecución
   (`Run Configurations`).
2. Haz clic en `Run` para iniciar tu aplicación.

Estos pasos deberían configurar tu entorno STS o Eclipse para desarrollar y ejecutar aplicaciones JavaFX utilizando Java
JDK 8. Es importante recordar que si estás utilizando una versión de JavaFX que no está incluida con tu JDK 8, deberás
manejar las librerías manualmente como se describe en el paso 4.
