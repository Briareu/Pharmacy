package classes;

public class Manufacture {
	public String Chemical_manufacture_no;
	public String Chemical_manufacture_name;
	public String Chemical_manufacture_tel;
	public String Chemical_manufacture_email;
	
	public Manufacture(String no, String name, String tel, String email) {
		Chemical_manufacture_no = no;
		Chemical_manufacture_name = name;
		Chemical_manufacture_tel = tel;
		Chemical_manufacture_email = email;
	}
	
	public Manufacture(Manufacture temp) {
		Chemical_manufacture_no = temp.getChemical_menufacture_no();
		Chemical_manufacture_name = temp.getChemical_manufacture_name();
		Chemical_manufacture_tel = temp.getChemical_manufacture_tel();
		Chemical_manufacture_email = temp.getChemical_manufacture_email();
	}
	
	public String getChemical_menufacture_no() {
		return Chemical_manufacture_no;
	}
	public void setChemical_menufacture_no(String chemical_menufacture_no) {
		Chemical_manufacture_no = chemical_menufacture_no;
	}
	public String getChemical_manufacture_name() {
		return Chemical_manufacture_name;
	}
	public void setChemical_manufacture_name(String chemical_manufacture_name) {
		Chemical_manufacture_name = chemical_manufacture_name;
	}
	public String getChemical_manufacture_tel() {
		return Chemical_manufacture_tel;
	}
	public void setChemical_manufacture_tel(String chemical_manufacture_tel) {
		Chemical_manufacture_tel = chemical_manufacture_tel;
	}
	public String getChemical_manufacture_email() {
		return Chemical_manufacture_email;
	}
	public void setChemical_manufacture_email(String chemical_manufacture_email) {
		Chemical_manufacture_email = chemical_manufacture_email;
	}
}
