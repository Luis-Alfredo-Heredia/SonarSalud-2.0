package sonar_salud.entity;

public class User {
	 private String id;
	    private String name;
	    private String lastname;
	    private String nick;
	    private String birthDate;
	    private String age;
	    private String gender;
	    private String nationality;
	    private String postal_code;
	    private String profession;
	    private String civil_status;
	    private String phone;
	    private String email;
	    private String password;
	    private Diagnosis diagnosis;
	    
	    public User(String id, String name, String lastname, String nick, String birthDate, String age, String gender, String phone, String email, String password, Diagnosis diagnosis) {
	        this.id = id;
	        this.name = name;
	        this.lastname = lastname;
	        this.nick = nick;
	        this.birthDate = birthDate;
	        this.age = age;
	        this.gender = gender;
	        this.phone = phone;
	        this.email = email;
	        this.password = password;
	        this.diagnosis = diagnosis;
	    }
	    
	    
	    

	    public User(String id, String name, String lastname, String nick, String birthDate, String age, String gender,
				String nationality, String postal_code, String profession, String civil_status, String phone,
				String email, String password, Diagnosis diagnosis) {
			super();
			this.id = id;
			this.name = name;
			this.lastname = lastname;
			this.nick = nick;
			this.birthDate = birthDate;
			this.age = age;
			this.gender = gender;
			this.nationality = nationality;
			this.postal_code = postal_code;
			this.profession = profession;
			this.civil_status = civil_status;
			this.phone = phone;
			this.email = email;
			this.password = password;
			this.diagnosis = diagnosis;
		}




		public User() {
			super();
		}



		public String getId() {
	        return id;
	    }

	    public void setId(String id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getLastname() {
	        return lastname;
	    }

	    public void setLastname(String lastname) {
	        this.lastname = lastname;
	    }

	    public String getNick() {
	        return nick;
	    }

	    public void setNick(String nick) {
	        this.nick = nick;
	    }

	    public String getBirthDate() {
	        return birthDate;
	    }

	    public void setBirthDate(String birthDate) {
	        this.birthDate = birthDate;
	    }

	    public String getAge() {
	        return age;
	    }

	    public void setAge(String age) {
	        this.age = age;
	    }

	    public String getGender() {
	        return gender;
	    }

	    public void setGender(String gender) {
	        this.gender = gender;
	    }
	    
	    

	    public String getNationality() {
			return nationality;
		}




		public void setNationality(String nationality) {
			this.nationality = nationality;
		}




		public String getPostal_code() {
			return postal_code;
		}




		public void setPostal_code(String postal_code) {
			this.postal_code = postal_code;
		}




		public String getProfession() {
			return profession;
		}




		public void setProfession(String profession) {
			this.profession = profession;
		}




		public String getCivil_status() {
			return civil_status;
		}




		public void setCivil_status(String civil_status) {
			this.civil_status = civil_status;
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

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public Diagnosis getDiagnosis() {
	        return diagnosis;
	    }

	    public void setDiagnosis(Diagnosis diagnosis) {
	        this.diagnosis = diagnosis;
	    }




		@Override
		public String toString() {
			return "User [id=" + id + ", name=" + name + ", lastname=" + lastname + ", nick=" + nick + ", birthDate="
					+ birthDate + ", age=" + age + ", gender=" + gender + ", nationality=" + nationality
					+ ", postal_code=" + postal_code + ", profession=" + profession + ", civil_status=" + civil_status
					+ ", phone=" + phone + ", email=" + email + ", password=" + password + ", diagnosis=" + diagnosis
					+ "]";
		}



	    
	    

	}


