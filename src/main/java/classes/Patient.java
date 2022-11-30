package classes;

public class Patient {
	public String Patient_no;
	public String Patient_name;
	public String Patient_sex;
	public int Patient_age;
	public String Patient_tel;
	public String Patient_add;
	
	public Patient(String no, String name, String sex, int age, String tel, String add) {
		Patient_no = no;
		Patient_name = name;
		Patient_sex = sex;
		Patient_age = age;
		Patient_tel = tel;
		Patient_add = add;
	}
	
	public Patient(Patient temp) {
		Patient_no = temp.getPatient_no();
		Patient_name = temp.getPatient_name();
		Patient_sex = temp.getPatient_sex();
		Patient_age = temp.getPatient_age();
		Patient_tel = temp.getPatient_tel();
		Patient_add = temp.getPatient_add();
	}
	
	public String getPatient_no() {
		return Patient_no;
	}
	public void setPatient_no(String patient_no) {
		Patient_no = patient_no;
	}
	public String getPatient_name() {
		return Patient_name;
	}
	public void setPatient_name(String patient_name) {
		Patient_name = patient_name;
	}
	public String getPatient_sex() {
		return Patient_sex;
	}
	public void setPatient_sex(String patient_sex) {
		Patient_sex = patient_sex;
	}
	public int getPatient_age() {
		return Patient_age;
	}
	public void setPatient_age(int patient_age) {
		Patient_age = patient_age;
	}
	public String getPatient_tel() {
		return Patient_tel;
	}
	public void setPatient_tel(String patient_tel) {
		Patient_tel = patient_tel;
	}
	public String getPatient_add() {
		return Patient_add;
	}
	public void setPatient_add(String patient_add) {
		Patient_add = patient_add;
	}
}
