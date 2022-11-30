package classes;

public class Storage {
	public String Chemical_no;
	public String Warehouse_no;
	public int Chemical_number;
	public String Warehouse_name;
	
	public Storage(String C_n, String W_n, int number, String name) {
		Chemical_no = C_n;
		Warehouse_no = W_n;
		Chemical_number = number;
		Warehouse_name = name;
	}
	
	public Storage(Storage temp) {
		Chemical_no = temp.getChemical_no();
		Warehouse_no = temp.getWarehouse_no();
		Chemical_number = temp.getChemical_number();
		Warehouse_name = temp.getWarehouse_name();
	}
	
	public String getChemical_no() {
		return Chemical_no;
	}
	public void setChemical_no(String chemical_no) {
		Chemical_no = chemical_no;
	}
	public String getWarehouse_no() {
		return Warehouse_no;
	}
	public void setWarehouse_no(String warehouse_no) {
		Warehouse_no = warehouse_no;
	}
	public int getChemical_number() {
		return Chemical_number;
	}
	public void setChemical_number(int chemical_number) {
		Chemical_number = chemical_number;
	}
	public String getWarehouse_name() {
		return Warehouse_name;
	}
	public void setWarehouse_name(String warehouse_name) {
		Warehouse_name = warehouse_name;
	}
}
