/*
 * Modify: 17 nov 2023
 * Author: Calle Serrano, Ángel
 * FileUtils.java
 */
package sonar_salud.utils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import sonar_salud.constants.ErrorsAndAlerts;
import sonar_salud.constants.Symbol;

/**
 * The Class FileUtils.
 */
public class FileUtils {

	private FileUtils() {
	}

	/**
	 * Checks if is file.
	 *
	 * @param routeFile the route file
	 * @return true, if is file
	 */
	public static boolean isFile(String routeFile) {
		File archivo = new File(routeFile);
		return archivo.exists();
	}

	/**
	 * Verifica si una carpeta existe y la crea si no es así.
	 * 
	 * Verifica si un archivo existe y lo crea si no es así.
	 * 
	 * @param routeFile La ruta completa del archivo a verificar o crear.
	 */
	public static void createFile(String routeFile) {
		File archivo = new File(routeFile);

		// Verifica si la carpeta existe. Si no, la crea.
		if (!archivo.getParentFile().exists()) {
			if (archivo.getParentFile().mkdirs()) {
				System.out.println(ErrorsAndAlerts.FOLDERS_CREATED_SUCCESSFULLY);
			} else {
				System.err.println(ErrorsAndAlerts.ERROR_CREATING_FOLDERS);
				return;
			}
		}

		// Verifica si el archivo existe. Si no, lo crea.
		if (!archivo.exists()) {
			try (FileWriter writer = new FileWriter(archivo)) {
				writer.write(Symbol.EMPTY_ARRAY);
				System.out.println(ErrorsAndAlerts.FILE_CREATED_SUCCESSFULLY);
			} catch (IOException e) {
				System.err.println(ErrorsAndAlerts.ERROR_CREATING_FILE + e.getMessage());
			}
		}
	}

	/**
	 *
	 * Lee un archivo json y debuelve una lista de mapas.
	 *
	 * @param routeFile the route file
	 * @param gson      the gson
	 * @return the list
	 */
	public static List<Map<String, Object>> readfile(String routeFile, Gson gson) {
		try (FileReader reader = new FileReader(routeFile)) {
			Type typeListUsers = new TypeToken<List<Map<String, Object>>>() {
			}.getType();
			return gson.fromJson(reader, typeListUsers);
		} catch (IOException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

}
