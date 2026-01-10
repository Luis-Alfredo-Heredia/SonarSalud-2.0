package sonar_salud.startSession;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import sonar_salud.constants.EndpointPaths;
import sonar_salud.constants.JsonPropertyName;
import sonar_salud.entity.User;

// TODO: Auto-generated Javadoc
/**
 * The Class AlertsService.
 */
public class InicioSesionSrvice {

	private InicioSesionSrvice() {
	}

	/**
	 * Lee un archivo JSON que contiene una lista de usuarios y busca si existe un
	 * usuario con el nombre dado.
	 *
	 * @param nick the nick
	 * @return true si el usuario existe y coincide la contraseña.
	 */
	public static boolean isUserByPassword(String email,String password ) {


		Gson gson = new Gson();
		try (FileReader reader = new FileReader(EndpointPaths.DATA_USERS)) {

			Type typeListUsers = new TypeToken<List<User>>() {}.getType();
			 List<User> userList = gson.fromJson(reader, typeListUsers);

			 for (User user : userList) {

				 if (email.equals(user.getEmail())) {
						System.out.print("entro con email: "+user.getEmail());
					 if(password.equals(user.getPassword())){
							System.out.print("entro con password: " +user.getPassword());
							return true;
					 }

		                
		            }
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;

	}
	public static String textData(String data, String id) {

		String datoReturn="";
		Gson gson = new Gson();
		try (FileReader reader = new FileReader(EndpointPaths.DATA_TEXTS)) {
			Type typeListTexts = new TypeToken<List<Map<String, String>>>() {}.getType();
			List<Map<String, String>> listTexts = gson.fromJson(reader, typeListTexts);
			for (Map<String, String> text : listTexts) {
				if (id.equalsIgnoreCase(text.get(JsonPropertyName.ID
						
						)))  {
					
					datoReturn=text.get(data);
					
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return datoReturn;

	}
	public static User userData(String email) {
		User user=null;
		Gson gson = new Gson();
		try (FileReader reader = new FileReader(EndpointPaths.DATA_USERS)) {
			Type typeListTexts = new TypeToken<List<User>>() {}.getType();
			List<User> listDatas = gson.fromJson(reader, typeListTexts);
			for (User datas : listDatas) {

				if (email.equals(datas.getEmail()))  {
					user= new User();
					user.setId(datas.getId());
					user.setBirthDate(datas.getBirthDate());
					user.setNick(datas.getNick());
					user.setGender(datas.getGender());
					user.setAge(datas.getAge());
					user.setName(datas.getName());
					user.setPhone(datas.getPhone());
					user.setEmail(datas.getEmail());
					user.setLastname(datas.getLastname());
					user.setNationality(datas.getNationality());
					user.setPostal_code(datas.getPostal_code());
					user.setProfession(datas.getProfession());
					user.setCivil_status(datas.getCivil_status());
					user.setPassword(datas.getPassword());
					user.setDiagnosis(datas.getDiagnosis());
					

					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return user;

	}
	public static void updateUserData(User updatedUser) {
        Gson gson = new Gson();

        try (FileReader reader = new FileReader(EndpointPaths.DATA_USERS)) {
            Type typeListUsers = new TypeToken<List<User>>() {}.getType();
            List<User> userList = gson.fromJson(reader, typeListUsers);

            for (User user : userList) {
                if (updatedUser.getId().equals(user.getId())) {
                    // Actualiza los datos del usuario
                    
                    user.setBirthDate(updatedUser.getBirthDate());
					user.setNick(updatedUser.getNick());
					user.setGender(updatedUser.getGender());
					user.setAge(updatedUser.getAge());
					user.setName(updatedUser.getName());
					user.setPhone(updatedUser.getPhone());
					user.setEmail(updatedUser.getEmail());
					user.setLastname(updatedUser.getLastname());
					user.setNationality(updatedUser.getNationality());
					user.setPostal_code(updatedUser.getPostal_code());
					user.setProfession(updatedUser.getProfession());
					user.setCivil_status(updatedUser.getCivil_status());
					user.setPassword(updatedUser.getPassword());
					//user.setDiagnosis(updatedUser.getDiagnosis());

                    // Guarda los cambios en el archivo JSON
                    saveUserListToFile(userList);
                    break;
                }
            }
        } catch (IOException e) {
            System.out.print("Problemas al actualizar datos");
            e.printStackTrace();
        }	
	}	
    private static void saveUserListToFile(List<User> userList) {
        Gson gson = new Gson();

        try (FileWriter writer = new FileWriter(EndpointPaths.DATA_USERS)) {
            gson.toJson(userList, writer);
        } catch (IOException e) {
            System.out.print("Problemas al guardar cambios en el archivo");
            e.printStackTrace();
        }
    }
	
	
}