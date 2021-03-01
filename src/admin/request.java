package admin;

public class request {
	private String hosp_name;
	private String name;
	private String fathers_name;
	private String mothers_name;
	private String birth_place;
	private String dob;
	private String gender;
	private String address;
    private String phone;
    private String email;
    private String height;
    private String weight;
    private String day;
    private String time;
    
    
    
	public request(String hosp_name,String name, String fathers_name, String mothers_name, String birth_place, String dob, String gender,
			String address, String phone, String email, String height, String weight, String day, String time) {
		super();
		this.hosp_name=hosp_name;
		this.name = name;
		this.fathers_name = fathers_name;
		this.mothers_name = mothers_name;
		this.birth_place = birth_place;
		this.dob = dob;
		this.gender = gender;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.height = height;
		this.weight = weight;
		this.day = day;
		this.time = time;
	}



	public String getHosp_name() {
		return hosp_name;
	}

	public String getName() {
		return name;
	}



	public String getFathers_name() {
		return fathers_name;
	}



	public String getMothers_name() {
		return mothers_name;
	}



	public String getBirth_place() {
		return birth_place;
	}



	public String getDob() {
		return dob;
	}



	public String getGender() {
		return gender;
	}



	public String getAddress() {
		return address;
	}



	public String getPhone() {
		return phone;
	}



	public String getEmail() {
		return email;
	}



	public String getHeight() {
		return height;
	}



	public String getWeight() {
		return weight;
	}



	public String getDay() {
		return day;
	}



	public String getTime() {
		return time;
	}

}
