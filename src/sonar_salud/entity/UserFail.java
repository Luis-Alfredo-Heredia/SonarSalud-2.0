/*
 * Modify: 17 nov 2023
 * Author: Calle Serrano, Ángel
 * User.java
 */
package sonar_salud.entity;

/**
 * The Class User.
 * 
 * User Entity This file contains all the properties of a user.
 */
public class UserFail {

	/** The id. */
	private String id;

	/** The name. */
	private String name;

	/** The last name. */
	private String lastName;

	/** The birth date. */
	private String birthDate;

	/** The gender. */
	private String gender;

	/** The nick. */
	private String nick;

	/** The password. */
	private String password;
	
	private String age;
	
	private String phone;
	
	private String email;
	

	/**
	 * Instantiates a new user.
	 *
	 * @param id        the id
	 * @param name      the name
	 * @param lastName  the last name
	 * @param birthDate the birth date
	 * @param gender    the gender
	 * @param nick      the nick
	 * @param password  the password
	 */


	/**
	 * Instantiates a new register.
	 *
	 * @param name      the name
	 * @param lastName  the last name
	 * @param birthDate the birth date
	 * @param gender    the gender
	 * @param nick      the nick
	 * @param password  the password
	 */
	public UserFail(String name, String lastName, String birthDate, String gender, String nick, String password) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.gender = gender;
		this.nick = nick;
		this.password = password;
	}

	public UserFail(String id, String name, String lastName, String birthDate, String gender, String nick, String password,
			String age, String phone, String email) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.gender = gender;
		this.nick = nick;
		this.password = password;
		this.age = age;
		this.phone = phone;
		this.email = email;
	}

	public UserFail(String id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}

	/**
	 * Instantiates a new user.
	 */
	public UserFail() {
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param string the new id
	 */


	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the birth date.
	 *
	 * @return the birth date
	 */
	public String getBirthDate() {
		return birthDate;
	}

	/**
	 * Sets the birth date.
	 *
	 * @param birthDate the new birth date
	 */
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Sets the gender.
	 *
	 * @param gender the new gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Gets the nick.
	 *
	 * @return the nick
	 */
	public String getNick() {
		return nick;
	}

	/**
	 * Sets the nick.
	 *
	 * @param nick the new nick
	 */
	public void setNick(String nick) {
		this.nick = nick;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", lastName=" + lastName + ", birthDate=" + birthDate + ", gender="
				+ gender + ", nick=" + nick + ", password=" + password + "]";
	}

}
