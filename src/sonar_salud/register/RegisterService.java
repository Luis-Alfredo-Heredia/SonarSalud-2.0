/*
 * Modify: 26 dic 2023
 * Author: Calle Serrano, Ángel
 * RegisterService.java
 */
package sonar_salud.register;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import sonar_salud.alerts.AlertsService;
import sonar_salud.constants.EndpointPaths;
import sonar_salud.constants.JsonPropertyName;
import sonar_salud.entity.User;
import sonar_salud.entity.UserFail;
import sonar_salud.utils.FileUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class AlertsService.
 */
public class RegisterService {

	private RegisterService() {
	}

	/**
	 * Lee un archivo JSON que contiene una lista de usuarios y busca si existe un
	 * usuario con el nombre dado.
	 *
	 * @param nick the nick
	 * @return true si el usuario existe, false de lo contrario.
	 */
	public static boolean isUserByName(String nick) {
		Gson gson = new Gson();
		try (FileReader reader = new FileReader(EndpointPaths.DATA_USERS)) {
			Type typeListUsers = new TypeToken<List<Map<String, String>>>() {
			}.getType();
			List<Map<String, String>> listUsers = gson.fromJson(reader, typeListUsers);

			for (Map<String, String> user : listUsers) {
				if (nick.equalsIgnoreCase(user.get(JsonPropertyName.NICK))) {
					return true;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean createNewUser(String username, String email,
									 String password, String confirmPassword,
									 String birthDate
									) {
    	
        // Verifica si las contraseñas coinciden
        if (!password.equals(confirmPassword)) {
            AlertsService.error("Las contraseñas no coinciden.");
            return false;
        }
        
        // Obtiene la lista actual de usuarios del archivo JSON
        List<User> userList = getUserList();

        // Encuentra el último ID y genera el nuevo ID
        int lastId = userList.isEmpty() ? 0 : Integer.parseInt(userList.get(userList.size() - 1).getId());
        String newUserId = String.valueOf(lastId + 1);

        // Crea el nuevo usuario
        User newUser = new User();
        newUser.setId(newUserId);
        newUser.setNick(username);
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setBirthDate(birthDate);


        // Verifica si el correo electrónico ya está en uso
        for (User user : userList) {
            if (email.equals(user.getEmail())) {
                AlertsService.error("El correo electrónico ya está en uso.");
                return false;
            }
        }

        // Añade el nuevo usuario a la lista
        userList.add(newUser);

        // Guarda la lista actualizada en el archivo JSON
        saveUserListToFile(userList);
        AlertsService.correct("Usuario creado exitosamente.");
        return true;
    }

    private static List<User> getUserList() {
        Gson gson = new Gson();
        List<User> userList = null;

        try (FileReader reader = new FileReader(EndpointPaths.DATA_USERS)) {
            Type typeListUsers = new TypeToken<List<User>>() {}.getType();
            userList = gson.fromJson(reader, typeListUsers);
        } catch (IOException e) {
            System.out.println("Problemas al obtener la lista de usuarios.");
            e.printStackTrace();
        }

        if (userList == null) {
            // Si la lista está vacía o hay un error, inicializa una nueva lista
            userList = List.of();
        }

        return userList;
    }

    private static void saveUserListToFile(List<User> userList) {
        Gson gson = new Gson();

        try (FileWriter writer = new FileWriter(EndpointPaths.DATA_USERS)) {
            gson.toJson(userList, writer);
        } catch (IOException e) {
            System.out.println("Problemas al guardar la lista de usuarios en el archivo.");
            e.printStackTrace();
        }
    }
	
	
	
	
	
}
