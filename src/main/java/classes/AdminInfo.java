package classes;

public class AdminInfo {
	public String Admin_no;
	public String Admin_name;
	public String Pass_word;
	
	public AdminInfo(String no, String name, String word) {
		Admin_no = no;
		Admin_name = name;
		Pass_word = word;
	}
	
	public String getAdmin_no() {
		return Admin_no;
	}
	public void setAdmin_no(String admin_no) {
		Admin_no = admin_no;
	}
	public String getAdmin_name() {
		return Admin_name;
	}
	public void setAdmin_name(String admin_name) {
		Admin_name = admin_name;
	}
	public String getPass_word() {
		return Pass_word;
	}
	public void setPass_word(String pass_word) {
		Pass_word = pass_word;
	}
	
}
