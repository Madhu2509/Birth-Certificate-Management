package admin;

public class dbretrive {
	private String hosp_name;
	private String email;
	public String getHosp_name() {
		return hosp_name;
	}
	public void setHosp_name(String hosp_name) {
		this.hosp_name = hosp_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public dbretrive(String hosp_name, String email) {
		super();
		this.hosp_name = hosp_name;
		this.email = email;
	}

}
