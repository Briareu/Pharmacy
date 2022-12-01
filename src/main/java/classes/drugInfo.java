package classes;

import java.sql.Time;
import java.util.Date;

public class drugInfo {
	public String Chemical_no;
	public String Chemical_name;
	public String Chemical_type;
	public String Chemical_standard;
	public String Chemical_manufacture_no;
	public String Chemical_buy_price;
	public String Chemical_sell_price;
	public Time Chemical_product_date;
	public Time Chemical_validity_date;
	public Date product;
	public Date validity;
	public String product_date;
	public String validity_date;
	
	public drugInfo(String C_no, String C_name, String C_type, String C_standard, String C_m_no, 
			String C_b_p, String C_s_p, Time C_p_d, Time C_v_d, Date p, Date v) {
		Chemical_no = C_no;
		Chemical_name = C_name;
		Chemical_type = C_type;
		Chemical_standard = C_standard;
		Chemical_manufacture_no = C_m_no;
		Chemical_buy_price = C_b_p;
		Chemical_sell_price = C_s_p;
		Chemical_product_date = C_p_d;
		Chemical_validity_date = C_v_d;
		product = p;
		validity = v;
		
		product_date = product.toString() + " " + Chemical_product_date.toString();
		validity_date = validity.toString() + " " + Chemical_validity_date.toString();
	}

	public drugInfo(drugInfo temp) {
		Chemical_no = temp.getChemical_no();
		Chemical_name = temp.getChemical_name();
		Chemical_type = temp.getChemical_type();
		Chemical_standard = temp.getChemical_standard();
		Chemical_manufacture_no = temp.getChemical_manufacture_no();
		Chemical_buy_price = temp.getChemical_buy_price();
		Chemical_sell_price = temp.getChemical_sell_price();
		Chemical_product_date = temp.getChemical_product_date();
		Chemical_validity_date = temp.getChemical_validity_date();
		product = temp.getProduct();
		validity = temp.getValidity();
		product_date = temp.getProduct_date();
		validity_date = temp.getValidity_date();
	}
	
	public String getChemical_no() {
		return Chemical_no;
	}
	public void setChemical_no(String chemical_no) {
		Chemical_no = chemical_no;
	}
	public String getChemical_name() {
		return Chemical_name;
	}
	public void setChemical_name(String chemical_name) {
		Chemical_name = chemical_name;
	}
	public String getChemical_type() {
		return Chemical_type;
	}
	public void setChemical_type(String chemical_type) {
		Chemical_type = chemical_type;
	}
	public String getChemical_standard() {
		return Chemical_standard;
	}
	public void setChemical_standard(String chemical_standard) {
		Chemical_standard = chemical_standard;
	}
	public String getChemical_manufacture_no() {
		return Chemical_manufacture_no;
	}
	public void setChemical_manufacture_no(String chemical_manufacture_no) {
		Chemical_manufacture_no = chemical_manufacture_no;
	}
	public String getChemical_buy_price() {
		return Chemical_buy_price;
	}
	public void setChemical_buy_price(String chemical_buy_price) {
		Chemical_buy_price = chemical_buy_price;
	}
	public String getChemical_sell_price() {
		return Chemical_sell_price;
	}
	public void setChemical_sell_price(String chemical_sell_price) {
		Chemical_sell_price = chemical_sell_price;
	}
	public Time getChemical_product_date() {
		return Chemical_product_date;
	}
	public void setChemical_product_date(Time chemical_product_date) {
		Chemical_product_date = chemical_product_date;
	}
	public Time getChemical_validity_date() {
		return Chemical_validity_date;
	}
	public void setChemical_validity_date(Time chemical_validity_date) {
		Chemical_validity_date = chemical_validity_date;
	}
	
	public Date getProduct() {
		return product;
	}

	public void setProduct(Date product) {
		this.product = product;
	}

	public Date getValidity() {
		return validity;
	}

	public void setValidity(Date validity) {
		this.validity = validity;
	}

	public String getProduct_date() {
		return product_date;
	}

	public void setProduct_date(String product_date) {
		this.product_date = product_date;
	}

	public String getValidity_date() {
		return validity_date;
	}

	public void setValidity_date(String validity_date) {
		this.validity_date = validity_date;
	}
}
